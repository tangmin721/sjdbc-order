package com.cachexic.sjdbc.order.controller;

import com.cachexic.sjdbc.common.core.Pagination;
import com.cachexic.sjdbc.common.core.Result;
import com.cachexic.sjdbc.common.exceptions.BizPreconditions;
import com.cachexic.sjdbc.order.dao.OrderDao;
import com.cachexic.sjdbc.order.entity.Order;
import com.cachexic.sjdbc.order.entity.query.OrderQuery;
import com.cachexic.sjdbc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDao orderDao;

    @PostMapping("insert")
    public Result<String> insert(@RequestBody Order order){
        return Result.OK().setData(orderService.insert(order));
    }

    //@RequestMapping(value = {"test","test1","test2"},method = RequestMethod.GET)   配置多种路径都访问同一个方法
    // @RequestMapping("/test",method = RequestMethod.GET)
    @GetMapping("getById/{id}")
    public Result<Order>  getOrderById(@PathVariable("id") Long id){
        return Result.OK().setData(this.orderDao.selectById(id));
    }

    @GetMapping("result")
    @ResponseBody
    public Result result(){
        BizPreconditions.checkArgument(1==0);
        return Result.OK();
    }

    @GetMapping("getOrderList")
    public Result<List<Order>>  getOrderList(){
        List<Order> orders = orderService.selectList();
        return  Result.OK().setData(orders);
    }

    @RequestMapping("selectPagination")
    public Result<Pagination<Order>> selectPagination(@RequestBody OrderQuery orderQuery){
       /* if(orderQuery!=null){
            //throw new BizException(BizExceptionEnum.PARAMETER_ERROR.getCode(), "测试统一异常处理");
            Preconditions.checkArgument(false,"测试另外的异常");
        }*/
        return  Result.OK().setData(orderService.selectPagination(orderQuery));
    }

}