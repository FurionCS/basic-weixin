package org.cs.basic.weixin.qr.model;

/**
 * 二维码详细信息父�?
 * @author xuxile
 */
public class QrActionInfo {

	private QrScene scene;//场景�?
	
	public QrActionInfo(QrScene scene) {
		this.scene = scene;
	}

	public QrScene getScene() {
		return scene;
	}

	public void setScene(QrScene scene) {
		this.scene = scene;
	}
	
}
