/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.cfq.common.TreeEntity;
import org.hibernate.validator.constraints.Length;


/**
 * 机构Entity
 *
 * @author 马军
 * @version 2016-06-22
 */
public class PrescriptionOffice extends TreeEntity<PrescriptionOffice> {

    private static final long serialVersionUID = 1L;

    /**
     * 新增id属性及get和set方法
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //	private PrescriptionOffice parent; 										// 父级编号
//	private String parentIds; 												// 所有父级编号
    private PrescriptionArea area;                                            // 归属区域
    private String code;                                                    // 机构编码
    //	private String name; 													// 机构名称
//	private Integer sort; 													// 排序
    private String type;                                                    // 机构类型（1：公司；2：部门；3：小组）
    private String grade;                                                    // 机构等级（1：一级；2：二级；3：三级；4：四级）
    private String address;                                                // 联系地址
    private String zipCode;                                                // 邮政编码
    private String master;                                                    // 负责人
    private String phone;                                                    // 电话
    private String fax;                                                    // 传真
    private String email;                                                    // 邮箱
    private String useable;                                                    // 是否可用
    private PrescriptionUser primaryPerson;                                    // 主负责人
    private PrescriptionUser deputyPerson;                                    // 副负责人
    private List<String> childDeptList;                                        // 快速添加子部门

//	 新加字段begin 

    private String departmentName;                                            // 部门名称
    private String departmentCode;                                            // 部门编码
    private String departmentType;                                            // 部门类型
    private String departmentGrade;                                        // 部门等级
    private String departmentAddress;                                        // 部门地址
    private String departmentMaster;                                        // 部门负责人
    private String departmentPhone;                                        // 部门电话
    private String departmentFax;                                            // 部门传真

//	 新加字段end 

    public PrescriptionOffice() {
        super();
        // this.sort = 30;
        this.type = "2";
    }

    public PrescriptionOffice(String id) {
        super(id);
    }

    public List<String> getChildDeptList() {
        return childDeptList;
    }

    public void setChildDeptList(List<String> childDeptList) {
        this.childDeptList = childDeptList;
    }

    public String getUseable() {
        return useable;
    }

    public void setUseable(String useable) {
        this.useable = useable;
    }

    public PrescriptionUser getPrimaryPerson() {
        return primaryPerson;
    }

    public void setPrimaryPerson(PrescriptionUser primaryPerson) {
        this.primaryPerson = primaryPerson;
    }

    public PrescriptionUser getDeputyPerson() {
        return deputyPerson;
    }

    public void setDeputyPerson(PrescriptionUser deputyPerson) {
        this.deputyPerson = deputyPerson;
    }

    // @JsonBackReference
    // @NotNull
    @Override
    public PrescriptionOffice getParent() {
        return parent;
    }

    @Override
    public void setParent(PrescriptionOffice parent) {
        this.parent = parent;
    }
    //
    // @Length(min=1, max=2000)
    // public String getParentIds() {
    // return parentIds;
    // }
    //
    // public void setParentIds(String parentIds) {
    // this.parentIds = parentIds;
    // }

    @NotNull
    public PrescriptionArea getArea() {
        return area;
    }

    public void setArea(PrescriptionArea area) {
        this.area = area;
    }
    //
    // @Length(min=1, max=100)
    // public String getName() {
    // return name;
    // }
    //
    // public void setName(String name) {
    // this.name = name;
    // }
    //
    // public Integer getSort() {
    // return sort;
    // }
    //
    // public void setSort(Integer sort) {
    // this.sort = sort;
    // }

    @Length(min = 1, max = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Length(min = 1, max = 1)
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Length(min = 0, max = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Length(min = 0, max = 100)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Length(min = 0, max = 100)
    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Length(min = 0, max = 200)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Length(min = 0, max = 200)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Length(min = 0, max = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min = 0, max = 100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // public String getParentId() {
    // return parent != null && parent.getId() != null ? parent.getId() : "0";
    // }
//	新加字段SetGet方法begin
/*	@Length(min=1, max=100, message="name长度必须介于 1 和 100 之间")
    public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Length(min=0, max=100, message="department_code长度必须介于 0 和 100 之间")
	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	@Length(min=1, max=1, message="department_type长度必须介于 1 和 1 之间")
	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}
	
	@Length(min=1, max=1, message="department_grade长度必须介于 1 和 1 之间")
	public String getDepartmentGrade() {
		return departmentGrade;
	}

	public void setDepartmentGrade(String departmentGrade) {
		this.departmentGrade = departmentGrade;
	}
	
	@Length(min=0, max=255, message="department_address长度必须介于 0 和 255 之间")
	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	
	@Length(min=0, max=100, message="department_master长度必须介于 0 和 100 之间")
	public String getDepartmentMaster() {
		return departmentMaster;
	}

	public void setDepartmentMaster(String departmentMaster) {
		this.departmentMaster = departmentMaster;
	}
	
	@Length(min=0, max=200, message="department_phone长度必须介于 0 和 200 之间")
	public String getDepartmentPhone() {
		return departmentPhone;
	}

	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
	}
	
	@Length(min=0, max=200, message="department_fax长度必须介于 0 和 200 之间")
	public String getDepartmentFax() {
		return departmentFax;
	}

	public void setDepartmentFax(String departmentFax) {
		this.departmentFax = departmentFax;
	}*/
    @Length(min = 0, max = 100, message = "name长度必须介于 1 和 100 之间")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Length(min = 0, max = 100, message = "department_code长度必须介于 0 和 100 之间")
    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Length(min = 0, max = 1, message = "department_type长度必须介于 1 和 1 之间")
    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    @Length(min = 0, max = 1, message = "department_grade长度必须介于 1 和 1 之间")
    public String getDepartmentGrade() {
        return departmentGrade;
    }

    public void setDepartmentGrade(String departmentGrade) {
        this.departmentGrade = departmentGrade;
    }

    @Length(min = 0, max = 255, message = "department_address长度必须介于 0 和 255 之间")
    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    @Length(min = 0, max = 100, message = "department_master长度必须介于 0 和 100 之间")
    public String getDepartmentMaster() {
        return departmentMaster;
    }

    public void setDepartmentMaster(String departmentMaster) {
        this.departmentMaster = departmentMaster;
    }

    @Length(min = 0, max = 200, message = "department_phone长度必须介于 0 和 200 之间")
    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
    }

    @Length(min = 0, max = 200, message = "department_fax长度必须介于 0 和 200 之间")
    public String getDepartmentFax() {
        return departmentFax;
    }

    public void setDepartmentFax(String departmentFax) {
        this.departmentFax = departmentFax;
    }

    //	新加字段SetGet方法end*/
    public String toString() {
        return name;
    }

    @Override
    public String getParentIds() {
        return parentIds;
    }

    @Override
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getSort() {
        return sort;
    }

    @Override
    public void setSort(Integer sort) {
        this.sort = sort;
    }

}