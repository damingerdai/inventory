package org.daming.inventory.dao;

import org.daming.inventory.pojo.Gift;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

/**
 * 描述： 礼品Dao
 *
 * @author daming
 * @date 2018-07-10 20:37
 */
public interface GiftDao {

    Gift get(int id);

    KeyHolder create(Gift gift);

    List<Gift> list();

    List<Gift> like(String name, int pageNo, int pageSize);

    int delete(int id);

    int likeCount(String name);

}
