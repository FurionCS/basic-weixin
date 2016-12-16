package org.cs.basic.weixin.notice.model;

/**
 * 群发用于设定即将发�?的消息media_id
 * @author xuxile 
 **/
public class Mptype {

	private String media_id;//用于群发的消息的media_id

	public Mptype(String media_id){
		this.media_id=media_id;
	}
	
	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String mediaId) {
		media_id = mediaId;
	}
	
	
}
