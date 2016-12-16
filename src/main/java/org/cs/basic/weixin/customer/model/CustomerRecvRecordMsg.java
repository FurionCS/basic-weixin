package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.MapOperCode;

/**
 * �ͷ���Ϣ��¼������
 * @author xuxile
 *
 */
public class CustomerRecvRecordMsg {

	private String worker;//�ͷ��˺�
	private String openid;//�û��ı�ʶ���Ե�ǰ���ں�Ψһ
	private String opercode;//����ID���Ự״̬��������˵��������
	private String time;//����ʱ�䣬UNIXʱ���
	private String text;//�����¼
	
	public CustomerRecvRecordMsg(String worker, String openid, String opercode,
			String time, String text) {
		this.worker = worker;
		this.openid = openid;
		this.opercode = MapOperCode.getOperCodeDescription(opercode);
		this.time = time;
		this.text = text;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOpercode() {
		return opercode;
	}
	public void setOpercode(String opercode) {
		this.opercode = MapOperCode.getOperCodeDescription(opercode);
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
