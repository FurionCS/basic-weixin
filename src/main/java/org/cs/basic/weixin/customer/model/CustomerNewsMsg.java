package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.News;

/**
 * ��ͼ�Ŀͷ���Ϣ
 * @author xuxile
 *
 */
public class CustomerNewsMsg extends CustomerMsg{

	private News news;//��ͼ����Ϣ����

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	
	
}
