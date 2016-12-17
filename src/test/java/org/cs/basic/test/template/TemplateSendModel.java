package org.cs.basic.test.template;

/**
 * 发送模板消息model
 * @author YoYo
 *
 */
public class TemplateSendModel {
	private String touser;       //用户得openid
	private String template_id;  //模板消息id
	private String url;    
	private TemplateDate data;        //内容
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public TemplateDate getData() {
		return data;
	}
	public void setData(TemplateDate data) {
		this.data = data;
	}
	
	public TemplateSendModel(String touser, String template_id, String url,
			TemplateDate data) {
		super();
		this.touser = touser;
		this.template_id = template_id;
		this.url = url;
		this.data = data;
	}
	public TemplateSendModel() {
		super();
	}
	

}
