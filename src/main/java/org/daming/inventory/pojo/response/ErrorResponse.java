package org.daming.inventory.pojo.response;

import org.daming.inventory.pojo.Error;

/**
 * 描述： 错误返回
 *
 * @author daming
 * @date 2018-07-14 22:01
 */
public class ErrorResponse extends CommonResponse {

    private static final long serialVersionUID = -1648508864643362987L;

    private Error error;

    public Error getError() {
        return error;
    }

    public ErrorResponse setError(Error error) {
        this.error = error;
        return this;
    }

    public ErrorResponse() {
        super();
        super.setStatusCode(-1);
    }
}
