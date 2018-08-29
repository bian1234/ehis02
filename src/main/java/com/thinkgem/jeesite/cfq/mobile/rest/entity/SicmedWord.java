//package com.thinkgem.jeesite.cfq.mobile.rest.entity;
//
//import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
//import org.hibernate.validator.constraints.Length;
//
//
//
//public class  SicmedWord extends DataEntity<SicmedWord> {
//
//    private static final long serialVersionUID = 1L;
//
//    private String wordName;
//    private String wordUri;
//    private String printType;
//    private String printLoc;
//
//
//    private SicmedPatient sicmedPatient;
//
//    private SicmedUser createUser;
//
//    private SicmedUser updateUser;
//
//
//    public SicmedWord() {
//        super();
//    }
//
//    public SicmedWord(String id) {
//        super(id);
//    }
//
//
//    @Length(min = 1, max = 40, message = "用户编码长度必须介于 1 和 6 之间")
//    public String getWordName() {
//        return wordName;
//    }
//
//    public void setWordName(String wordName) {
//        this.wordName = wordName;
//    }
//
//    @Length(min = 1, max = 40, message = "用户编码长度必须介于 1 和 6 之间")
//    public String getWordUri() {
//        return wordUri;
//    }
//
//    public void setWordUri(String wordUri) {
//        this.wordUri = wordUri;
//    }
//
//    @Length(min = 1, max = 1, message = "用户编码长度必须介于 1 和 6 之间")
//    public String getPrintType() {
//        return printType;
//    }
//
//    public void setPrintType(String printType) {
//        this.printType = printType;
//    }
//
//    @Length(min = 1, max = 64, message = "用户编码长度必须介于 1 和 6 之间")
//    public String getPrintLoc() {
//        return printLoc;
//    }
//
//    public void setPrintLoc(String printLoc) {
//        this.printLoc = printLoc;
//    }
//
//    public SicmedUser getCreateUser() {
//        return createUser;
//    }
//
//    public void setCreateUser(SicmedUser createUser) {
//        this.createUser = createUser;
//    }
//
//    public SicmedUser getUpdateUser() {
//        return updateUser;
//    }
//
//    public void setUpdateUser(SicmedUser updateUser) {
//        this.updateUser = updateUser;
//    }
//
//    public SicmedPatient getSicmedPatient() {
//        return sicmedPatient;
//    }
//
//    public void setSicmedPatient(SicmedPatient sicmedPatient) {
//        this.sicmedPatient = sicmedPatient;
//    }
//
//}