package org.cs.basic.weixin.msg.model.recv;

/**
 * 视频消息
 *@author xuxile 
 **/
public class WxRecvVideoMsg extends WxRecvMsg {
	
	private String mediaId;//视频消息媒体id，可以调用多媒体文件下载接口拉取数据
	private String thumbMediaId;//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	
	public WxRecvVideoMsg(WxRecvMsg msg,String mediaId,String thumbMediaId) {
		super(msg);
		this.mediaId = mediaId;
		this.thumbMediaId = thumbMediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
}
