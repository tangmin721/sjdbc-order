package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.common.utils.junit.JunitTestParent;
import com.cachexic.sjdbc.order.entity.Menu;
import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@ActiveProfiles("dev")
public class MenuTest extends JunitTestParent {

    @Autowired
    private MenuDao menuDao;



    @Test
    public void insert() throws Exception {

        for(int i=1;i<11;i++){
            Menu entity = new Menu();
            entity.setSeq(i);
            menuDao.insert(entity);
        }
    }

    @Test
    public void selectTest() throws Exception {
        try (HintManager hintManager = HintManager.getInstance()){
            //hintManager.setMasterRouteOnly();//强制读主库
            List<Menu> object = menuDao.selectTest();
            System.out.println(JsonUtil.toJson(object));
            System.out.println(object.size());
        }
    }

    @Test
    public void selectTestOrderById() throws Exception {
        System.out.println(JsonUtil.toJson(menuDao.selectTestOrderById()));
    }

    @Test
    public void selectTestOrderByIdLimit() throws Exception {
        System.out.println(JsonUtil.toJson(menuDao.selectTestOrderByIdLimit(0L,10)));
    }

}