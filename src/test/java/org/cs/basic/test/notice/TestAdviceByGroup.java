package org.cs.basic.test.notice;

import java.util.List;

import org.cs.basic.test.util.WXUtils;
import org.cs.basic.weixin.common.AccessToken;
import org.cs.basic.weixin.material.WxMaterialList;
import org.cs.basic.weixin.notice.AdviceByGroup;
import org.cs.basic.weixin.notice.AdviceJsonMsg;
import org.cs.basic.weixin.user.group.GroupManage;
import org.cs.basic.weixin.user.group.util.GroupAllSortBase;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestAdviceByGroup {
	
	@Test
	public void testGetMaterialList() throws Exception{
		JSONObject obj=WxMaterialList.getMaterialList("news", "0", "1", WXUtils.getAccessToken());
		System.out.println(obj);
		JSONArray jsonArray=new JSONArray((List<Object>) obj.get("item"));
		JSONObject obj2=(JSONObject) jsonArray.get(0);
		String media_id=(String) obj2.get("media_id");
		System.out.println(media_id);
	}
	@Test
	public void testSendTextbyGroup() throws Exception{
		AdviceByGroup.sendTextbyGroup("100", "感谢您一直关注yotime,最近降温,记得保暖哦*_*", WXUtils.getAccessToken());
	//	AdviceJsonMsg ajm=AdviceByGroup.sendMpnewsbyGroup("106", "BgOa-6KoSNlLeU1YnCdcw0fQ3Bt0d4gWjWth0Vk6MsU", accessToken);
	//	System.out.println(ajm.getErrcode()+"/"+ajm.getErrmsg());
		
	}
}
