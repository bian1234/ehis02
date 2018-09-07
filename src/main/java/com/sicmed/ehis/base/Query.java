package com.sicmed.ehis.base;


/**
 * @Author: ykbian
 * @Date: 2018/9/4 10:30
 * @Todo:  分页查询数据的参数
 */
public class Query{
    private static final long serialVersionUID = 1L;


    // 起始页
    private Integer offset;
    // 每页条数
    private Integer limit;


    private Object object;   //查询的其他条件

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * 此处的 offset是前一页的页码，比如查看第一页，起始页是 0。
     */
    public Query(Integer offset, Integer limit) {
        //如果前端没有传分页信息，采用默认分页
        if (offset == null){
            offset = Constant.PAGE_NO;
        }
        if (limit == null){
            limit = Constant.PAGE_SIZE;
        }
       //页码不能小于1
        if (offset < 1){
            offset = 1;
        }
        //前端传的页码数，在sql里面需要变成前一页的页码
        this.offset = offset - 1;
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

    @Override
    public String toString() {
        return "Query{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", object=" + object +
                '}';
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


