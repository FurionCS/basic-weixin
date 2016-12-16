package org.cs.basic.weixin.customer.model;

/**
 * 客服消息记录发送类
 * @author xuxile
 *
 */
public class CustomerSendRecordMsg {

	private String starttime;//查询开始时间，UNIX时间戳
	private String endtime;//查询结束时间，UNIX时间戳，每次查询不能跨日查询
	private String openid;//普通用户的标识，对当前公众号唯一
	private String pagesize;//每页大小，每页最多拉取1000条
	private String pageindex;//查询第几页，从1开始
	
	public CustomerSendRecordMsg(String starttime, String endtime, String openid,
			String pagesize, String pageindex) {
		this.starttime = starttime;
		this.endtime = endtime;
		this.openid = openid;
		this.pagesize = pagesize;
		this.pageindex = pageindex;
	}
	
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	public String getPageindex() {
		return pageindex;
	}
	public void setPageindex(String pageindex) {
		this.pageindex = pageindex;
	}
}
