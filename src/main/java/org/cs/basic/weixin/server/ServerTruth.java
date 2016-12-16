package org.cs.basic.weixin.server;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证消息真实性
 * @author xuxile
 *
 */
public class ServerTruth {

	/**
	 * @param WX_INTERFACE_TOKEN 从本地数据库中查询出的商户的WX_INTERFACE_TOKEN
	 * @param 
	 * get请求进行验证服务器是否正常,进行接口验证֤
	 */
	public static void doServerTruth(String WX_INTERFACE_TOKEN,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		if (null != timestamp && null != nonce && null != echostr && null != signature) {
			if (WeiXin.access(WX_INTERFACE_TOKEN, signature, timestamp, nonce)) {
				response.getWriter().write(echostr);//发送请求内容至页面
				System.out.println(" 验证成功！");
			}
		} else {
			System.out.println(" 验证失败！");
		}
	}
}
