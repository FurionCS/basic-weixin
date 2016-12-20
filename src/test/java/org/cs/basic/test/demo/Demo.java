package org.cs.basic.test.demo;

import org.cs.basic.weixin.common.AccessToken;
import org.cs.basic.weixin.common.CodeStatus;
import org.cs.basic.weixin.customer.CustomerService;
import org.cs.basic.weixin.keyword.WxSendMessageWeiXin;
import org.cs.basic.weixin.material.WxUploadNews;
import org.cs.basic.weixin.media.WXUploadFile;
import org.cs.basic.weixin.menu.WxMenuManage;
import org.cs.basic.weixin.notice.AdviceByGroup;
import org.cs.basic.weixin.notice.AdviceByOpenID;
import org.cs.basic.weixin.notice.AdviceDelete;
import org.cs.basic.weixin.oauth.OAuthManage;
import org.cs.basic.weixin.qr.QrManage;
import org.cs.basic.weixin.server.ServerTruth;
import org.cs.basic.weixin.server.ServerWeiXin;
import org.cs.basic.weixin.template.Template;
import org.cs.basic.weixin.tools.aibang.AiBangBusStation;
import org.cs.basic.weixin.tools.baidu.baike.BaiduBaikeCrawler;
import org.cs.basic.weixin.tools.baidu.map.PositionTools;
import org.cs.basic.weixin.tools.baidu.music.BaiduMusicService;
import org.cs.basic.weixin.tools.rijiben.TodayService;
import org.cs.basic.weixin.tools.weather.WeatherHelper;
import org.cs.basic.weixin.user.base.UserManage;
import org.cs.basic.weixin.user.group.GroupManage;

/**
 * @param WeiXin SDK Demo1.0
 * @author xuxile 
 */
public class Demo {

	
	public static void main(String[] args) throws Exception {
		/**************************************************SDK各类功能说明begin****************************************/
		 System.out.println("SDK各类功能说明");
		 System.out.println(AccessToken.class+"  "+"微信调用接口凭证"+AccessToken.class.getName());
		 System.out.println(CodeStatus.class+"："+"全局返回码说明");
		 System.out.println(CustomerService.class+"："+"客服消息服务");
		 System.out.println(WxSendMessageWeiXin.class+"："+"公众平台，返回信息处理");
		 System.out.println(WxUploadNews.class+"："+"上传图文消息素材");
		 System.out.println(WXUploadFile.class+"："+"微信上传文件接口");
		 System.out.println(WxMenuManage.class+"："+"自定义菜单管理");
		 System.out.println(AdviceByGroup.class+"："+"根据分组进行群发信息类");
		 System.out.println(AdviceByOpenID.class+"："+"根据OpenID进行群发信息类");
		 System.out.println(AdviceDelete.class+"："+"删除群发信息类");
		 System.out.println(Template.class+"："+"模板消息操作类");
		 System.out.println(OAuthManage.class+"："+"微信网页授权管理类");
		 System.out.println(QrManage.class+"："+"生成带参数的二维码");
		 System.out.println(ServerTruth.class+"："+"验证消息真实性");
		 System.out.println(ServerWeiXin.class+"："+"用户发来的信息之逻辑处理类");
		 System.out.println(UserManage.class+"："+"关注者管理类");
		 System.out.println(GroupManage.class+"："+"用户分组信息管理类");
		 System.out.println("快递查询接口：http://m.kuaidi100.com/index_all.html");
		 System.out.println(AiBangBusStation.class+"：公交查询"+"");
		 System.out.println(BaiduBaikeCrawler.class+"："+"百度百科数据的爬取器");
		 System.out.println(PositionTools.class+"："+"百度地图地址信息查询");
		 System.out.println(BaiduMusicService.class+"："+"百度音乐搜索API操作类");
		 System.out.println(TodayService.class+"："+"历史上的今天服务类");
		 System.out.println(WeatherHelper.class+"："+"天气查询管理类");
		/**************************************************SDK各类功能说明end******************************************/
		
	}

}
