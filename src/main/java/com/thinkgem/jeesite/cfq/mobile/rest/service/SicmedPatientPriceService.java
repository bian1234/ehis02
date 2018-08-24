/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCheckPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedPatientPriceDao;

/**
 * 患者价格明细表Service
 *
 * @author 丁学志
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedPatientPriceService extends CrudService<SicmedPatientPriceDao, SicmedPatientPrice> {


    // 放射线检查价格
    @Autowired
    private SicmedCheckPriceService sicmedCheckPriceService;


    // 检验价格
    @Autowired
    private SicmedInspectPriceService sicmedInspectPriceService;


    // 治疗价格
    @Autowired
    private SicmedCurePriceService sicmedCurePriceService;


    //药品价格
    @Autowired
    private SicmedMedicalPriceService sicmedMedicalPriceService;


    //药品价格
    @Autowired
    private SicmedRegisteredService sicmedRegisteredService;

    @Autowired
    private SicmedPatientPriceDao patientPriceDao;

    @Autowired
    private SicmedPatientPriceDao sicmedPatientPriceDao;

	/*@Autowired
	private Integer allPrice;*/

    @Override
    public SicmedPatientPrice get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedPatientPrice> findList(SicmedPatientPrice sicmedPatientPrice) {
        return super.findList(sicmedPatientPrice);
    }

    public Page<SicmedPatientPrice> findAllPage(Page<SicmedPatientPrice> page, SicmedPatientPrice sicmedPatientPrice) {

        Page<SicmedPatientPrice> tempPage = new Page<SicmedPatientPrice>();
        page.setAllNumber(0.0);
        tempPage = super.findPageLike(page, sicmedPatientPrice);
        for (SicmedPatientPrice tempPatientPrice : tempPage.getList()) {

            if (tempPatientPrice.getPriceClassType() != null && tempPatientPrice.getPriceCode() != null) {
                Map<String, String> tempMap = new HashMap<String, String>();
                tempMap = this.getUnitPrice(Integer.valueOf(tempPatientPrice.getPriceClassType()), tempPatientPrice.getPriceCode());
                if (tempMap.get("price") == null || tempMap.get("name") == null) {
                    tempPatientPrice.setPrice("0");
                    tempPatientPrice.setPriceName("未找到");
                }

                tempPatientPrice.setPrice(tempMap.get("price"));
                tempPatientPrice.setPriceName(tempMap.get("name"));
				/*Double allPrice = page.getAllNumber()+Double.parseDouble(tempPatientPrice.getPrice());*/
                DecimalFormat format = new DecimalFormat("#.00");
                Double allPrice1 = page.getAllNumber() + Double.parseDouble(tempPatientPrice.getPrice());

                String allPrice = format.format(allPrice1);

                page.setAllNumber(Double.parseDouble(allPrice));
            }
        }
        return tempPage;

    }

    //退号同时删除挂号费
    @Transactional(readOnly = false)
    public void deletePrice(SicmedPatientPrice sicmedPatientPrice) {
        sicmedPatientPriceDao.deletePrice(sicmedPatientPrice);
    }

//	
//	/*
//	 * 通过患者ID查询相应的信息
//	 * 
//	 * 参数 SicmedPatientPrice 必须包含patientId属性
//	 * */
//	public SicmedPatientPrice getPatientPriceDetailWithPatient(SicmedPatientPrice patientPrice){
//		
//		SicmedPatientPrice tempPatientPrice = new SicmedPatientPrice();
//		tempPatientPrice = patientPriceDao.getPatientPrice(patientPrice);
//		return tempPatientPrice;
//	}
//	
//	public List<SicmedPatientPrice> getPatientPriceList(SicmedPatientPrice patientPrice){
//		
//		//创建List
//		List<SicmedPatientPrice> tempList = new ArrayList<SicmedPatientPrice>();
//		tempList = patientPriceDao.findListWithPatient(patientPrice);
//		
//		for (SicmedPatientPrice sicmedPatientPrice : tempList) {
//			Map<String , String> tempMap = this.getUnitPrice(Integer.valueOf(sicmedPatientPrice.getPriceClassType()), sicmedPatientPrice.getPriceCode());
//			sicmedPatientPrice.setPrice(tempMap.get("price"));
//			sicmedPatientPrice.setPriceName(tempMap.get("name"));
//			//sicmedPatientPrice.setPrice(this.getUnitPrice(Integer.valueOf(sicmedPatientPrice.getPriceClassType()), sicmedPatientPrice.getPriceCode()).toString());
//		}
//		
//		return tempList;
//		
//	}
//	
//	/*
//	 *  添加患者價格明細
//		SicmedPatientPrice sicmedPatient = new SicmedPatientPrice();
//		sicmedPatient.setPatientCode("");
//		sicmedPatient.setPriceClassType(sicmedAsked.getSicmedAskedClass().getClassNumber());
//		sicmedPatient.setPriceCode(sicmedAsked.getOrderCode());
//		sicmedPatient.setPrice(price);
//		*/
//	@Transactional(readOnly = false)
//	public void addPatientPrice (String patientCode,String PriceClassType,String priceCode,String price){
//		//添加患者價格明細
//		SicmedPatientPrice sicmedPatient = new SicmedPatientPrice();
//		sicmedPatient.setPriceClassType(PriceClassType);
//		//sicmedPatient.setPriceCode(priceCode);
//		sicmedPatient.setPrice(price);
//		this.save(sicmedPatient);
//	}

    /*
     * 通过医嘱类别和详情编号找到对应的单价
     *
     * parameter 1 askType类型
     *
     * parameter 2 对应的编号
     *
     * */
    public Map<String, String> getUnitPrice(Integer askType, String customCode) {

        String price = "0";
        String name = new String();
        Map<String, String> tempMap = new HashMap<String, String>();
        switch (askType) {

            case 0: //检查
                //创建检查价格对象
                SicmedCheckPrice sicmedCheckPrice = new SicmedCheckPrice();
                sicmedCheckPrice = sicmedCheckPriceService.get(customCode);
                if (sicmedCheckPrice == null) {
                    name = "未知";
                    break;
                }
                price = sicmedCheckPrice.getCheckPrice();
                name = sicmedCheckPrice.getSicmedTwxrayCheck().getCheckName();
                break;

            case 1: //检验
                //创建检验价格对象
                SicmedInspectPrice sicmedInspectPrice = new SicmedInspectPrice();
                sicmedInspectPrice = sicmedInspectPriceService.get(customCode);
                if (sicmedInspectPrice == null) {
                    name = "未知";
                    break;
                }
                price = sicmedInspectPrice.getPrice();
                name = sicmedInspectPrice.getSicmedInspect().getInspectName();
                break;

            case 2://治疗

                //创建治疗价格对象
                SicmedCurePrice sicmedCurePrice = new SicmedCurePrice();
                sicmedCurePrice = sicmedCurePriceService.get(customCode);
                if (sicmedCurePrice == null) {
                    name = "未知";
                    break;
                }
                price = sicmedCurePrice.getPrice();
                name = sicmedCurePrice.getSicmedCureCheck().getCureName();
                break;

            case 3:    //去药品表中查询价格

                //创建药品价格对象
                SicmedMedicalPrice medicalPrice = new SicmedMedicalPrice();
                medicalPrice = sicmedMedicalPriceService.get(customCode);
                if (medicalPrice == null) {
                    name = "未知";
                    break;
                }
                price = medicalPrice.getPriceSale();
                name = medicalPrice.getSicmedMedical().getMedicalNameChina();
                break;
            case 5: //去患者基础表中找到对应的价格

                //创建患者基础表registered对象
                SicmedRegistered registered = new SicmedRegistered();
                registered = sicmedRegisteredService.get(customCode);
                if (registered == null) {
                    name = "未知";
                    break;
                }
                price = registered.getRegisteredPric() == null ? "0" : registered.getRegisteredPric();
                name = registered.getRegisteredStatus();
                break;
        }

        tempMap.put("name", name);
        tempMap.put("price", price.toString());
        return tempMap;
    }
	
	/*
	 * 删除信息
	 * */
//	@Transactional(readOnly = false)
//	public Boolean deleteWithPatientModel(SicmedPatientPrice patientPrice){
//		
//		List<SicmedPatientPrice> tempList = new ArrayList<SicmedPatientPrice>();
//		tempList = this.getPatientPriceList(patientPrice);
//		if(tempList.size() == 0){
//			return false;
//		}
//		
//		//遍历tempList 删除指定数据
//		for (SicmedPatientPrice sicmedPatientPrice : tempList) {
//			//取出对象
//			this.delete(sicmedPatientPrice);
//		}
//		
//		return true;
//	}


    /*
     * 计算各级分类的价格
     * (0.检查类型 1.检验类型 2.治疗类型 3.药品类型)
     * */
    public Map<String, Integer> getPrice(List<SicmedPatientPrice> tempList) {

        Map<String, Integer> priceMap = new HashMap<String, Integer>();
        //检查
        Integer checkSum = 0;
        Integer checkPay = 0;

        //检验
        Integer inspectSum = 0;
        Integer inspectPay = 0;

        //治疗
        Integer cureSum = 0;
        Integer curePay = 0;
        //药品
        Integer medicalSum = 0;
        Integer medicalPay = 0;

        //总价
        Integer allSum = 0;

        for (SicmedPatientPrice sicmedPatientPrice : tempList) {
            switch (Integer.valueOf(sicmedPatientPrice.getPriceClassType())) {
                case 0:
                    checkSum += Integer.valueOf(sicmedPatientPrice.getPrice());
                    checkPay = (Integer.valueOf(sicmedPatientPrice.getIsPay()) == 0) ? 0 : 1;
                    break;
                case 1:
                    inspectSum += Integer.valueOf(sicmedPatientPrice.getPrice());
                    inspectPay = (Integer.valueOf(sicmedPatientPrice.getIsPay()) == 0) ? 0 : 1;
                    break;
                case 2:
                    cureSum += Integer.valueOf(sicmedPatientPrice.getPrice());
                    curePay = (Integer.valueOf(sicmedPatientPrice.getIsPay()) == 0) ? 0 : 1;
                    break;
                case 3:
                    medicalSum += Integer.valueOf(sicmedPatientPrice.getPrice());
                    medicalPay = (Integer.valueOf(sicmedPatientPrice.getIsPay()) == 0) ? 0 : 1;
                    break;
            }

        }
        allSum = inspectSum + checkSum + cureSum + medicalSum;

        priceMap.put("inspectSum", inspectSum);
        priceMap.put("checkSum", checkSum);
        priceMap.put("curetSum", cureSum);
        priceMap.put("medicalSum", medicalSum);
        priceMap.put("inspectPay", inspectPay);
        priceMap.put("checkPay", checkPay);
        priceMap.put("curetPay", curePay);
        priceMap.put("medicalPay", medicalPay);
        priceMap.put("allSum", allSum);

        return priceMap;
    }

    @Transactional(readOnly = false)
    public void save(SicmedPatientPrice sicmedPatientPrice) {

        super.save(sicmedPatientPrice);
    }

    @Transactional(readOnly = false)
    public void delete(SicmedPatientPrice sicmedPatientPrice) {
        super.delete(sicmedPatientPrice);
    }

    public SicmedPatientPrice getByEntity(SicmedPatientPrice sicmedPatientPrice) {
        return patientPriceDao.getByEntity(sicmedPatientPrice);
    }

    @Transactional(readOnly = false)
    public int update(SicmedPatientPrice sicmedPatientPrice) {
        return patientPriceDao.update(sicmedPatientPrice);
    }

    //复制数据表 表结构和表中数据 复制 清空原表
    @Transactional(readOnly = false)
    public void clearTable(String copyName) {
        SicmedPatientPrice patientPrice = new SicmedPatientPrice();
        patientPrice.setCopyTableName(copyName);
        patientPriceDao.copyTable(patientPrice);
        patientPriceDao.insertTable(patientPrice);
        patientPriceDao.clearTable();
    }

    public Map<String, List<SicmedPatientPrice>> classify(List<SicmedPatientPrice> patientPriceList) {
        Map<String, List<SicmedPatientPrice>> detailMap = new HashMap<String, List<SicmedPatientPrice>>();
        List<SicmedPatientPrice> checkList = Lists.newArrayList();
        List<SicmedPatientPrice> inspectList = Lists.newArrayList();
        List<SicmedPatientPrice> cureList = Lists.newArrayList();
        List<SicmedPatientPrice> medicalList = Lists.newArrayList();
        Double allPrice = 0.00;
        //创建4个List分别记录 分别记录 检查/检验/治疗/药品对象
        for (SicmedPatientPrice tempPatientPrice : patientPriceList) {
            switch (Integer.valueOf(tempPatientPrice.getPriceClassType())) {
                case 0:
                    checkList.add(tempPatientPrice);
                    break;
                case 1:
                    inspectList.add(tempPatientPrice);
                    break;
                case 2:
                    cureList.add(tempPatientPrice);
                    break;
                case 3:
                    medicalList.add(tempPatientPrice);
                    break;
                default:
                    break;
            }
            allPrice += Double.valueOf(tempPatientPrice.getPrice() == null ? "0" : tempPatientPrice.getPrice());
        }
        detailMap.put("checkList", checkList);
        detailMap.put("inspectList", inspectList);
        detailMap.put("cureList", cureList);
        detailMap.put("medicalList", medicalList);

        return detailMap;
    }

    public List<SicmedPatientPrice> findListUUID(SicmedPatientPrice patientPrice) {
        // TODO Auto-generated method stub
        return patientPriceDao.findListUUID(patientPrice);
    }

    public List<SicmedPatientPrice> findHistoryList(SicmedPatientPrice sicmedPatientPrice) {
        // TODO Auto-generated method stub
        return patientPriceDao.findHistoryList(sicmedPatientPrice);
    }

    /*
     * 2016-09-28 丁学志
     *
     * 解决问题：web收费端 去除重复患者，并且计算该患者的所有价格
     * */
    public Page<SicmedPatientPrice> deleteRepeatedPatientPrice(Page<SicmedPatientPrice> page) {
        List<SicmedPatientPrice> pPList = new ArrayList<SicmedPatientPrice>(page.getList());
        for (SicmedPatientPrice sicmedPatientPrice : pPList) {
            //通过patient_code和isPay  查到对应的缴费情况
            SicmedPatientPrice tempPP = new SicmedPatientPrice();
            tempPP.setSicmedPatient(sicmedPatientPrice.getSicmedPatient());
            tempPP.setIsPay(sicmedPatientPrice.getIsPay());
            List<SicmedPatientPrice> tempList = this.findList(tempPP);
            Double tempPrice = sicmedPatientPrice.getPrice() == null ? 0.00 : Double.valueOf(sicmedPatientPrice.getPrice());
            for (SicmedPatientPrice tempPatientPrice : tempList) {
                if (tempPatientPrice.getId().equals(sicmedPatientPrice.getId())) {
                    continue;
                }
                if (tempPatientPrice.getPriceClassType() != null && tempPatientPrice.getPriceCode() != null) {
                    Map<String, String> tempMap = new HashMap<String, String>();
                    tempMap = this.getUnitPrice(Integer.valueOf(tempPatientPrice.getPriceClassType()), tempPatientPrice.getPriceCode());
                    if (tempMap.get("price") == null || tempMap.get("name") == null) {
                        tempPatientPrice.setPrice("0.00");
                        tempPatientPrice.setPriceName("未找到");
                    }

                    tempPatientPrice.setPrice(tempMap.get("price"));
                    tempPatientPrice.setPriceName(tempMap.get("name"));
                }
                tempPrice += Double.valueOf(tempPatientPrice.getPrice());
            }
            if (tempPrice != 0.00) {
                sicmedPatientPrice.setPrice(String.valueOf(tempPrice));
            }
        }
		
		/*//先将patientPriceList 排序 通过patient_code 进行排序
		Collections.sort(patientPriceList,new Comparator<SicmedPatientPrice>() {
		});
		Collections.sort(patientPriceList,new Comparator<SicmedPatientPrice>() {

			@Override
			public int compare(SicmedPatientPrice o1, SicmedPatientPrice o2) {
				// TODO Auto-generated method stub
				return o1.getSicmedPatient().getId().compareTo(o2.getSicmedPatient().getId());
			}
		});
		
		String patientCode = new String();												//记录患者编号
		Double tempPrice = 0.00;														//记录患者对应的价格
		List<SicmedPatientPrice> tempPatientPriceList = Lists.newArrayList();			//记录患者价格信息
		
		for (int i = 0; i < patientPriceList.size(); i++) {								//对排过序的数组进行处理 除重复
			SicmedPatientPrice tempPatientPrice = patientPriceList.get(i);
			if(tempPatientPrice.getSicmedPatient()!=null){								//患者对象存在
				
				if(patientCode==null){													//如果tempPatientCode为空 就给其赋值
					patientCode = tempPatientPrice.getSicmedPatient().getId();
					tempPrice = Double.valueOf(patientPriceList.get(i).getPrice()==null?"0.00":patientPriceList.get(i).getPrice());
					tempPatientPriceList.add(tempPatientPrice);
				}else{
					if(patientCode.equals(tempPatientPrice.getSicmedPatient().getId())){
						tempPrice += Double.valueOf(patientPriceList.get(i).getPrice()==null?"0.00":patientPriceList.get(i).getPrice());
					}else{
						tempPatientPrice.setPrice(String.valueOf(tempPrice).equals("0.00")?tempPatientPrice.getPrice():String.valueOf(tempPrice));
						tempPatientPriceList.add(tempPatientPrice);						//将patientPrice添加到list中
						patientCode = tempPatientPrice.getSicmedPatient().getId();
					}
				}
				
			}
		}
		page.setList(tempPatientPriceList);
		page.setPageSize(tempPatientPriceList.size());*/
        return page;
    }
}