package com.cachexic.sjdbc.common.utils.id;

import java.util.UUID;

/**
 * Created by tangm on 2017/8/24.
 */
public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
}
