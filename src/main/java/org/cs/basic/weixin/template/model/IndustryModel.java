package org.cs.basic.weixin.template.model;
/**
 * 行业信息model
 * @author YoYo
 *
 */
public class IndustryModel {
	private String firstClass;  //主行业
	private String secondClass; //副行业
	private int type;           //自定义属性用于判断是：1：表示primary_industry 2：表示 secondary_industry
	public String getFirstClass() {
		return firstClass;
	}
	public void setFirstClass(String firstClass) {
		this.firstClass = firstClass;
	}
	public String getSecondClass() {
		return secondClass;
	}
	public void setSecondClass(String secondClass) {
		this.secondClass = secondClass;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public IndustryModel(String firstClass, String secondClass, int type) {
		super();
		this.firstClass = firstClass;
		this.secondClass = secondClass;
		this.type = type;
	}
	public IndustryModel() {
		super();
	}
	@Override
	public String toString() {
		return "IndustryModel [firstClass=" + firstClass + ", secondClass="
				+ secondClass + ", type=" + type + "]";
	}
	
	
}
