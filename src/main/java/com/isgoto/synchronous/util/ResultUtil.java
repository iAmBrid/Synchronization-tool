package com.isgoto.synchronous.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {
    public static String success(){
        return success(null);
    }

    public static String success(Object returnValue) {
        Map<String, Object> result = new HashMap<>();
        result.put("success",true);
        result.put("message", JSONObject.toJSON(returnValue));
        return JSONObject.toJSONString(result);
    }

    public static String fail(){
        return fail(null);
    }

    public static String fail(Object returnValue) {
        Map<String, Object> result = new HashMap<>();
        result.put("success",false);
        result.put("message",JSONObject.toJSON(returnValue));
        return JSONObject.toJSONString(result);
    }
}
