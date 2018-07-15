package org.daming.inventory.pojo.response;

import java.util.List;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-14 22:13
 */
public class ListResponse <T> extends CommonResponse {

    private static final long serialVersionUID = 1610792978872732678L;

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public ListResponse<T> setData(List<T> data) {
        this.data = data;
        return this;
    }
}
