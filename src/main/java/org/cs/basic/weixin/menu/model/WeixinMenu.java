package org.cs.basic.weixin.menu.model;

/**
 * 微信菜单�?
 * @author xuxile
 */
public class WeixinMenu{
	
	private String id;//菜单ID
	private String menuName;//菜单名称
	private Integer menuOrder;//菜单排序
	private String menuLevel;//菜单级别
	private String menuType;//菜单类型   menu:为一级菜�?    目前有click、view两种类型  目前有click、view两种类型  点击事件  访问网页
	private String parentId;//上级菜单ID
	private String menuKey;//关键字信�?
	private String menuUrl;//转向页面URL
	
	
	public WeixinMenu() {
		
	}

	public WeixinMenu(String id, String menuName, Integer menuOrder,
			String menuLevel, String menuType, String parentId, String menuKey,
			String menuUrl) {
		this.id = id;
		this.menuName = menuName;
		this.menuOrder = menuOrder;
		this.menuLevel = menuLevel;
		this.menuType = menuType;
		this.parentId = parentId;
		this.menuKey = menuKey;
		this.menuUrl = menuUrl;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public Integer getMenuOrder() {
		return menuOrder;
	}


	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}


	public String getMenuLevel() {
		return menuLevel;
	}


	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}


	public String getMenuType() {
		return menuType;
	}


	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}


	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	public String getMenuKey() {
		return menuKey;
	}


	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}


	public String getMenuUrl() {
		return menuUrl;
	}


	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

}