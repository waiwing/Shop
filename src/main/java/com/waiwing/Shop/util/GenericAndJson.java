package com.waiwing.Shop.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waiwing.Shop.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import  com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

@Component
public class GenericAndJson {
    private static ObjectMapper mapper;

    @Autowired
    public  void setMapper(ObjectMapper mapper) {
        GenericAndJson.mapper = mapper;
    }

    public static<T> String objectToJson(T t){
        try {
            String s = mapper.writeValueAsString(t);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw  new ServerErrorException(9999);
        }
    }

    public static <T> T jsonToObject(String str,TypeReference<T> t){
        if(str== null)
            return null;
        try {
            T o = mapper.readValue(str,t);
            return o;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw  new ServerErrorException(9999);
        }
    }

//    public static <T> List<T> jsonToList(String str){
//        if(str== null)
//            return null;
//        try {
//            List<T> o = mapper.readValue(str,new TypeReference<List<T>>(){});
//            return o;
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw  new ServerErrorException(9999);
//        }
//    }
}
