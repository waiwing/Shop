package com.waiwing.Shop.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waiwing.Shop.exception.http.ServerErrorException;
import com.waiwing.Shop.model.Spec;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAndJson implements AttributeConverter<List<Object>, String> {

    @Autowired
    private ObjectMapper mapper;


    @Override
    public String convertToDatabaseColumn(List<Object> specs) {

        try {
            String s = mapper.writeValueAsString(specs);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public List<Object> convertToEntityAttribute(String s) {
        if (s == null || s.equals(""))
            return new ArrayList<Object>(0);

        try {
            List<Object> t = mapper.readValue(s, List.class);
            return t;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
