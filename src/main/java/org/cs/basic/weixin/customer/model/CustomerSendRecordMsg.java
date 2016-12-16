package org.cs.basic.weixin.customer.model;

/**
 * �ͷ���Ϣ��¼������
 * @author xuxile
 *
 */
public class CustomerSendRecordMsg {

	private String starttime;//��ѯ��ʼʱ�䣬UNIXʱ���
	private String endtime;//��ѯ����ʱ�䣬UNIXʱ�����ÿ�β�ѯ���ܿ��ղ�ѯ
	private String openid;//��ͨ�û��ı�ʶ���Ե�ǰ���ں�Ψһ
	private String pagesize;//ÿҳ��С��ÿҳ�����ȡ1000��
	private String pageindex;//��ѯ�ڼ�ҳ����1��ʼ
	
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
