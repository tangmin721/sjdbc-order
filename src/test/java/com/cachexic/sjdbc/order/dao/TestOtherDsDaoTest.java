package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.common.utils.junit.JunitTestParent;
import com.cachexic.sjdbc.order.entity.TestOtherDs;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@ActiveProfiles("dev")
public class TestOtherDsDaoTest extends JunitTestParent {

    @Autowired
    private TestOtherDsDao testOtherDsDao;



    @Test
    public void insert() throws Exception {

        for(int i=1;i<101;i++){
            TestOtherDs entity = new TestOtherDs();
            entity.setSeq(i);
            testOtherDsDao.insert(entity);
        }
    }

    @Test
    public void selectTest() throws Exception {
        List<TestOtherDs> object = testOtherDsDao.selectTest();
        System.out.println(JsonUtil.toJson(object));
        System.out.println(object.size());
    }

    @Test
    public void selectTestOrderById() throws Exception {
        System.out.println(JsonUtil.toJson(testOtherDsDao.selectTestOrderById()));
    }

    @Test
    public void selectTestOrderByIdLimit() throws Exception {
        System.out.println(JsonUtil.toJson(testOtherDsDao.selectTestOrderByIdLimit(0L,10)));
    }

}