package com.jlpay.manage.sim.db.service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class TermConfigServiceTest {
    @Autowired
    private ITermConfigService iTermConfigService;

    @Test
    public void saveTest() {
        TermConfig termConfig = new TermConfig();
        termConfig.setTermNo("TermNo");
        termConfig.setKey("Key");
        termConfig.setValue("Value");
        termConfig.setCreatTime("CreatTime");
        termConfig.setUpdateTime("UpdateTime");
        termConfig.setCreatUser("CreatUser");
        termConfig.setUpdateUser("UpdateUser");
        termConfig.setRemark("Remark");
       
        Assert.assertEquals(1, iTermConfigService.update(termConfig));
    }

    @Test
    public void updateTest(){
        TermConfig termConfig = new TermConfig();
        termConfig.setTermNo("TermNo");
        termConfig.setKey("Key");
        termConfig.setValue("Value");
        termConfig.setCreatTime("CreatTime");
        termConfig.setUpdateTime("UpdateTime");
        termConfig.setCreatUser("CreatUser");
        termConfig.setUpdateUser("UpdateUser");
        termConfig.setRemark("Remark");
       
        Assert.assertEquals(1, iTermConfigService.update(termConfig));
    }

    @Test
    public void queryTest(){
        Assert.assertEquals("id", iTermConfigService.get("id").getTermNo());
    }
}