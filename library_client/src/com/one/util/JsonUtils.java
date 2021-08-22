package com.one.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.domain.ResultInfo;

import java.io.IOException;

public class JsonUtils {



    public static ResultInfo parseResult(String json){

        ObjectMapper om = new ObjectMapper();
        ResultInfo resultInfo = null;
        try {
            resultInfo = om.readValue(json, ResultInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultInfo;
    }

}
