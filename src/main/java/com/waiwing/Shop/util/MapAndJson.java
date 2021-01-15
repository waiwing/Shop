package com.waiwing.Shop.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waiwing.Shop.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

public class MapAndJson  implements AttributeConverter<Map<String,Object>,String> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            String s = mapper.writeValueAsString(stringObjectMap);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
           throw  new ServerErrorException(9999);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            Map<String, Object> map =  mapper.readValue(s, HashMap.class);
            return map;
        } catch (JsonProcessingException e) {
            throw  new ServerErrorException(9999);
        }
    }
}
