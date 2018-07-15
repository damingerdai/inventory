package org.daming.inventory.pojo.response;

/**
 * 描述： 数据返回
 *
 * @author daming
 * @date 2018-07-14 22:07
 */
public class DataResponse<T> extends CommonResponse {

    private static final long serialVersionUID = -7559823492525660398L;

    private T data;

    public T getData() {
        return data;
    }

    public DataResponse<T> setData(T data) {
        this.data = data;
        return this;
    }
}
