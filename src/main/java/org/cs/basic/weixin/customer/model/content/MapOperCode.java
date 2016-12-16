package org.cs.basic.weixin.customer.model.content;

import java.util.HashMap;
import java.util.Map;

/**
 * �ͷ���Ϣ����ID(�ữ״̬��
 * @author xuxile
 *
 */
public class MapOperCode {

	/** 
    1000	 ����δ����Ự
    1001	 ����Ự
    1002	 ��������Ự
    1004	 �رջỰ
    1005	 ���ӻỰ
    2001	 ���ں��յ���Ϣ
    2002	 �ͷ�������Ϣ
    2003	 �ͷ��յ���Ϣ 
	 * **/
	private static Map<String, String> mapOperCode=new HashMap<String, String>();
	static{
		
		mapOperCode.put("1000", "����δ����Ự");
		mapOperCode.put("1001", "����Ự");
		mapOperCode.put("1002", "��������Ự");
		mapOperCode.put("1004", "�رջỰ");
		mapOperCode.put("1005", "���ӻỰ");
		mapOperCode.put("2001", "���ں��յ���Ϣ");
		mapOperCode.put("2002", "�ͷ�������Ϣ");
		mapOperCode.put("2003", "�ͷ�������Ϣ");
	}
	/**�������û��ͷ���Ϣ����ID(�ữ״̬��*/
	public static String getOperCodeDescription(String operCode){
		return mapOperCode.get(operCode);
	}
}
