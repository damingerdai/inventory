package org.daming.inventory.service;

import org.daming.inventory.pojo.Gift;

import java.util.List;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-10 22:19
 */
public interface GiftService {

    List<Gift> like(String name, int pageNo, int pageSize);

    List<Gift> list();

}
