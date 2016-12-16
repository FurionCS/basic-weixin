package org.cs.basic.weixin.customer.model.content;

import java.util.HashMap;
import java.util.Map;

/**
 * 客服消息操作ID(会化状态）
 * @author xuxile
 *
 */
public class MapOperCode {

	/** 
    1000	 创建未接入会话
    1001	 接入会话
    1002	 主动发起会话
    1004	 关闭会话
    1005	 抢接会话
    2001	 公众号收到消息
    2002	 客服发送消息
    2003	 客服收到消息 
	 * **/
	private static Map<String, String> mapOperCode=new HashMap<String, String>();
	static{
		
		mapOperCode.put("1000", "创建未接入会话");
		mapOperCode.put("1001", "接入会话");
		mapOperCode.put("1002", "主动发起会话");
		mapOperCode.put("1004", "关闭会话");
		mapOperCode.put("1005", "抢接会话");
		mapOperCode.put("2001", "公众号收到消息");
		mapOperCode.put("2002", "客服发送消息");
		mapOperCode.put("2003", "客服发送消息");
	}
	/**操作码置换客服消息操作ID(会化状态）*/
	public static String getOperCodeDescription(String operCode){
		return mapOperCode.get(operCode);
	}
}
