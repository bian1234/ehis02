package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;


/**
 * RESTful接口示例Entity
 *
 * @author DING DataEntity
 * @version 2016-07-22
 */
public class SicmedInspectClass extends DataEntity<SicmedInspectClass> {

    private static final long serialVersionUID = 1L;
    private String inspectName;        // 检验分类
    private String inspectCode;        // 检验类别编号

    public SicmedInspectClass() {
        super();
    }

    public SicmedInspectClass(String id) {
        super(id);
    }

    @Length(min = 0, max = 32, message = "检验分类长度必须介于 0 和 30 之间")
    public String getInspectName() {
        return inspectName;
    }

    public void setInspectName(String inspectName) {
        this.inspectName = inspectName;
    }

    @Length(min = 0, max = 32, message = "检验类别编号长度必须介于 0 和 8 之间")
    public String getInspectCode() {
        return inspectCode;
    }

    public void setInspectCode(String inspectCode) {
        this.inspectCode = inspectCode;
    }

	/*	public SicmedInspectClass getParent() {
		warning:
		if(parent==null){
			//parent = new SicmedInspectClass();
			parent.setId("ca17fed72e0642318b51bfb900b61a9a");
			parent.setInspectName("测试");
		}
		return parent;
	}

	public void setParent(SicmedInspectClass parent) {
		this.parent = parent;
	}*/

}