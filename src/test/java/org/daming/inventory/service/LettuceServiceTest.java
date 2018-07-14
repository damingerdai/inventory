package org.daming.inventory.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-08 21:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LettuceServiceTest {

    @Autowired
    private RedisService lettuceService;

    @Test
    public void testGet() {
        Object value = "daming";
        lettuceService.set("daming", value);
        Object newValue = lettuceService.get("daming");
        Assert.assertEquals(value, newValue);
    }
}
