package org.cs.basic.weixin.customer.model.content;

/**
 * 图文消息
 * @author xuxile 
 **/
public class Articles {
	private String title;//标题
	private String description;//描述
	private String picurl;//图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
	private String url;//点击后跳转的链接
	public Articles(String title, String description, String picurl, String url) {
		this.title = title;
		this.description = description;
		this.picurl = picurl;
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
