package org.cs.basic.weixin.customer.model.content;

/**
 * ���ֿͷ���Ϣ����
 * @author xuxile
 *
 */
public class Music {
	
	private String title;//���ֱ���
	private String description;//��������
	private String musicurl;//��������
	private String hqmusicurl;//��Ʒ���������ӣ�wifi��������ʹ�ø����Ӳ�������
	private String thumb_media_id;//����ͼ��ý��ID

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

	public String getMusicurl() {
		return musicurl;
	}

	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}

	public String getHqmusicurl() {
		return hqmusicurl;
	}

	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumbMediaId) {
		thumb_media_id = thumbMediaId;
	}
	
}
