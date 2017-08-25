package com.cachexic.sjdbc.common.utils.json;

import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: JsonUtil.java
 * @Package com.gasq.cloud.common.utils.json
 * @Description: 工具类：
 * @date 2017-05-04 14:04:23
 */
public class JsonUtil {

    /*** 将对象序列化为JSON文本 */
    public static <T> String toJson(Object object) {
        return JsonMapper.nonNullMapper().toJson(object);
    }

    /***
     * 将字符串==>转换为传入类型的对象
     * @param
     * @param json
     * @param beanClass
     * @return
     */
    public static <T> T toEntity(String json, Class<T> beanClass) {
        return JsonMapper.nonNullMapper().fromJson(json,beanClass);
    }

    /***
     * 将Object对象==>转换为传入类型的对象
     * @param
     * @param object
     * @param beanClass
     * @return
     */
    public static <T> T toEntity(Object object, Class<T> beanClass) {
        return JsonMapper.nonNullMapper().fromJson(toJson(object),beanClass);
    }

    /***
     * 将字符串==>转换为传入类型的List
     * @param
     * @param objectClass
     * @return
     */
    public static <T> List<T> toList(String jsonString, Class<T> objectClass){
        return JsonMapper.nonNullMapper().fromJsonToList(jsonString,objectClass);
    }

    /***
     * 将object对象=>转换为传入类型的List
     * @param
     * @param objectClass
     * @return
     */
    public static <T> List<T> toList(Object object, Class<T> objectClass) {
        return toList(toJson(object),objectClass);
    }

}