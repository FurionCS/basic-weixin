package org.cs.basic.weixin.user.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.user.model.WxUser;
import org.cs.basic.weixin.user.model.WxUserClump;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * ��ע�߹�����
 * @author xuxile 
 * */
public class UserManage {
	// http�ͻ���
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // �����κ�֤���������ͻ���
	}
	
	/**
	 * ��ȡ��ע�߻�����Ϣ
	 * @throws Exception
	 */
	public static WxUser getUserInfo(String OpenID,String accessToken) throws Exception{
		HttpGet get = HttpClientConnectionManager.getGetMethod("https://api.weixin.qq.com/cgi-bin/user/info?access_token="
				+accessToken+"&openid="+OpenID+"&lang=zh_CN");
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		String sex=object.getString("sex");
		if("1".equals(sex)){
			sex="��";
		}else if ("2".equals(sex)) {
			sex="Ů";
		}else if ("0".equals(sex)) {
			sex="δ֪";
		}
		String language=object.getString("language");
		if("zh_CN".equals(language)){
			language="����";
		}else if ("zh_TW".equals(language)) {
			language="����";
		}else if ("en".equals(language)) {
			language="Ӣ��";
		}
		String subscribe=object.getString("subscribe");
		if("0".equals(subscribe)){
			subscribe="δ����";
		}else{
			subscribe="�Ѷ���";
		}
		String subscribeTime=object.getString("subscribe_time");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		subscribeTime = sdf.format(new Date(Long.valueOf(subscribeTime)*1000L));
		
		WxUser user=new WxUser();
		user.setCity(object.getString("city"));
		user.setCountry(object.getString("country"));
		user.setHeadimgurl(object.getString("headimgurl"));
		user.setLanguage(language);
		user.setNickname(object.getString("nickname"));
		user.setOpenid(object.getString("openid"));
		user.setProvince(object.getString("province"));
		user.setSex(sex);
		user.setSubscribe(subscribe);
		user.setSubscribe_time(subscribeTime);
		return user;
	}
	
	/**
	 * һ������ȡ��ȡ��ע���б� �����ȡ10000����ע����Ϣ
	 * @param NEXT_OPENID ��ȡ�б�ĺ�һ���û���OPENID
	 */
	public static WxUserClump getUserList(String NEXT_OPENID,String accessToken) throws Exception{
		String url="https://api.weixin.qq.com/cgi-bin/user/get?access_token="+accessToken;
		if(NEXT_OPENID!=null&&!"".equals(NEXT_OPENID)){
		   url+="&next_openid="+NEXT_OPENID;
		}
		HttpGet get = HttpClientConnectionManager.getGetMethod(url);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		int total=object.getIntValue("total");
		int count=object.getIntValue("count");
		String next_openid=object.getString("next_openid");
		
		if("".equals(next_openid)){
			return new WxUserClump(total, count, null, next_openid);
		}
		JSONObject obj= JSON.parseObject(object.getString("data"));
		String open_id_string=obj.getString("openid").toString();
		List<String> data = JSON.parseArray(open_id_string, String.class);	
		List<WxUser> wxUsers=new ArrayList<WxUser>();
		for(int i=0;i<data.size();i++){
			wxUsers.add(getUserInfo(data.get(i), accessToken));
		}
		
		WxUserClump wxUserClump=new WxUserClump(total, count, wxUsers, next_openid);
		return wxUserClump;
	}
	
	/**
	 * ��ȡȫ����ע���б�
	 * @param NEXT_OPENID ��ȡ�б�ĺ�һ���û���OPENID
	 */
	public static WxUserClump getAllUserList(String accessToken) throws Exception{
		int total=0;//��ע�ù����˺ŵ����û���
		int count=0;//��ȡ��OPENID���������ֵΪ10000
		String nextOpenid=null;//��ȡ�б�ĺ�һ���û���OPENID
		List<WxUser> wxUsers=new ArrayList<WxUser>();//�û�����
		while (nextOpenid==null||!"".equals(nextOpenid)) {
				WxUserClump clump=getUserList(nextOpenid, accessToken);
				if(clump.getWxUsers()!=null){
					wxUsers.addAll(clump.getWxUsers());
					nextOpenid=clump.getNext_openid();
				}else {
					nextOpenid="";
				}
				total=clump.getTotal();
				count=total;
		}
		WxUserClump wxUserClump=new WxUserClump(total, count, wxUsers, nextOpenid);
		return wxUserClump;
	}
	
}
