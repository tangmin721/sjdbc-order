package com.cachexic.sjdbc.common.exceptions;

import com.cachexic.sjdbc.common.junit.JunitTestParent;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

/**
 * @author tangmin
 * @version V1.0
 * @Title: BizPreconditionsTest.java
 * @Package com.cachexic.sjdbc.common.exceptions
 * @Description: 测试用例
 * @date 2017-09-02 08:44:52
 */
public class BizPreconditionsTest extends JunitTestParent {
    @Test(expected = BizException.class)//期望抛出的异常
    public void checkArgument() throws Exception {
        String name = null;
        assertFalse(StringUtils.isNotBlank(name));//断言值false
        assertTrue(StringUtils.isBlank(name));//断言值true

        ArrayList<String> strings = Lists.newArrayList("tom", "jack");
        assertThat(strings,hasItem("tom"));//集合包含
        assertThat(strings.size(), is(2));//断言值为多少

        BizPreconditions.checkArgument(StringUtils.isNotBlank(name),"name不能为空");
    }

    @Test(expected = BizException.class)
    public void checkNotNull() throws Exception {
        BizPreconditions.checkNotNull(null);
    }

}