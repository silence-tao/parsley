package com.silentao.parsley.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Silence
 * @Date 2021/1/23 23:04
 **/
@Slf4j
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    static{
        //设置序列化配置，为null的属性不加入到json中
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //兼容单引号 但单引号不属于json标准 不建议使用
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //忽略空属性
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //设置日期属性的格式
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 将对象转换成json字符串,如果转换失败则返回null
     * @author zhaoyunxiao
     * @param o 需要转换为json的对象
     * @return String 转换后的json字符串
     *
     *
     * */
    public static String write2JsonStr(Object o){

        if (o == null){
            return "";
        }

        String jsonStr = "";
        try {
            jsonStr = mapper.writeValueAsString(o);
        } catch (Exception e) {
            log.error("write2JsonStr() exception: " + e.getMessage(), e);
        }
        return jsonStr;
    }

    /**
     * 将json转换为对象 如果对象模版为内部类会出现问题，所以不要使用内部类
     * @author zhaoyunxiao
     * @param json 要转换的json
     * @param clazz 要映射的类型
     * @return 转换成的目标对象，如果转换失败返回null
     * */
    public static Object json2Object(String json, Class<?> clazz){
        try {
            return mapper.readValue(json,clazz);
        } catch (JsonParseException e) {
            log.error("json2Object() parseException: " + e.getMessage());
        } catch (JsonMappingException e) {
            log.error("json2Object() mappingException: " + e.getMessage());
        } catch (IOException e) {
            log.error("json2Object() IOException: " + e.getMessage());
        }
        return null;
    }

    /**
     * 将JSON格式字符串转换成对象
     * @param jsonString
     * @param typeReference
     * @return
     */
    public static <T> T jsonStr2Object(String jsonString, TypeReference<T> typeReference) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        try {
            return (T) mapper.readValue(jsonString, typeReference);
        } catch (IOException e) {
            log.error("parse json string error:" + jsonString, e);
        }
        return null;
    }

    /**
     * 将json字符串转换为Map
     * @author zhaoyunxiao
     * @param  json 需要转换为Map的json字符串 {}开头结尾的
     * @return 转换后的map 如果转换失败返回null
     * */
    public static Map<String,Object> json2Map(String json){
        try {
            if(StringUtils.isBlank(json)) {
                return new HashMap<String,Object>() ;
            }
            return mapper.readValue(json,Map.class);
        } catch (JsonParseException e) {
            log.error("json2Map(), 出错的json内容：" + json + " ,JsonParseException: ", e);
        } catch (JsonMappingException e) {
            log.error("json2Map(), 出错的json内容：" + json + " ,JsonMappingException: ", e);
        } catch (IOException e) {
            log.error("json2Map(), 出错的json内容为：" + json + " ,IOException: ", e);
        }
        return new HashMap<String,Object>() ;
    }

    /**
     * 将对象转换为Map
     * @param o
     * @return
     */
    public static Map<String, Object> object2Map(Object o) {
        if (null == o) {
            return null;
        }
        return json2Map(write2JsonStr(o));
    }

    /**
     * 将json数组转换为List<Map<String,Object>> json数组格式[{},{}]
     * @author zhaoyunxiao
    //     * @param  需要转换的json数组
     * @return 转换后的列表   如果转换失败返回null
     * */
    public static List<Map<String,Object>> jsonArray2List(String jsonArray){
        try {
            return mapper.readValue(jsonArray, List.class);
        } catch (JsonParseException e) {
            log.error("jsonArray2List() exception, 异常字符串: " + jsonArray, e);
        } catch (JsonMappingException e) {
            log.error("jsonArray2List() exception, 异常字符串: " + jsonArray, e);
        } catch (IOException e) {
            log.error("jsonArray2List() exception",e);
        }
        return new ArrayList<Map<String,Object>>();
    }

    /**
     * 将json数组转换为List<Map<String,Object>> json数组格式[{},{}]
     * @author zhaoyunxiao
     * @param  jsonArray 需要转换的json数组
     * @return 转换后的列表   如果转换失败返回null
     * */
    public static List<Map<String,Object>> jsonArray2List(String jsonArray, String keyword){
        try {
            return mapper.readValue(jsonArray, List.class);
        } catch (JsonParseException e) {
            log.error("JsonTools exception, keyword: "+keyword+", 异常字符串: " + jsonArray, e);
        } catch (JsonMappingException e) {
            log.error("JsonTools exception, keyword: "+keyword+", 异常字符串: " + jsonArray, e);
        } catch (IOException e) {
            log.error("JsonTools exception",e);
        }
        return new ArrayList<Map<String,Object>>();
    }

    /**
     * 将json字符串转换为Map
     * @author zhaoyunxiao
     * @param  json 需要转换为Map的json字符串 {}开头结尾的
     * @return 转换后的map 如果转换失败返回null
     * */
    public static Map<String,Object> json2Map_feeinfo(String json){
        try {
            if(StringUtils.isBlank(json)) {
                return new HashMap<String,Object>() ;
            }
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true); //防止转义字符转换报错
            return mapper.readValue(json,Map.class);
        } catch (JsonParseException e) {
            log.error("json2Map_feeinfo(), 出错的json内容："  + " ,JsonParseException: " + e.getMessage());
        } catch (JsonMappingException e) {
            log.error("json2Map_feeinfo(), 出错的json内容："  + " ,JsonMappingException: " + e.getMessage());
        } catch (IOException e) {
            log.error("json2Map_feeinfo(), 出错的json内容为："  + " ,IOException: " + e.getMessage());
        }
        return new HashMap<String,Object>() ;
    }
}
