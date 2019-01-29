package com.inofd.exception;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器
 */
public class RRExceptionHandler {

    /**
     * 处理自定义异常
     */
    public Map<String,Object> handleRRException(RRException e){
        Map<String,Object> map = new HashMap<>();
        map.put("msg", e.getMsg());
        map.put("code", e.getCode());
        return map;
    }
}