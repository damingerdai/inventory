package org.daming.inventory.pojo;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-14 23:08
 */
public class PageInfo implements Serializable {

    private static final long serialVersionUID = -680612627627267987L;

    //pagesize ，每一页显示多少
    private int pageSize ;

    // 总页数
    private int totalPage;

    // 总记录数
    private int totalResult;

    // 当前页数
    private int currentPage;

    public int getPageSize() {
        return pageSize;
    }

    public PageInfo setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public PageInfo setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public PageInfo setTotalResult(int totalResult) {
        this.totalResult = totalResult;
        return this;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public PageInfo setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }
}
