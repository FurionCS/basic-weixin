package org.cs.basic.weixin.menu.model;

/**
 * 普�?按钮（子按钮�?
 * @author xuxile
 *
 */
public class ClickButton extends Button {
	private String type;
	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
