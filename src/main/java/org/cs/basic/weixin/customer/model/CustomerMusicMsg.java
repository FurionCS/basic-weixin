package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Music;

/**
 * ���ֿͷ���Ϣ
 * @author xuxile
 *
 */
public class CustomerMusicMsg extends CustomerMsg{

	private Music music;//������Ϣ����

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
}
