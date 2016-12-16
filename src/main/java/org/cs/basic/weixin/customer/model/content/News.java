package org.cs.basic.weixin.customer.model.content;

import java.util.List;

/**
 * 多图文消息
 * @author xuxile
 *
 */
public class News {

	List<Articles> articles;

	public List<Articles> getArticles() {
		return articles;
	}

	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}
	
	
}
