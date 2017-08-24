package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.utils.UUIDUtil;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.common.utils.junit.JunitTestParent;
import com.cachexic.sjdbc.order.entity.TestUuidEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@ActiveProfiles("dev")
public class TestUuidEntityDaoTest extends JunitTestParent {

    @Autowired
    private TestUuidEntityDao testUuidEntityDao;



    @Test
    public void insert() throws Exception {

        for(int i=1;i<101;i++){
            TestUuidEntity entity = new TestUuidEntity();
            entity.setId(UUIDUtil.getUUID());
            entity.setSeq(i);
            testUuidEntityDao.insert(entity);
        }
    }

    @Test
    public void selectTest() throws Exception {
        List<TestUuidEntity> object = testUuidEntityDao.selectTest();
        System.out.println(JsonUtil.toJson(object));
        System.out.println(object.size());
    }

    @Test
    public void selectTestOrderById() throws Exception {
        System.out.println(JsonUtil.toJson(testUuidEntityDao.selectTestOrderById()));
    }

    @Test
    public void selectTestOrderByIdLimit() throws Exception {
        System.out.println(JsonUtil.toJson(testUuidEntityDao.selectTestOrderByIdLimit(0L,10)));
    }

}