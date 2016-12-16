package org.cs.basic.weixin.tools.baidu.map;

import java.io.StringReader;

import org.cs.basic.weixin.tools.HttpRequestTools;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;


/**
 * 百度地图地址信息查询
 * @author xuxile
 *
 */
public class PositionTools {

	// http://developer.baidu.com/map/apply-key.htm
	// http://developer.baidu.com/map/
	private static final String API_KEY = "035fbf869507ce6c6f4946f9aa0d0f6c";

	public static void main(String[] args) throws Exception {
		BaiDuMapBean positionBean = getAddressByPosition("32.037061", "118.785135");
		System.out.println(positionBean.getFormatted_address());
	}

	/**
	 * @param lat 经度
	 * @param lng 维度
	 * */
	public static BaiDuMapBean getAddressByPosition(String lat, String lng) {
		BaiDuMapBean positionBean = new BaiDuMapBean();
		String url = "http://api.map.baidu.com/geocoder?location=" + lat + "," + lng + "&output=xml&key=" + API_KEY;
		String pageContext = HttpRequestTools.getPageContent(url, "GET", 1023000, "UTF-8");
		if (pageContext != null && !"".equals(pageContext)) {
			SAXBuilder sax = new SAXBuilder();
			try {
				StringReader read = new StringReader(pageContext);
				// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
				InputSource source = new InputSource(read);
				// 通过输入源构造一个Document
				Document doc = sax.build(source);
				// 取的根元素
				Element root = doc.getRootElement();
				Element elementRes = root.getChild("result");
				Element elementLocation = elementRes.getChild("location");
				Element elementAddressComponent = elementRes.getChild("addressComponent");

				positionBean.setLat(elementLocation.getChild("lat").getText());
				positionBean.setLng(elementLocation.getChild("lng").getText());
				positionBean.setFormatted_address(elementRes.getChild("formatted_address").getText());
				positionBean.setBusiness(elementRes.getChild("business").getText());
				positionBean.setStreetNumber(elementAddressComponent.getChild("streetNumber").getText());
				positionBean.setStreet(elementAddressComponent.getChild("street").getText());
				positionBean.setDistrict(elementAddressComponent.getChild("district").getText());
				positionBean.setCity(elementAddressComponent.getChild("city").getText());
				positionBean.setProvince(elementAddressComponent.getChild("province").getText());
				positionBean.setCityCode(elementRes.getChild("cityCode").getText());
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("百度地图解析坐标获取地址失败！");				
			}
		}
		return positionBean;
	}
}
