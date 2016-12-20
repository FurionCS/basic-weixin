package org.cs.basic.test.group;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.cs.basic.test.util.WXUtils;
import org.cs.basic.weixin.common.AccessToken;
import org.cs.basic.weixin.user.group.GroupManage;
import org.cs.basic.weixin.user.group.util.GroupAllSortBase;
import org.junit.Test;

public class TestGroup {
		
	@Test
	public void TestCreateGroup() throws Exception{
		GroupManage.createGroup("浙江温州市台州店", WXUtils.getAccessToken());
	}
	@Test
	public void TestUpdateGroupNamebyId() throws Exception{
		GroupManage.updateGroupNamebyId("106", "浙江杭州市杭州文一店",  WXUtils.getAccessToken());
	}
	@Test
	public void TestDeleteGroupById() throws ClientProtocolException, IOException{
		GroupManage.deleteUserGroup("107", WXUtils.getAccessToken());
	}
	@Test
	public void TestGetGroups() throws Exception{
		List<GroupAllSortBase> lgasb=GroupManage.getGroups(WXUtils.getAccessToken());
		for (int i = 0; i < lgasb.size(); i++) {
			System.out.println("组名:"+lgasb.get(i).getName()+"---id:"+lgasb.get(i).getId()+"---count:"+lgasb.get(i).getCount());
		}
	}
	@Test
	public void TestMoveUserGroup() throws Exception{
		String error=GroupManage.moveUserGroup("o9pbww7-CwheMiCL9yfgmqx4mOdQ", "102", WXUtils.getAccessToken());
		System.out.println(error);
	}
	
}
