package org.cs.basic.weixin.tools.rijiben;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.cs.basic.weixin.tools.HttpRequestTools;

/**
 * 历史上的今天服务类
 * @author xuxile
 */
public class TodayService {

	private static String TODAY_URL = "http://www.rijiben.com/";

	/**
	 * 查询历史上的今天
	 * 
	 * @return
	 */
	public static List<String> queryToday() {
		List<String> list = null;
		String returnJsonStr = HttpRequestTools.getJsonByHttp(TODAY_URL, "UTF-8");
		list = extractTodayInfo(returnJsonStr);
		return list;
	}

	/**
	 * 从html中抽取出历史上的今天信息
	 * 
	 * @param html
	 * @return
	 */
	private static List<String> extractTodayInfo(String html) {
		List<String> list = null;
		Pattern p = Pattern
				.compile("(.*)(<div class=\"listren\">)(.*?)(</div>)(.*)");
		Matcher m = p.matcher(html);
		if (m.matches()) {
			list = new ArrayList<String>();
			for (String info : m.group(3).split("&nbsp;&nbsp;")) {
				list.add(info.replace("（图）", "").replaceAll("</?[^>]+>", "")
						.trim());
			}
			Collections.reverse(list);
		}
		return list;
	}

	public static void main(String[] args) {
		List<String> list = queryToday();
		// Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
	        System.out.print(list.get(i)+"\n");;
        }
	}
}
