package com.waiwing.Shop.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.sql.Statement;
import java.util.*;

@Component
public class JwtToken {

    private static String jwtKey;
    private static Integer expiredTimeIn;
    private static Integer defaultScope = 8;

    @Value("${shop.security.token-expired-in}")
    public void setExpiredTimeIn(Integer expiredTimeIn) {
        JwtToken.expiredTimeIn = expiredTimeIn;
    }

    @Value("${shop.security.jwt-key}")
    public void setJwtKey(String jwtKey) {
        JwtToken.jwtKey = jwtKey;
    }

    public static String makeToekn(Long uid, Integer scope) {
        return JwtToken.getToken(uid, scope);
    }

    public static String makeToekn(Long uid) {
        return JwtToken.getToken(uid, JwtToken.defaultScope);
    }

    private static String getToken(Long uid, Integer scope) {
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        Map<String, Date> map = JwtToken.calculateExpiredIssues();

        String token = JWT.create()
                .withClaim("uid", uid)//写入自定义业务数据
                .withClaim("scope", scope)
                .withIssuedAt(map.get("now"))
                .withExpiresAt(map.get("expiredTime"))
                .sign(algorithm);
        return token;
    }

    private static Map<String, Date> calculateExpiredIssues() {
        Map<String, Date> map = new HashMap<String, Date>();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.SECOND, JwtToken.expiredTimeIn);
        map.put("now", now);
        map.put("expiredTime", calendar.getTime());
        return map;
    }


    //检验

    public static Optional<Map<String, Claim>> getClaims(String token) {
        DecodedJWT decodedJWT = null;
        //密钥算法
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        //认证方法
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();

        try {
            decodedJWT = jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
        return Optional.of(decodedJWT.getClaims());
    }

    public static Boolean verfity(String token) {
        //密钥算法
        Algorithm algorithm = Algorithm.HMAC256(JwtToken.jwtKey);
        //认证方法
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            if(decodedJWT == null){
                return  false;
            }
        } catch (JWTVerificationException e) {
            return false;
        }
        return  true;
    }

}
