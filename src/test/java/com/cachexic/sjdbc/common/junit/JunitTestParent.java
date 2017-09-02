package com.cachexic.sjdbc.common.junit;

import com.cachexic.sjdbc.common.exceptions.BizException;
import com.cachexic.sjdbc.common.exceptions.BizPreconditions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

/**
 * 测试父类,测试例子请看com.cachexic.sjdbc.common.junit.example包下的例子
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class JunitTestParent {

    @Test(expected = BizException.class)
    public void staticImportAssertAndMockito(){
        mock(Object.class);
        doNothing();
        assertFalse(false);
        assertThat(1, is(1));
        assertEquals("ABC","ABC");
        BizPreconditions.checkState(false,"密码错误");
    }

}
