package org.daming.inventory.pojo.response;

import org.daming.inventory.pojo.PageInfo;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-14 23:13
 */
public class PageResponse<T> extends ListResponse<T> {

    private static final long serialVersionUID = -7094281310895883629L;

    private PageInfo pageInfo;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public PageResponse<T> setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }
}
