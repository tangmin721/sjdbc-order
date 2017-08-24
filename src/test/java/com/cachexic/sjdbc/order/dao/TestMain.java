package com.cachexic.sjdbc.order.dao;

/**
 * Created by tangm on 2017/8/24.
 */
public class TestMain {
    public static void main(String[] args) {
        int floorDiv = Math.floorDiv(-11, 2);
        System.out.println("floorDiv : " + floorDiv);//最大商
        System.out.println("floorMod : " + Math.floorMod(floorDiv,2L));//取模

        System.out.println(Long.valueOf(107495078775226368L).hashCode());
        System.out.println(Long.valueOf(107495078808780800L).hashCode());
        System.out.println("057e0a7c1ff14aa0ae4c40ce2620fe43".hashCode());
        System.out.println(Math.floorMod("107495078808780800L".toString().hashCode(),2L));
        System.out.println(Math.floorMod(Math.floorDiv(Long.valueOf(107495078808780800L).toString().hashCode(),2L),2L));

        System.out.println(Math.floorMod("107597344362463232".toString().hashCode(),2L));
        System.out.println(Math.floorMod(Math.floorDiv(Long.valueOf(107597344362463232L).toString().hashCode(),2L),2L));
    }
}
