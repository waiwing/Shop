package com.waiwing.Shop.core.interceptors;

import com.auth0.jwt.interfaces.Claim;
import com.waiwing.Shop.exception.http.ForbiddenException;
import com.waiwing.Shop.exception.http.UnAuthenticatedException;
import com.waiwing.Shop.util.JwtToken;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;


public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<ScopeLevel> scopeLevelOpt = this.getScopeLevel(handler);
        if (!scopeLevelOpt.isPresent()) {
            return true;
        }
        ScopeLevel  scopeLevel = scopeLevelOpt.get();

        String token = request.getHeader("Authorization");
        if (StringUtils.isEmpty(token)) {
            throw new UnAuthenticatedException(10004);
        }

        if (!token.startsWith("Bearer")) {
            throw new UnAuthenticatedException(10004);
        }

        String[] tokenSplis = token.split(" ");
        if(tokenSplis.length!=2){
            throw new UnAuthenticatedException(10004);
        }
        String jwtToken = tokenSplis[1];
        Optional<Map<String, Claim>> optionClaims = JwtToken.getClaims(jwtToken);
        Map<String, Claim> claims = optionClaims.orElseThrow(()-> new UnAuthenticatedException(10004));

        boolean valid = this.hasPermission(scopeLevel,claims);
        //检查权限
        return true;
    }

    /**
     * 权限判断
     * @param scopeLevel
     * @param claimsMap
     * @return
     */
    private boolean hasPermission(ScopeLevel scopeLevel,  Map<String, Claim> claimsMap ){
        Integer level = scopeLevel.value();
        Integer scope = claimsMap.get("scope").asInt();

        if(level> scope){
            throw new ForbiddenException(10005);
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private Optional<ScopeLevel> getScopeLevel(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ScopeLevel scopeLevel = handlerMethod.getMethod().getAnnotation(ScopeLevel.class);
           if(scopeLevel == null){
               return Optional.empty();
           }
            return Optional.of(scopeLevel);
        }

        return Optional.empty();
    }
}
