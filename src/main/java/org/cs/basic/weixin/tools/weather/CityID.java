package org.cs.basic.weixin.tools.weather;

import java.util.HashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author xuxile
 */
public class CityID {

	public static HashMap<String , String> map = new HashMap<String,String>();

	public static void main(String[] args) {

		CityID ci = new CityID();
		ci.queryCityID();
		String hangzhou=map.get("杭州");
		String chongqing =map.get("重庆");
		System.out.println("杭州的编码是"+hangzhou+"\n"+"重庆的编码是"+chongqing);
		
		
	}
	
	private String queryCityID(){
		String cityId = null;
//获取包含城市及其编码信息的json字符串；		
		JSONCitys jc= new JSONCitys();
		String city=jc.getCitys();		
//将json字符串转化成对应的jsonObject		
		JSONObject obj = JSONObject.fromObject(city);
		JSONArray province = (JSONArray)obj.get("china");
		for(int i=0;i<province.size();i++){
			JSONObject obj1 = (JSONObject)province.get(i);
			JSONArray citys=(JSONArray)obj1.get("citys");
			for(int j=0;j<citys.size();j++){
				JSONObject obj2 = (JSONObject)citys.get(j);
				String x = obj2.getString("cityName");
				String y = obj2.getString("cityId");
				map.put(x, y);
				//System.out.println((count++)+" : "+x+" -- "+y);
				
			}
		}
		
		
		return cityId;
	}
	
	public HashMap<String,String> getCityIDMap(){
		HashMap<String , String> maps = new HashMap<String,String>();
		queryCityID();
		maps.putAll(map);
		return maps;
	}
}
