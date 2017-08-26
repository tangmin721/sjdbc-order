package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.annotation.Entity;

import java.lang.annotation.Annotation;

/**
 * Created by tangm on 2017/8/26.
 */
public class TestAnnotataion {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.cachexic.sjdbc.order.entity.Order");

        //获取类的所有注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获取类指定注解
        Entity entity = clazz.getAnnotation(Entity.class);
        System.out.println(entity.value());
        System.out.println(entity.primaryKeyType());

        //Class.isAssignableFrom()是用来判断一个类Class1和另一个类Class2是否相同或是另一个类的子类或接口
        System.out.println(entity.primaryKeyType().isAssignableFrom(Long.class));

    }
}
