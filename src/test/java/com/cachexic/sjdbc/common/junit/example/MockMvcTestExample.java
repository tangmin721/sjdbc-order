package com.cachexic.sjdbc.common.junit.example;

import com.cachexic.sjdbc.common.core.Result;
import com.cachexic.sjdbc.common.junit.JunitTestParent;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.order.entity.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tangmin
 * @version V1.0
 * @Title: MockMvcTestExample.java
 * @Package com.cachexic.sjdbc.common.junit.example
 * @Description: 
 * @date 2017-09-02 13:54:45
 */
public class MockMvcTestExample extends JunitTestParent {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        //构造MockMvc
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    /**
     * get获取
     * @throws Exception
     */
    @Test
    public void getOrderList() throws Exception {
        MvcResult result = mockMvc.perform(
                //构造一个请求
                MockMvcRequestBuilders
                    .get("/order/getOrderList")
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())//添加结果处理器，用于对验证成功后执行的动作，如输出下请求/结果信息用于调试；
                .andExpect(status().isOk())//添加验证断言来判断执行请求后的结果是否是预期的；
                .andReturn();//返回验证成功后的MvcResult；用于自定义验证/下一步的异步处理；

        MockHttpServletResponse response = result.getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);

        Result toEntityResult = JsonUtil.toEntity(contentAsString, Result.class);
        List<Order> orders = JsonUtil.toList(toEntityResult.getData(),Order.class);
        for (Order order : orders) {
            System.out.println("orderId:"+order.getId());
        }

        //Assert.assertThat(orders.size(), Is.is(6));
        Assert.assertTrue(orders.size()>0);
    }

    /**
     * post @RequestBody 新增
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        Order order = new Order();
        order.setOrderSn("mockordersn-1");
        order.setUserId(1L);

        MvcResult result = mockMvc.perform(
                //构造一个请求
                MockMvcRequestBuilders
                        .post("/order/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(order))//转化为requestBody
        )
                .andDo(MockMvcResultHandlers.print())//添加结果处理器，用于对验证成功后执行的动作，如输出下请求/结果信息用于调试；
                .andExpect(status().isOk())//添加验证断言来判断执行请求后的结果是否是预期的；
                .andReturn();//返回验证成功后的MvcResult；用于自定义验证/下一步的异步处理；

        MockHttpServletResponse response = result.getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);

    }
}
