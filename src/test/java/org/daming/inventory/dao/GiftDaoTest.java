package org.daming.inventory.dao;

import org.daming.inventory.pojo.Gift;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class GiftDaoTest {

    private static Gift gift;

    @Autowired
    private GiftDao giftDao;

    @BeforeClass
    public static void init() {
        gift = new Gift();
        gift.setCode("001");
        gift.setName("daming");
    }

    @Test
    public void get() {
        Gift g = giftDao.get(2);
        assertNotNull("get gift is ok", g);
    }

    @Test
    public void create() {
        assertTrue("create gift is ok", giftDao.create(gift));
    }

    @Test
    public void edit() {
        Gift g = giftDao.get(2);
        String name = g.getName();
        g.setName(name + 2);
        giftDao.edit(g);
        g = giftDao.get(2);
        assertEquals(name + 2, g.getName());
    }

    @Test
    public void list() {
        List<Gift> gifts = giftDao.list();
        assertTrue("list gift is not ok", gifts.size() > 0);
        gifts.forEach(g -> assertNotNull("list gift element is null", g));
    }

    @Test
    public void like() {
        List<Gift> gifts = giftDao.like("花", 1, 5);
        assertTrue("list gift is not ok", gifts.size()  == 1);
        gifts.forEach(g -> assertEquals("狸花猫", g.getName()));
    }

    @Test
    public void delete() {
        int id = giftDao.list().stream().mapToInt(Gift::getId).max().orElse(0);
        if (id > 0) {
            giftDao.delete(id);
        }
    }

    @Test
    public void updateInventory() {
        int id = giftDao.list().stream().mapToInt(Gift::getId).max().orElse(0);
        if (id > 0) {
            Gift g = giftDao.get(id);
            int num = g.getNum() + 100;
            giftDao.updateInventory(id, num);
            assertTrue("updateInventory is error", giftDao.get(id).getNum() == num);
        }
    }

    @Test
    public void likeCount() {
        giftDao.likeCount("哈");
        assertEquals(giftDao.likeCount("哈"), giftDao.like("哈", 1, Integer.MAX_VALUE).size());
    }
}