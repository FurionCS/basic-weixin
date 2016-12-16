package org.cs.basic.weixin.material.model;

import java.util.List;

/**
 * 图文消息，一个图文消息支持1到10条图文
 *@author xuxile 
 **/
public class WxNews {

	private List<WxArticle> articles;
	
	

	public WxNews(List<WxArticle> articles) {
		this.articles = articles;
	}

	public List<WxArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<WxArticle> articles) {
		this.articles = articles;
	}
	
	
}
