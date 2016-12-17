package org.cs.basic.test.template;

import java.util.List;

import org.cs.basic.weixin.common.AccessToken;
import org.cs.basic.weixin.template.Template;
import org.cs.basic.weixin.template.model.IndustryModel;
import org.cs.basic.weixin.template.model.TemplateModel;
import org.cs.basic.weixin.template.model.TemplateSendResultModel;
import org.cs.basic.weixin.template.model.TemplateValueAndColor;
import org.cs.basic.weixin.user.base.UserManage;
import org.cs.basic.weixin.user.model.WxUser;
import org.junit.Test;

public class TestTemplate {
	@Test
	public void testGetIndustry() throws Exception{
		String accessToken=AccessToken.getAccessToken("wx2b1b15e0e9bf193a", "f6fc6b4f3b57bde35bdf02e85f74c5a6");
		System.out.println(accessToken);
		List<IndustryModel> lim=Template.getIndustry(accessToken);
		for(IndustryModel im:lim){
			System.out.println(im);
		}
	}
	@Test
	public void testGetAllPrivateTemplate() throws Exception{
		String accessToken=AccessToken.getAccessToken("wx2b1b15e0e9bf193a", "f6fc6b4f3b57bde35bdf02e85f74c5a6");
		System.out.println(accessToken);
		List<TemplateModel> ltm=Template.getAllPrivateTemplate(accessToken);
		for(TemplateModel tm:ltm){
			System.out.println(tm);
		}
	}
	@Test
	public void testSendTemplate() throws Exception{
		String accessToken=AccessToken.getAccessToken("wx2b1b15e0e9bf193a", "f6fc6b4f3b57bde35bdf02e85f74c5a6");
	//	System.out.println(accessToken);
		TemplateSendModel tsm=new TemplateSendModel();
		tsm.setTouser("o9pbww7-CwheMiCL9yfgmqx4mOdQ");
		tsm.setTemplate_id("QUjciCZOQ0UW7aRSM8Umin9EOW84JB6dlRApuYdUj44");
		tsm.setUrl("wwww.yotime.com");
		TemplateDate td=new TemplateDate();
		TemplateValueAndColor tvc0=new TemplateValueAndColor("恭喜您成功购买！","#173177");
		TemplateValueAndColor tvc1=new TemplateValueAndColor("巧克力a","#173177");
		TemplateValueAndColor tvc2=new TemplateValueAndColor("欢迎下次光临","#173177");
		td.setFirst(tvc0);
		td.setProduct(tvc1);
		td.setRemark(tvc2);
		tsm.setData(td);
		String templSenddatestr=net.sf.json.JSONObject.fromObject(tsm).toString();
		System.out.println(templSenddatestr);
		TemplateSendResultModel ltm=Template.sendTemplate(templSenddatestr, accessToken);
		System.out.println(ltm.getErrcode()+"/"+ltm.getErrmsg()+"/"+ltm.getMsgid());
	}
	@Test
	public void testUser() throws Exception{
		String accessToken=AccessToken.getAccessToken("wxe3455c4963273a2c", "e7b62ad9d101b3fbec1ac03bfbcb1974");
		
		WxUser wu=UserManage.getUserInfo("obDqTjmZMQ8zr05r6UQtWefeIBUY", accessToken);
		System.out.println(wu);
	}
}
