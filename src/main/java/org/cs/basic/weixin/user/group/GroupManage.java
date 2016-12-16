package org.cs.basic.weixin.user.group;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cs.basic.weixin.common.HttpClientConnectionManager;
import org.cs.basic.weixin.user.group.model.GroupCreateVo;
import org.cs.basic.weixin.user.group.model.GroupMoveUserVo;
import org.cs.basic.weixin.user.group.model.GroupQueryUserVo;
import org.cs.basic.weixin.user.group.model.GroupUpdateVo;
import org.cs.basic.weixin.user.group.util.GroupAllSortBase;
import org.cs.basic.weixin.user.group.util.GroupCreateBase;
import org.cs.basic.weixin.user.group.util.GroupUpdateBase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 用户分组信息管理�?
 * @author xuxile 
 * */
public class GroupManage {
	// http客户�?
	public static DefaultHttpClient httpclient;
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager.getSSLInstance(httpclient); // 接受任何证书的浏览器客户�?
	}
	
	/**
	 * 创建用户分组
	 * @param text 分组名称 
	 * @param  accessToken 微信验证�?
	 */
	public static GroupUpdateBase createGroup(String text,String accessToken) throws Exception{
		GroupCreateBase group=new GroupCreateBase(text);
		GroupCreateVo groupCreateVo=new GroupCreateVo(group);
		String create_json=net.sf.json.JSONObject.fromObject(groupCreateVo).toString();
		HttpPost httpost= HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/groups/create?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(create_json, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject obj = JSON.parseObject(jsonStr);
		JSONObject object = JSON.parseObject(obj.get("group").toString());
		String id=object.getString("id");
		String name=object.getString("name");
		GroupUpdateBase groupUpdateBase=new GroupUpdateBase(id, name);
		return groupUpdateBase;
	}
	
	
	/**
	 * 查询分组
	 * @param  accessToken 微信验证�?
	 */
	public static List<GroupAllSortBase> getGroups(String accessToken) throws Exception{
		HttpPost httpost= HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/groups/get?access_token=" + accessToken);
		HttpResponse response=httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		//将查询结果封装到List集合�?��
		JSONObject object = JSON.parseObject(jsonStr);
		String groupsString=object.getString("groups");
		JSONArray jsonArr = JSONArray.fromObject(groupsString);
		List<GroupAllSortBase> list=new ArrayList<GroupAllSortBase>();
		for (int i = 0; i < jsonArr.size(); i++) {
			GroupAllSortBase g=new GroupAllSortBase(jsonArr.getJSONObject(i).getString("id"),
					jsonArr.getJSONObject(i).getString("name"), 
					jsonArr.getJSONObject(i).getString("count"));
            list.add(g);
       }
		//将查询结果封装到List集合结束
		return list;
	}

	
	/**
	 * 查询用户�?��分组
	 * @param OpenID 用户微信�?��ID
	 * @param accessToken 微信验证�?
	 */
	public static String getUserGroupId(String OpenID,String accessToken) throws Exception{
		GroupQueryUserVo groupQueryUserVo=new GroupQueryUserVo(OpenID);
		String user_json=net.sf.json.JSONObject.fromObject(groupQueryUserVo).toString();
		HttpPost httpost= HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(user_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject obj = JSON.parseObject(jsonStr);
		String groupid=obj.getString("groupid");
		return groupid;
	}
	
	
	/**
	 * 修改分组�?
	 * @param accessToken 微信验证�?
	 * @param id 分组id，由微信分配
	 * @param name 分组名字�?0个字符以内）
	 */
	public static String updateGroupNamebyId(String id,String name,String accessToken) throws Exception{
		GroupUpdateBase group=new GroupUpdateBase(id, name);
		GroupUpdateVo groupUpdateVo=new GroupUpdateVo(group);
		String update_json=net.sf.json.JSONObject.fromObject(groupUpdateVo).toString();
	    HttpPost httpost= HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/groups/update?access_token=" + accessToken);
	    httpost.setEntity(new StringEntity(update_json, "UTF-8"));
	    HttpResponse response= httpclient.execute(httpost);
	    String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
	    JSONObject obj = JSON.parseObject(jsonStr);
		String errcode=obj.getString("errcode");
	    return errcode;
	}
	
	
	/**
	 * 移动用户分组
	 * @throws Exception 
	 */
	public static String moveUserGroup(String openid,String to_groupid,String accessToken) throws Exception{
		GroupMoveUserVo groupMoveUserVo=new GroupMoveUserVo(openid, to_groupid);
		String move_json=net.sf.json.JSONObject.fromObject(groupMoveUserVo).toString();
		HttpPost httpost = HttpClientConnectionManager.getPostMethod("https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=" + accessToken);
		httpost.setEntity(new StringEntity(move_json, "UTF-8"));
		HttpResponse response= httpclient.execute(httpost);
		String jsonStr= EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject obj = JSON.parseObject(jsonStr);
		String errcode=obj.getString("errcode");
		return errcode;
	}
}