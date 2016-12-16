package org.cs.basic.weixin.tools.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONObject;

/**
 * 天气查询管理类
 * @author xuxile
 */
public class WeatherHelper {

	public static void main(String[] args) {			
					
	   
		System.out.println( getWeatherReportByCityName("合肥"));

	}
	
	/**根据城市名称查询城市天气*/
	@SuppressWarnings("unchecked")
	public static String getWeatherReportByCityName(String cityName){
		CityID ci = new CityID();
        HashMap mp=ci.getCityIDMap();					
		WeatherHelper bae2= new WeatherHelper();
		String x=bae2.getWeatherReport((String) mp.get(cityName));
		return x;
	}
	
	/**根据城市编码查询城市天气*/
	public  String getWeatherReport(String cityId){
		String weather = "";
		Logger logger = Logger. getLogger("socket");
        try {
          		Socket s = new Socket("www.weather.com.cn",80);
          		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));

				OutputStream out = s.getOutputStream();
          		//http://www.weather.com.cn/data/cityinfo/101010100.html
				StringBuffer sb = new StringBuffer("GET /data/cityinfo/"+cityId+".html HTTP/1.1\r\n");        
				sb.append("User-Agent: Java/1.6.0_20\r\n");
				sb.append("Host: www.weather.com.cn\r\n");
				sb.append("Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\r\n");
				sb.append("Connection: Close\r\n");
				sb.append("\r\n");
 				out.write(sb.toString().getBytes());
 				
 				String tmp = "";
 				String post="";
          		/*****3. 获取返回结果*****/
				while((tmp = br.readLine())!=null){
    				post+=tmp;
				}
				int x = post.indexOf("{");
				int y =post.lastIndexOf("}");
				String weatherx = post.substring(x,y+1);
				weather=parseJSONWeather(weatherx);
				out.close();
				br.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
        
        return weather;
	}
	
	private String parseJSONWeather(String jsonStr){
		String weather ="";
		JSONObject obj = JSONObject.fromObject(jsonStr);
		JSONObject b=(JSONObject)obj.get("weatherinfo");
		//System.out.println(obj1.get("temp1"));
		weather="地区："+(String)b.get("city")+" \n"+"天气："+(String)b.get("weather")+"\n" +
				"气温："+(String)b.get("temp2")+"~"+(String)b.get("temp1")+"\n"+
				"发布时间："+(String)b.get("ptime");				
				
		return weather;
	}
	
}
