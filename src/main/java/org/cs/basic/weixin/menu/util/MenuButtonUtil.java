package org.cs.basic.weixin.menu.util;
import java.util.ArrayList;
import java.util.List;

import org.cs.basic.weixin.menu.model.Button;
import org.cs.basic.weixin.menu.model.ClickButton;
import org.cs.basic.weixin.menu.model.ComplexButton;
import org.cs.basic.weixin.menu.model.Menu;
import org.cs.basic.weixin.menu.model.ViewButton;
import org.cs.basic.weixin.menu.model.WeixinMenu;
/**根据微信自定义菜单信息列�?取得返回封装的微信菜单信�?
 * @param xuxile
 * */
public class MenuButtonUtil {

	/**
	 * 根据微信自定义菜单信息列�?取得返回封装的微信菜单信�?
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Menu getMenu(List list) {	
		
		if(list.size()<=0){
			return null;
		}
		//下面组装菜单信息
		ArrayList level1_list=new ArrayList();
		ArrayList level2_list=new ArrayList();
		//取出第一群的信息
		for(int i=0;i<list.size();i++){
			WeixinMenu	levelVO = (WeixinMenu)list.get(i);
			if("1".equals(levelVO.getMenuLevel())){//说明是一级菜�?
				level1_list.add(levelVO);
			}else{//这里全是二级菜单				
				level2_list.add(levelVO);  
			}			
		}
		
		ArrayList butList=new ArrayList();
		
		for(int j=0;j<level1_list.size();j++){
			WeixinMenu	level1VO = (WeixinMenu)level1_list.get(j);
			ArrayList but2List = new ArrayList();
			for(int k=0;k<level2_list.size();k++){
				WeixinMenu	level2VO = (WeixinMenu)level2_list.get(k);
				if(level2VO.getParentId().equals(level1VO.getId())){//说明是他的下�?				
					if("click".equals(level2VO.getMenuType())){
						ClickButton	button=new ClickButton();
						button.setName(level2VO.getMenuName());
						button.setType(level2VO.getMenuType());
						button.setKey(level2VO.getMenuKey());
						but2List.add(button);
					}else	if("view".equals(level2VO.getMenuType())){
						ViewButton	button=new ViewButton();
						button.setName(level2VO.getMenuName());
						button.setType(level2VO.getMenuType());
						button.setUrl(level2VO.getMenuUrl());
						but2List.add(button);
					}					
				}			
			}
			
			if(but2List.size()>0){//说明有二级菜�?
				ComplexButton mainBtn = new ComplexButton();
				Button[] menubutton = new Button[but2List.size()];
				menubutton =  (Button[]) but2List.toArray(menubutton);
		        mainBtn.setName(level1VO.getMenuName());
		        mainBtn.setSub_button(menubutton);
		        
		        butList.add(mainBtn);
			}else {//说明没有二级菜单信息
				if("click".equals(level1VO.getMenuType())){
					ClickButton	button=new ClickButton();
					button.setName(level1VO.getMenuName());
					button.setType(level1VO.getMenuType());
					button.setKey(level1VO.getMenuKey());
					 butList.add(button);
				}else	if("view".equals(level1VO.getMenuType())){
					ViewButton	button=new ViewButton();
					button.setName(level1VO.getMenuName());
					button.setType(level1VO.getMenuType());
					button.setUrl(level1VO.getMenuUrl());
					butList.add(button);
				}				
			}
		}
		
		
		Button[] mainBtn = new Button[butList.size()];
		mainBtn =  (Button[]) butList.toArray(mainBtn);
		
		Menu menu = new Menu();
		menu.setButton(mainBtn);
		return menu;
	}
}
