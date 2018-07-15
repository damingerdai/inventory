package org.daming.inventory.pojo.response;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-14 22:00
 */
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 1991084321459708044L;

    protected int statusCode = 200;

    public int getStatusCode() {
        return statusCode;
    }

    public CommonResponse setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public CommonResponse() {
        super();
    }
}
