package org.cs.basic.weixin.tools.aibang;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.cs.basic.weixin.tools.HttpRequestTools;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 * 公交查询
 * @author xuxile
 * 
 */
public class AiBangBusStation {
	public static void main(String[] args) {
		//周边公交站点查询
		//List<AiBangBusStationBean> list = getNearByBusStations("南京","118.789566","32.030751");
		//for (int i = 0; i < list.size(); i++) {
		//	AiBangBusStationBean aiBangBusStationBean = list.get(i);
		//	System.out.println(aiBangBusStationBean.getName() + "  " + aiBangBusStationBean.getDist()+"米");
		//}
		
		
		//公交站台线路信息
		//AiBangBusStationBean bean = getBusStationDetailByName("合肥", "科学大道");
		//System.out.println(bean.getLine_names());
		
		
		//根据关键字信息获取公交线路详细信息
		//AiBangBusStationBean bean = getgetBusLineDetailInfo("合肥", "22路");
		//System.out.println(bean.getLineStats());
		
		
		//根据公交号查询公交线路 有往返两个数据
		//List<AiBangBusStationBean> list=searchBusLineByNum("合肥", "22");
		//for (int i = 0; i <list.size(); i++) {
		//	System.out.println(list.get(i).getLineInfo()+":"+list.get(i).getLineStats());;
		//}
	}
	
	/**
	 * 公交线路查询 有往返两个数据
	 * @param cityName 城市名称
	 * @param lineNum 公交号
	 */
	@SuppressWarnings("unchecked")
	public static List<AiBangBusStationBean> searchBusLineByNum(String cityName, String lineNum) {
		StringBuffer sbUrl = new StringBuffer();
		sbUrl.append("http://openapi.aibang.com/bus/lines");
		sbUrl.append("?app_key=" + AiBangIconst.AI_BANG_API_KEY);
		sbUrl.append("&city=" + cityName); // 城市
		sbUrl.append("&q=" + lineNum); // 距离(单位：米)
		List<AiBangBusStationBean> listLine = new ArrayList<AiBangBusStationBean>();
		String pageContext = HttpRequestTools.getHttpClientHtml(sbUrl.toString(),"UTF-8");
		if(pageContext != null && !"".equals(pageContext)) {
			SAXBuilder sax = new SAXBuilder();
			try {
				StringReader read = new StringReader(pageContext);
				// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
				InputSource source = new InputSource(read);
				// 通过输入源构造一个Document
				Document doc = sax.build(source);
				// 取的根元素
				Element root = doc.getRootElement();
				List listChild = root.getChild("lines").getChildren();
				for (int i = 0; i < listChild.size(); i++) {
					Element elementstat = (Element) listChild.get(i);
					AiBangBusStationBean beans = new AiBangBusStationBean();
					beans.setName(elementstat.getChildText("name"));
					beans.setCityName(cityName);
					beans.setLineInfo(elementstat.getChildText("info"));
					beans.setLineStats(elementstat.getChildText("stats"));
					listLine.add(beans);
				}
			} catch (Exception e) {
				e.printStackTrace();
				//ExceptionTools.getExceptionDetail(e, "获取附近公交站台信息错误！");
			}
		}
		return listLine;
	}

	/**
	 * 周边公交站点查询
	 * @param cityName 城市名称
	 * @param location_x 经度
	 * @param location_y 维度
	 */
	@SuppressWarnings("unchecked")
	public static List<AiBangBusStationBean> getNearByBusStations(String cityName, String location_x,String location_y) {
		StringBuffer sbUrl = new StringBuffer();
		sbUrl.append("http://openapi.aibang.com/bus/stats_xy");
		sbUrl.append("?app_key=" + AiBangIconst.AI_BANG_API_KEY);
		sbUrl.append("&city=" + cityName); // 城市
		sbUrl.append("&lng="+ location_x); // 经度
		sbUrl.append("&lat=" + location_y); // 纬度
		sbUrl.append("&dist=500"); // 距离(单位：米)
		List<AiBangBusStationBean> listNearByBus = new ArrayList<AiBangBusStationBean>();
		String pageContext = HttpRequestTools.getHttpClientHtml(sbUrl.toString(),"UTF-8");
		//System.out.println(sbUrl.toString());
		if(pageContext != null && !"".equals(pageContext)) {
			SAXBuilder sax = new SAXBuilder();
			try {
				StringReader read = new StringReader(pageContext);
				// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
				InputSource source = new InputSource(read);
				// 通过输入源构造一个Document
				Document doc = sax.build(source);
				// 取的根元素
				Element root = doc.getRootElement();
				List listChild = root.getChild("stats").getChildren();
				for (int i = 0; i < listChild.size(); i++) {
					Element elementstat = (Element) listChild.get(i);
					AiBangBusStationBean beans = new AiBangBusStationBean();
					beans.setName(elementstat.getChildText("name"));
					
					String[] locations = elementstat.getChildText("xy").split(",");
					beans.setLocation_x(locations[0]);
					beans.setLocation_y(locations[1]);
					beans.setDist(elementstat.getChildText("dist"));
					beans.setLine_names(elementstat.getChildText("line_names"));
					listNearByBus.add(beans);
				}
			} catch (Exception e) {
				//e.printStackTrace();				
				System.out.println("获取附近公交站台信息错误！");			
				listNearByBus = null;
			}
		}
		return listNearByBus;
	}
	
	/**
	 * 根据城市名称，公交站名称，获取公交站台线路信息
	 * @param cityName 城市名称
	 * @param stationName 站台名称 关键字 如：大羊坊、五道口
	 */
	
	@SuppressWarnings("unchecked")
	public static AiBangBusStationBean getBusStationDetailByName(String cityName, String stationName) {
		StringBuffer sbUrl = new StringBuffer();
		sbUrl.append("http://openapi.aibang.com/bus/stats");
		sbUrl.append("?app_key=" + AiBangIconst.AI_BANG_API_KEY);
		sbUrl.append("&city=" + cityName); // 城市
		sbUrl.append("&q="+ stationName); // 经度
		String pageContext = HttpRequestTools.getHttpClientHtml(sbUrl.toString(),"UTF-8");
		
		AiBangBusStationBean beans = null;
		SAXBuilder sax = new SAXBuilder();
		try {
			StringReader read = new StringReader(pageContext);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 通过输入源构造一个Document
			Document doc = sax.build(source);
			// 取的根元素
			Element root = doc.getRootElement();
			List listChild = root.getChild("stats").getChildren();
			if(listChild != null && listChild.size() != 0) {
				Element elementstat = (Element) listChild.get(0);
				beans = new AiBangBusStationBean();
				beans.setName(elementstat.getChildText("name"));
				
				String[] locations = elementstat.getChildText("xy").split(",");
				beans.setLocation_x(locations[0]);
				beans.setLocation_y(locations[1]);
				beans.setDist(elementstat.getChildText("dist"));
				beans.setLine_names(elementstat.getChildText("line_names"));
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("根据城市名称，公交站名称，获取公交站台线路信息错误！");				
		}
		return beans;
	}
	
	
	/**
	 * 获取公交线路详细信息
	 * @param cityName 城市名称
	 * @param code 关键字	 如：466、1路
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static AiBangBusStationBean getgetBusLineDetailInfo(String cityName, String code) {
		StringBuffer sbUrl = new StringBuffer();
		sbUrl.append("http://openapi.aibang.com/bus/lines");
		sbUrl.append("?app_key=" + AiBangIconst.AI_BANG_API_KEY);
		sbUrl.append("&city=" + cityName); // 城市
		sbUrl.append("&q="+ code); // 经度
		String pageContext = HttpRequestTools.getHttpClientHtml(sbUrl.toString(),"UTF-8");
		
		AiBangBusStationBean beans = null;
		SAXBuilder sax = new SAXBuilder();
		try {
			StringReader read = new StringReader(pageContext);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 通过输入源构造一个Document
			Document doc = sax.build(source);
			// 取的根元素
			Element root = doc.getRootElement();
			List listChild = root.getChild("lines").getChildren();
			if(listChild != null && listChild.size() != 0) {
				Element elementstat = (Element) listChild.get(0);
				beans = new AiBangBusStationBean();
				beans.setName(elementstat.getChildText("name"));
				beans.setLineInfo(elementstat.getChildText("info"));
				beans.setLineStats(elementstat.getChildText("stats"));
				beans.setLineStat_xys(elementstat.getChildText("stat_xys"));
				beans.setLineXys(elementstat.getChildText("xys"));
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("获取公交线路详细信息错误！");	
		}
		return beans;
	}
	
	

}
