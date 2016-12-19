package org.cs.basic.test.group;

import java.util.List;

import org.cs.basic.test.util.WXUtils;
import org.cs.basic.weixin.common.AccessToken;
import org.cs.basic.weixin.user.group.GroupManage;
import org.cs.basic.weixin.user.group.util.GroupAllSortBase;
import org.junit.Test;

public class TestGroup {
		
	@Test
	public void TestCreateGroup() throws Exception{
		GroupManage.createGroup("test3", WXUtils.getAccessToken());
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
		String error=GroupManage.moveUserGroup("o9pbww_ScLqsHk1a4Pyhmqhs1uDk", "101", WXUtils.getAccessToken());
		System.out.println(error);
	}
}
