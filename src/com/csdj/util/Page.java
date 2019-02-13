package com.csdj.util;

public class Page {
    /**
     * 总页数
     */
    private int totalPageCount=1;
    /**
     *  页面大小,即每页记录数
     */
    private int pageSize=2;
    /**
     * 总记录
     */
    private int totalCount;
    /**
     * 当前页码
     */
    private int currPageNo=1;


    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize>0) {
            this.pageSize = pageSize;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount>0){
            this.totalCount=totalCount;
            //计算总页数
            totalPageCount=this.totalCount%pageSize==0?
                    (this.totalCount/pageSize):(this.totalCount/pageSize+1);
        }
        this.totalCount = totalCount;
    }

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

}
