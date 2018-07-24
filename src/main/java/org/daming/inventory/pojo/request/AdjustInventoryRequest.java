package org.daming.inventory.pojo.request;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-24 20:59
 */
public class AdjustInventoryRequest implements Serializable {
    private static final long serialVersionUID = -8949403567931148189L;

    private int num;

    public int getNum() {
        return num;
    }

    public AdjustInventoryRequest setNum(int num) {
        this.num = num;
        return this;
    }
}
