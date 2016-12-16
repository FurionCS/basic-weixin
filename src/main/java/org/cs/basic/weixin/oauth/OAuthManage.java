package org.cs.basic.weixin.oauth;

import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.oauth.model.OauthAccessToken;
import org.cs.basic.weixin.oauth.model.OauthUser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 微信网页授权管理类
 * @author xuxile
 *
 */
public class OAuthManage {
	// http客户端
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}

	/**获得引导关注者打开的页面地址
	 * @param appid 公众号的唯一标识
	 * @param redirect_uri 授权后重定向的回调链接地址
	 * @param scope 应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
	 *                               snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、
	 *                               所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
	 * @param state 重定向后会带上state参数，开发者可以填写a-z A-Z 0-9的参数值
	 * */
	@SuppressWarnings("deprecation")
	public static String getLeadOAuthUrl(String appid,String redirect_uri,String scope,String state){
		String do_redirect_uri=URLEncoder.encode(redirect_uri);
		String oauth_url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid
		+"&redirect_uri="+do_redirect_uri+"&response_type=code&scope="+scope+"&state="+state+"#wechat_redirect";
		return oauth_url;
	}
	
	/**
	 * 通过code换取网页授权access_token ,code是用户同意授权后获取的code，
	 * 这里通过code换取的网页授权access_token,与基础支持中的access_token不同。
	 * @param appid 公众号的唯一标识
	 * @param secret 公众号的appsecret
	 * @param code 填写第一步获取的code参数
	 */
	public static OauthAccessToken get_oauth_access_token_by_code(String appid,String secret,String code) throws Exception{
		HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code");
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String access_token=object.getString("access_token");
		int expires_in=object.getIntValue("expires_in");
		String refresh_token=object.getString("refresh_token");
		String openid=object.getString("openid");
		String scope=object.getString("scope");
		OauthAccessToken oauthAccessToken=new OauthAccessToken(access_token, expires_in, refresh_token, openid, scope);
		return oauthAccessToken;
	}
	
	/**
	 * 刷新access_token（如果需要）
	 * @param appid 公众号的唯一标识
	 * @param refresh_token 填写通过access_token获取到的refresh_token参数,
	 *        refresh_token拥有较长的有效期（7天、30天、60天、90天），当refresh_token失效的后，需要用户重新授权。
	 */
	public static OauthAccessToken get_oauth_access_token_by_refresh_token(String appid,String refresh_token) throws Exception{
		HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+appid
				+"&grant_type=refresh_token&refresh_token="+refresh_token);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String access_token=object.getString("access_token");
		int expires_in=object.getIntValue("expires_in");
		String new_refresh_token=object.getString("refresh_token");
		String openid=object.getString("openid");
		String scope=object.getString("scope");
		OauthAccessToken oauthAccessToken=new OauthAccessToken(access_token, expires_in, new_refresh_token, openid, scope);
		return oauthAccessToken;
	}
	
	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 * @param access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param openid 用户的唯一标识
	 */
	public static OauthUser get_oauth_user_info(String access_token,String openid) throws Exception{
		HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/sns/userinfo?access_token="+
				access_token+"&openid="+openid+"&lang=zh_CN");
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);;
		String new_openid=object.getString("openid");
		String nickname=object.getString("nickname");
		String sex=object.getString("sex");
		if("1".equals(sex)){
			sex="男";
		}else if ("2".equals(sex)) {
			sex="女";
		}else if ("0".equals(sex)) {
			sex="未知";
		}
		String province=object.getString("province");
		String city=object.getString("city");
		String country=object.getString("country");
		String headimgurl=object.getString("headimgurl");
		JSONArray privilege=object.getJSONArray("privilege");
		OauthUser oauthUser=new OauthUser(new_openid, nickname, sex, city, country, province, headimgurl, privilege);
		return oauthUser;
	}
}
