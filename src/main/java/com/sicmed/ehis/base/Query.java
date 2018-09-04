package com.sicmed.ehis.base;


/**
 * @Author: ykbian
 * @Date: 2018/9/4 10:30
 * @Todo:  分页查询数据的参数
 */
public class Query{
    private static final long serialVersionUID = 1L;
    // 起始页
    private int offset;
    // 每页条数
    private int limit;

    public Query(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
//public class Query extends LinkedHashMap<String, Object> {
//    private static final long serialVersionUID = 1L;
//    // 起始页
//    private int offset;
//    // 每页条数
//    private int limit;

//    public Query(Map<String, Object> params) {
//        this.putAll(params);
//        // 分页参数
//        this.offset = Integer.parseInt(params.get("offset").toString());
//        this.limit = Integer.parseInt(params.get("limit").toString());
//        this.put("offset", offset);
//        this.put("page", offset / limit + 1);
//        this.put("limit", limit);
//    }
//
//    public int getOffset() {
//        return offset;
//    }
//
//    public void setOffset(int offset) {
//        this.put("offset", offset);
//    }
//
//    public int getLimit() {
//        return limit;
//    }
//
//    public void setLimit(int limit) {
//        this.limit = limit;
//    }


