package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.junit.JunitTestParent;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.order.entity.Role;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by tangm on 2017/8/20.
 */
@ActiveProfiles("dev")
public class RoleTest extends JunitTestParent {

    @Autowired
    private RoleDao roleDao;



    @Test
    public void insert() throws Exception {

        for(int i=1;i<11;i++){
            Role entity = new Role();
            entity.setSeq(i);
            roleDao.insert(entity);
        }
    }

    @Test
    public void selectTest() throws Exception {
        List<Role> object = roleDao.selectTest();
        System.out.println(JsonUtil.toJson(object));
        System.out.println(object.size());
    }

    @Test
    public void selectTestOrderById() throws Exception {
        System.out.println(JsonUtil.toJson(roleDao.selectTestOrderById()));
    }

    @Test
    public void selectTestOrderByIdLimit() throws Exception {
        System.out.println(JsonUtil.toJson(roleDao.selectTestOrderByIdLimit(0L,10)));
    }

    @Test
    public void testMock() throws Exception {
        Role mock = mock(Role.class);
        when(mock.getSeq()).thenReturn(1);
        assertThat("bu shi de ",mock.getSeq(), Is.is(1));
    }
}