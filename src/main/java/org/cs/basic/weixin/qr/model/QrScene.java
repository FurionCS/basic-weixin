package org.cs.basic.weixin.qr.model;

/**
 * 场景值类
 * @author xuxile
 */
public class QrScene {

	private int scene_id;//场景值ID，临时二维码时为32位非0整型，永久二维码时最大�?�?00000（目前参数只支持1--100000�?

	public QrScene(int sceneId) {
		scene_id = sceneId;
	}

	public int getScene_id() {
		return scene_id;
	}

	public void setScene_id(int sceneId) {
		scene_id = sceneId;
	}

	
	
	
}
