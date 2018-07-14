package org.daming.inventory.dao;

import org.daming.inventory.pojo.Gift;

import java.util.List;

/**
 * 描述： 礼品Dao
 *
 * @author daming
 * @date 2018-07-10 20:37
 */
public interface GiftDao {

    Gift get(int id);

    List<Gift> list();

    List<Gift> like(String name, int pageNo, int pageSize);

}
