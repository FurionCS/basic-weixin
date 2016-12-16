package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.News;

/**
 * 多图文客服消息
 * @author xuxile
 *
 */
public class CustomerNewsMsg extends CustomerMsg{

	private News news;//多图文消息内容

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	
	
}
