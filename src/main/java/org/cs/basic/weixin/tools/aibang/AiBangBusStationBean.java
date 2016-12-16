package org.cs.basic.weixin.tools.aibang;

/**
 * 公交信息�?
 * @author xuxile
 * 
 */
public class AiBangBusStationBean {
	private String cityName;//城市名称
	
	private String name;//站点名称
	private String location_x;//经度
	private String location_y;//维度
	private String dist;//总距�?单位：米
	private String line_names;//途径该站点的线路名称	 半角分号;(英文分号)分隔
	
	
	private String lineInfo; // 线路信息
	private String lineStats; // 沿�?站点
	private String lineStat_xys; // 途径站点经纬�?
	private String lineXys; // 线路坐标
	
	public String getLineInfo() {
		return lineInfo;
	}
	public void setLineInfo(String lineInfo) {
		this.lineInfo = lineInfo;
	}
	public String getLineStats() {
		return lineStats;
	}
	public void setLineStats(String lineStats) {
		this.lineStats = lineStats;
	}
	public String getLineStat_xys() {
		return lineStat_xys;
	}
	public void setLineStat_xys(String lineStat_xys) {
		this.lineStat_xys = lineStat_xys;
	}
	public String getLineXys() {
		return lineXys;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public void setLineXys(String lineXys) {
		this.lineXys = lineXys;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation_x() {
		return location_x;
	}
	public void setLocation_x(String location_x) {
		this.location_x = location_x;
	}
	public String getLocation_y() {
		return location_y;
	}
	public void setLocation_y(String location_y) {
		this.location_y = location_y;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getLine_names() {
		return line_names;
	}
	public void setLine_names(String line_names) {
		this.line_names = line_names;
	}
	
}
