package org.cs.basic.test.notice;

import java.util.List;

import org.cs.basic.weixin.common.AccessToken;
import org.cs.basic.weixin.notice.AdviceByGroup;
import org.cs.basic.weixin.notice.AdviceJsonMsg;
import org.cs.basic.weixin.user.group.GroupManage;
import org.cs.basic.weixin.user.group.util.GroupAllSortBase;
import org.junit.Test;

public class TestAdviceByGroup {
	@Test
	public void testSendTextbyGroup() throws Exception{
		/*String accessToken=AccessToken.getAccessToken("wxee3c721dfbbfe208", "7b350f238c7e8cf1d30c30699fb0f754");
		System.out.println(accessToken);
		List<GroupAllSortBase> gasb=GroupManage.getGroups(accessToken);
		for(GroupAllSortBase g:gasb){
			System.out.println(g.getId()+"/"+g.getName()+"/"+g.getCount());
		}*/
	//	AdviceByGroup.sendTextbyGroup("106", "感谢您一直关注yotime,最近降温,记得保暖哦*_*", accessToken);
	//	AdviceJsonMsg ajm=AdviceByGroup.sendMpnewsbyGroup("106", "BgOa-6KoSNlLeU1YnCdcw0fQ3Bt0d4gWjWth0Vk6MsU", accessToken);
	//	System.out.println(ajm.getErrcode()+"/"+ajm.getErrmsg());
//		AdviceByGroup.sendTextbyGroup("2", "happy", accessToken);
	}
}
