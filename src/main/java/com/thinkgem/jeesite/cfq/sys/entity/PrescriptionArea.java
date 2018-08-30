/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.entity;

import com.thinkgem.jeesite.cfq.common.TreeEntity;
import org.hibernate.validator.constraints.Length;


/**
 * 区域Entity
 *
 * @author ThinkGem
 * @version 2013-05-15
 */
public class PrescriptionArea extends TreeEntity<PrescriptionArea> {

    private static final long serialVersionUID = 1L;
    //	private Area parent;	// 父级编号
//	private String parentIds; // 所有父级编号
    private String code;    // 区域编码
    private String name;    // 区域名称
    //	private Integer sort;		// 排序
    private String type;    // 区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）

    public PrescriptionArea() {
        super();
        this.sort = 30;
    }

    public PrescriptionArea(String id) {
        super(id);
    }

    //	@JsonBackReference
//	@NotNull
    @Override
    public PrescriptionArea getParent() {
        return parent;
    }

    @Override
    public void setParent(PrescriptionArea parent) {
        this.parent = parent;
    }

    //
//	@Length(min=1, max=2000)
//	public String getParentIds() {
//		return parentIds;
//	}
//
//	public void setParentIds(String parentIds) {
//		this.parentIds = parentIds;
//	}
//
    @Override
    @Length(min = 1, max = 100)
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
//
//	public Integer getSort() {
//		return sort;
//	}
//
//	public void setSort(Integer sort) {
//		this.sort = sort;
//	}

    @Length(min = 1, max = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Length(min = 0, max = 100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
//
//	public String getParentId() {
//		return parent != null && parent.getId() != null ? parent.getId() : "0";
//	}

    @Override
    public String toString() {
        return name;
    }
}