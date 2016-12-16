package org.cs.basic.weixin.customer.model;

import org.cs.basic.weixin.customer.model.content.Music;

/**
 * 音乐客服消息
 * @author xuxile
 *
 */
public class CustomerMusicMsg extends CustomerMsg{

	private Music music;//音乐消息内容

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
}
