package com.waiwing.Shop.service.WXAuthenticationService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.waiwing.Shop.exception.http.ParameterException;
import com.waiwing.Shop.model.User;
import com.waiwing.Shop.repository.UserRepository;
import com.waiwing.Shop.util.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Optional;

@Service
public class WxAuthenticationServiceImpl implements WxAuthenticationService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;

    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.appsecret}")
    private String secret;
    @Value("${wx.code2session}")
    private String code2SessionUrl;

    @Override
    public  String code2Session(String code) {
        String url = MessageFormat.format(this.code2SessionUrl, this.appid, this.secret, code);
        RestTemplate restTemplate = new RestTemplate();
        String text = restTemplate.getForObject(url, String.class);
        Map<String,Object> map  = null ;
      try {
          map =   objectMapper.readValue(text, Map.class);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }

      return  this.registerUser(map);
    }

    @Override
    public Boolean verfity(String token) {
       return JwtToken.verfity(token);
    }

    private String registerUser(Map<String,Object> session){
        String openid = (String)session.get("openid");
        if(openid == null)
            throw new ParameterException(20004);

        User user = null;
        Optional<User> userOptional =  userRepository.findUserByOpenid(openid);
        if (userOptional.isPresent()) {
            // todo 返回jwt.
            user = userOptional.get();
            return JwtToken.makeToekn(userOptional.get().getId());
        }else{
            user = User.builder()
                    .openid(openid)
                    .build();
            userRepository.save(user);
        }

        return JwtToken.makeToekn(user.getId());
    }
}
