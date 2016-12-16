package org.cs.basic.weixin.msg.model.recv;

/**
 * 音频消息
 *@author xuxile 
 **/
public class WxRecvVoiceMsg extends WxRecvMsg {
	
	private String mediaId;//语音消息媒体id，可以调用多媒体文件下载接口拉取该媒�?
	private String format;//语音格式：amr
	private String recognition;//语音识别结果，UTF8编码
	
	public WxRecvVoiceMsg(WxRecvMsg msg,String mediaId,String format,String recognition) {
		super(msg);
		this.mediaId = mediaId;
		this.format = format;
		this.recognition = recognition;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
}
