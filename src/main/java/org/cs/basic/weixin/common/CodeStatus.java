package org.cs.basic.weixin.common;

import java.util.HashMap;
import java.util.Map;

/**
 * ȫ�ַ�����˵��
 *@author xuxile 
 **/
public class CodeStatus {
	
	public static Map<String, String> mapCode=new HashMap<String, String>();
	
	static{
		mapCode.put("-1", "ϵͳ��æ");
		mapCode.put("0", "����ɹ�");
		mapCode.put("40001", "��ȡaccess_tokenʱAppSecret���󣬻���access_token��Ч");
		mapCode.put("40002", "���Ϸ���ƾ֤����");
		mapCode.put("40003", "���Ϸ���OpenID");
		mapCode.put("40004", "���Ϸ���ý���ļ�����");
		mapCode.put("40005", "���Ϸ����ļ�����");
		mapCode.put("40006", "���Ϸ����ļ���С");
		mapCode.put("40007", "���Ϸ���ý���ļ�id");
		mapCode.put("40008", "���Ϸ�����Ϣ����");
		mapCode.put("40009", "���Ϸ���ͼƬ�ļ���С");
		mapCode.put("40010", "���Ϸ��������ļ���С");
		mapCode.put("40011", "���Ϸ�����Ƶ�ļ���С");
		mapCode.put("40012", "���Ϸ�������ͼ�ļ���С");
		mapCode.put("40013", "���Ϸ���APPID");
		mapCode.put("40014", "���Ϸ���access_token");
		mapCode.put("40015", "���Ϸ��Ĳ˵�����");
		mapCode.put("40016", "���Ϸ��İ�ť����");
		mapCode.put("40017", "���Ϸ��İ�ť����");
		mapCode.put("40018", "���Ϸ��İ�ť���ֳ���");
		mapCode.put("40019", "���Ϸ��İ�ťKEY����");
		mapCode.put("40020", "���Ϸ��İ�ťURL����");
		mapCode.put("40021", "���Ϸ��Ĳ˵��汾��");
		mapCode.put("40022", "���Ϸ����Ӳ˵�����");
		mapCode.put("40023", "���Ϸ����Ӳ˵���ť����");
		mapCode.put("40024", "���Ϸ����Ӳ˵���ť����");
		mapCode.put("40025", "���Ϸ����Ӳ˵���ť���ֳ���");
		mapCode.put("40026", "���Ϸ����Ӳ˵���ťKEY����");
		mapCode.put("40027", "���Ϸ����Ӳ˵���ťURL����");
		mapCode.put("40028", "���Ϸ����Զ���˵�ʹ���û�");
		mapCode.put("40029", "���Ϸ���oauth_code");
		mapCode.put("40030", "���Ϸ���refresh_token");
		mapCode.put("40031", "���Ϸ���openid�б�");
		mapCode.put("40032", "���Ϸ���openid�б���");
		mapCode.put("40033", "���Ϸ��������ַ������ܰ���\\uxxxx��ʽ���ַ�");
		mapCode.put("40035", "���Ϸ��Ĳ���");
		mapCode.put("40038", "���Ϸ��������ʽ");
		mapCode.put("40039", "���Ϸ���URL����");
		mapCode.put("40050", "���Ϸ��ķ���id");
		mapCode.put("40051", "�������ֲ��Ϸ�");
		mapCode.put("41001", "ȱ��access_token����");
		mapCode.put("41002", "ȱ��appid����");
		mapCode.put("41003", "ȱ��refresh_token����");
		mapCode.put("41004", "ȱ��secret����");
		mapCode.put("41005", "ȱ�ٶ�ý���ļ�����");
		mapCode.put("41006", "ȱ��media_id����");
		mapCode.put("41007", "ȱ���Ӳ˵�����");
		mapCode.put("41008", "ȱ��oauth code");
		mapCode.put("41009", "ȱ��openid");
		mapCode.put("42001", "access_token��ʱ");
		mapCode.put("42002", "refresh_token��ʱ");
		mapCode.put("42003", "oauth_code��ʱ");
		mapCode.put("43001", "��ҪGET����");
		mapCode.put("43002", "��ҪPOST����");
		mapCode.put("43003", "��ҪHTTPS����");
		mapCode.put("43004", "��Ҫ�����߹�ע");
		mapCode.put("43005", "��Ҫ���ѹ�ϵ");
		mapCode.put("44001", "��ý���ļ�Ϊ��");
		mapCode.put("44002", "POST�����ݰ�Ϊ��");
		mapCode.put("44003", "ͼ����Ϣ����Ϊ��");
		mapCode.put("44004", "�ı���Ϣ����Ϊ��");
		mapCode.put("45001", "��ý���ļ���С��������");
		mapCode.put("45002", "��Ϣ���ݳ�������");
		mapCode.put("45003", "�����ֶγ�������");
		mapCode.put("45004", "�����ֶγ�������");
		mapCode.put("45005", "�����ֶγ�������");
		mapCode.put("45006", "ͼƬ�����ֶγ�������");
		mapCode.put("45007", "��������ʱ�䳬������");
		mapCode.put("45008", "ͼ����Ϣ��������");
		mapCode.put("45009", "�ӿڵ��ó�������");
		mapCode.put("45010", "�����˵�������������");
		mapCode.put("45015", "�ظ�ʱ�䳬������");
		mapCode.put("45016", "ϵͳ���飬�������޸�");
		mapCode.put("45017", "�������ֹ���");
		mapCode.put("45018", "����������������");
		mapCode.put("46001", "������ý������");
		mapCode.put("46002", "�����ڵĲ˵��汾");
		mapCode.put("46003", "�����ڵĲ˵�����");
		mapCode.put("46004", "�����ڵ��û�");
		mapCode.put("47001", "����JSON/XML���ݴ���");
		mapCode.put("48001", "api����δ��Ȩ");
		mapCode.put("50001", "�û�δ��Ȩ��api");
	}
	
	/**����ȫ����˵��**/
    public static String getCodeStatus(String code){
	    return mapCode.get(code);
    }

}
