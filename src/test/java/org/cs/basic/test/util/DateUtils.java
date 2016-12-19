/*
 *  DateUtils.java
 *  
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Library General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *  
 *  Author: Winter Lau (javayou@gmail.com)
 *  http://dlog4j.sourceforge.net
 */
package org.cs.basic.test.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

/**
 * 日期相关的工具类
 * @author Winter Lau
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils{
	public static java.text.SimpleDateFormat dd = new java.text.SimpleDateFormat("yyyy-MM-dd");
	public static java.text.SimpleDateFormat dd_min = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static java.text.SimpleDateFormat dd05 = new java.text.SimpleDateFormat("yyyy-MM-05");
	/**
	 * 合并日期和时间
	 * @param date
	 * @param time
	 * @return
	 */
	public static Calendar mergeDateTime(Date date, Time time){
		Calendar cal = Calendar.getInstance();
		if(date!=null)
			cal.setTime(date);
		if(time!=null){
			Calendar temp = Calendar.getInstance();
			temp.setTime(time);
			cal.set(Calendar.HOUR_OF_DAY, temp.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE, temp.get(Calendar.MINUTE));
			cal.set(Calendar.SECOND, temp.get(Calendar.SECOND));
			cal.set(Calendar.MILLISECOND, temp.get(Calendar.MILLISECOND));
		}
		return cal;
	}
	
	/**
	 * 返回两个日期相差的天数
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int diff_in_date(Date d1, Date d2,String type){
		if(type.endsWith("day"))
			return (int)(d1.getTime() - d2.getTime())/86400000;
		else if(type.endsWith("hour"))
			return (int)(d1.getTime() - d2.getTime())/3600000;
		else if(type.endsWith("min"))
			return (int)(d1.getTime() - d2.getTime())/60000;
		else
			return (int)(d1.getTime() - d2.getTime())/86400000;
	}
	/**
	 * 返回两个日期相差的天数
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int diff_in_date(Date d1, Date d2){
		d1=toDate("yyyy-MM-dd",new SimpleDateFormat("yyyy-MM-dd").format(d1));
		d2=toDate("yyyy-MM-dd",new SimpleDateFormat("yyyy-MM-dd").format(d2));
		return (int)((d1.getTime()-d2.getTime())/(1000*60*60*24));
		//return (int)((d2.getTime()-d1.getTime())/(1000*60*60*24));
		//return (int)(d1.getTime() - d2.getTime())/86400000;
	}
	/**
	 * 获取某天开始的那一刻
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static Calendar getDateBegin(int year, int month, int date){
		Calendar begin_time = Calendar.getInstance();
		begin_time.set(Calendar.YEAR, year);
		begin_time.set(Calendar.MONTH, month-1);
		begin_time.set(Calendar.DATE, date);
		begin_time.set(Calendar.HOUR_OF_DAY, 0);
		begin_time.set(Calendar.MINUTE, 0);
		begin_time.set(Calendar.SECOND, 0);
		begin_time.set(Calendar.MILLISECOND, 0);
		return begin_time;
	}
	
	/**
	 * 清除日历的时间字段
	 * @param cal
	 */
	public static void resetTime(Calendar cal){
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
	}
	/**当前日期上一月
	 * @param dateTime
	 * @return
	 */
	public static Date beforeMonth(String dateTime) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try{
			date = simpledate.parse(dateTime);
		} catch(ParseException ex) {
			System.out.println("日期格式不符合要求：" + ex.getMessage());
			return null;
		}
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)-1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);
		return now.getTime();
	}
	/**当前日期上一月
	 * @param dateTime
	 * @return
	 */
	public static Date beforeMonth(Date dateTime) {
		Calendar now = Calendar.getInstance();
		now.setTime(dateTime);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)-1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);
		return now.getTime();
	}
	/**当前日期下个月
	 * @param dateTime
	 * @return
	 */
	public static Date afterMonth(Date dateTime) {
		Calendar now = Calendar.getInstance();
		now.setTime(dateTime);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = 1;
		now.set(year, month, day);
		return now.getTime();
	}
	
	public static String spc_deal(String input_date){
		if (StringUtils.isBlank(input_date)) {
			return "";
		}
		
		int min = getMin(input_date);
		int turn_to_min = turn_to_min(min);
		
		Date bDate = parse("yyyy-MM-dd HH:mm", input_date);
		Date aDate = todyDays_min(bDate,turn_to_min);
		
		return format("yyyy-MM-dd HH:mm", aDate);
	}
	
	/**
     * 得到min
     * @param dateTime
     * @return
     */
	public static int getMin(String dateTime) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int min = now.get(Calendar.MINUTE);
		return min;
	}
	/**
     * 得到hour
     * @param dateTime
     * @return
     */
	public static int getHour(String dateTime) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
    /**
     * 得到day
     * @param dateTime
     * @return
     */
	public static int getDay(Date dateTime) {
		Calendar now = Calendar.getInstance();
		now.setTime(dateTime);
		int day = now.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	/**
     * 得到Month
     * @param dateTime
     * @return
     */
	public static int getMonth(Date dateTime) {
		Calendar now = Calendar.getInstance();
		now.setTime(dateTime);
		int month = now.get(Calendar.MONTH)+1;
		return month;
	}
	/**
     * 得到Year
     * @param dateTime
     * @return
     */
	public static int getYear(Date dateTime) {
		Calendar now = Calendar.getInstance();
		now.setTime(dateTime);
		int year = now.get(Calendar.YEAR);
		return year;
	}
	/**
	 * 得到几月几号  如2月11号
	 * @param dateTime
	 * @return
	 */
	public static String getMD(Date dateTime){
		return getMonth(dateTime)+"月"+getDay(dateTime)+"号";
	}
	/**当前日期上一月第一天
	 * 返回日期型
	 * @param dateTime
	 * @return
	 */
	public static Date beforeMonthFristDay(String dateTime) {
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        Date date = null;
		try{
			date = df.parse(dateTime);
		} catch(ParseException ex) {
			System.out.println("日期格式不符合要求：" + ex.getMessage());
		}
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)-1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);		
		now.set(now.DATE, 1);
        return now.getTime();
	}
	/**当前日期上一月第一天
	 * 返回字符串类型
	 * @param date
	 * @return
	 */
	public static String beforeMonthFristDay(Date date) {
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)-1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);		
		now.set(now.DATE, 1);
        return df.format(now.getTime());
	}	
	/**根据条件返回月份的第一天
	 * @param dateTime
	 * @param num
	 * @return
	 */
	public static String firstMonthDay(String dateTime,int num) {		
		try {
			Date date = dd.parse(dateTime);		
	        Calendar now = Calendar.getInstance();
			now.setTime(date);
			int year = now.get(Calendar.YEAR);
			int month = now.get(Calendar.MONTH)-num;
			int day = now.get(Calendar.DAY_OF_MONTH);
			now.set(year, month, day);		
			now.set(now.DATE, 1);
	        return dd.format(now.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dd.format(new Date());
	}
	/**根据条件返回月份的第一天
	 * @param dateTime
	 * @param num
	 * @return
	 */
	public static Date firstMonthDay(Date dateTime,int num) {		
        Calendar now = Calendar.getInstance();
		now.setTime(dateTime);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)-num;
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);		
		now.set(now.DATE, 1);
        return now.getTime();
	}
	/**当前日期上一月最后一天
	 * 返回日期型
	 * @param dateTime
	 * @return
	 */
	public static Date beforeMonthLastDay(String dateTime) {
		Calendar now = Calendar.getInstance();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try{
			date = df.parse(dateTime);
		} catch(ParseException ex) {
			System.out.println("日期格式不符合要求：" + ex.getMessage());
		}
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)-1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);
        // 当前月＋1，即下个月
		now.add(now.MONTH, 1);
        // 将下个月1号作为日期初始zhii
		now.set(now.DATE, 1);
        // 下个月1号减去一天，即得到当前月最后一天
		now.add(now.DATE, -1);
        return now.getTime();
	}
	/**当前日期上一月第后一天
	 * 返回字符串类型
	 * @param date
	 * @return
	 */
	public static String beforeMonthLastDay(Date date) {
		Calendar now = Calendar.getInstance();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");		
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)-1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);
        // 当前月＋1，即下个月
		now.add(now.MONTH, 1);
        // 将下个月1号作为日期初始zhii
		now.set(now.DATE, 1);
        // 下个月1号减去一天，即得到当前月最后一天
		now.add(now.DATE, -1);
        return df.format(now.getTime());
	}
	/**当前日期月份的最后一天
	 * @param date
	 * @param m
	 * @return
	 */
	public static Date monthLastDay(Date date,int m) {
		Calendar now = Calendar.getInstance();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");		
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+m;
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);
        // 当前月＋1，即下个月
		now.add(now.MONTH, 1);
        // 将下个月1号作为日期初始zhii
		now.set(now.DATE, 1);
        // 下个月1号减去一天，即得到当前月最后一天
		now.add(now.DATE, -1);
        return now.getTime();
	}
	/**日期转化整型
	 * @param date
	 * @return
	 */
	public static int intOfDate(Date date,String famat){
		SimpleDateFormat d=new SimpleDateFormat(famat);
		return Integer.valueOf(d.format(date));
	}
	/**日期转化string
	 * @param date
	 * @return
	 */
	public static String stringOfDate(Date date){
		if (date==null) {
			return null;
		}
		return dd.format(date);
	}
	/**当前日期增加天数或者是减少天数
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date todyDays(Date date,int n){
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH)+n;
		now.set(year, month, day);
		return now.getTime();
	}
	/**当前日期增加天数或者是减少天数
	 * @param date
	 * @param n
	 * @return
	 */
	public static String todyDays(String date,int n){		
		return dd.format(todyDays(date(date),n));
	}
	
	/**
	 * 去掉秒，分清0，再增加n分钟
	 */
	public static Date todyDays_min(Date date,int n){
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		now.set(year, month, day, hour, 0);
		now.add(Calendar.MINUTE, n);
		return now.getTime();
	}
//	/**
//	 * 去掉秒，分清0，再增加n分钟
//	 */
//	public static String todyDays_min(String date,int n){		
//		return dd_min.format(todyDays(date(date),n));
//	}
	
	/**当前日期时间加n小时间的日期时间
	 */
	public static Date hourDays(Date date,int n){
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		/*int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);*/
		now.set(Calendar.HOUR, n);
		return now.getTime();
	}
	/**判断date0==date1&&date2==date3
	 * @param date0
	 * @param date1
	 * @param date2
	 * @param date3
	 * @return
	 */
	public static boolean equalDate(Date date0, Date date1,Date date2,Date date3) {
		date0=DateUtils.date(dd.format(date0));
		date1=DateUtils.date(dd.format(date1));
		date2=DateUtils.date(dd.format(date2));
		date3=DateUtils.date(dd.format(date3));
		if(date0.getTime()==date1.getTime()&&date2.getTime()==date3.getTime()){
			return true;
		}
		return false;
	} 
	/**判断date0是否在date1与date2之间
	 * @param date0
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean equalDate(Date date0, Date date1,Date date2) {
		date0=DateUtils.date(dd.format(date0));
		date1=DateUtils.date(dd.format(date1));
		date2=DateUtils.date(dd.format(date2));
		if(date0.getTime()>=date1.getTime()&&date0.getTime()<=date2.getTime()){
			return true;
		}
		return false;
	}
	/**判断date0<=date1(去掉时分秒)
	 * @param date0
	 * @param date1
	 * @return
	 */
	public static boolean equalDate(Date date0, Date date1) {
		date0=DateUtils.date(dd.format(date0));
		date1=DateUtils.date(dd.format(date1));
		if(date0.getTime()<=date1.getTime()){
			return true;
		}
		return false;
	}
	
	/**判断date0<=date1
	 * @param date0
	 * @param date1
	 * @return
	 */
	public static boolean equalDateHms(Date date0, Date date1) {
		if(date0.getTime()<=date1.getTime()){
			return true;
		}
		return false;
	}
	
	/**判断date0>date1()
	 * @param date0
	 * @param date1
	 * @return
	 */
	public static boolean equalDateHms1(Date date0, Date date1) {
		if(date0.getTime()>date1.getTime()){
			return true;
		}
		return false;
	}
	
	/**判断date0==date1
	 * @param date0
	 * @param date1
	 * @return
	 */
	public static boolean equalDateHm(Date date0, Date date1) {
		if (date0==null||date1==null) {
			return false;
		}
		if(date0.getTime()==date1.getTime()){
			return true;
		}
		return false;
	}
	
    /**当前日期和某date比较（是否大于此月5号）
	 * @param date
	 * @return
	 */
	public static boolean equalDate05(Date date0) {
		date0=DateUtils.date(dd05.format(date0));
		Date date= new Date(); 
		Date date1=DateUtils.date(dd.format(date));
		if(date0.getTime()<date1.getTime()){
			return true;
		}
		return false;
	}
	/**判断date0=date1(去掉时分秒)
	 * @param date0
	 * @param date1
	 * @return
	 */
	public static boolean equalDate1(Date date0, Date date1) {
		date0=DateUtils.date(dd.format(date0));
		date1=DateUtils.date(dd.format(date1));
		if(date0.getTime()==date1.getTime()){
			return true;
		}
		return false;
	}
	/**当前月最后一天
	 * @param dateTime
	 * @return
	 */
	public static Date monthLastDay(String dateTime) {
		Calendar now = Calendar.getInstance();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try{
			date = df.parse(dateTime);
		} catch(ParseException ex) {
			System.out.println("日期格式不符合要求：" + ex.getMessage());
		}
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);
        // 当前月＋1，即下个月
		now.add(now.MONTH, 1);
        // 将下个月1号作为日期初始zhii
		now.set(now.DATE, 1);
        // 下个月1号减去一天，即得到当前月最后一天
		now.add(now.DATE, -1);
        return now.getTime();
	}
	/**当前月最后一天
	 * @param date
	 * @return
	 */
	public static Date monthLastDay(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);
        // 当前月＋1，即下个月
		now.add(now.MONTH, 1);
        // 将下个月1号作为日期初始zhii
		now.set(now.DATE, 1);
        // 下个月1号减去一天，即得到当前月最后一天
		now.add(now.DATE, -1);
        return now.getTime();
	}
	/**将日期中的时,分,秒去掉
	 * @param d
	 * @return
	 */
	public static Date date(Date d){
		String str_d=dd.format(d);
		try {
			return dd.parse(str_d);
		} catch (ParseException e) {
			e.printStackTrace();
			return d;
		}
	}
	/**将日期中的时,分,秒去掉
	 * @param d
	 * @return
	 */
	public static Date date(String d){
		Calendar now = Calendar.getInstance();
		Date date = null;
		try {
			date=dd.parse(d);
		} catch (ParseException e) {
			System.out.println("日期格式不符合要求：" + e.getMessage());
		}
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);
		return now.getTime();
	}
	/**日期相差天数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getCompareDate(String startDate,String endDate){ 
		try {
			Date date1= dd.parse(startDate);
			Date date2=dd.parse(endDate); 
			long l = date2.getTime() - date1.getTime(); 
			long d = l/(24*60*60*1000); 
			return (int)d; 
		} catch (ParseException e) {			
			e.printStackTrace();
			return 0;
		}    
	    
	} 
	/**日期相差天数
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getCompareDate(Date startDate,Date endDate){
		if(startDate==null||endDate==null){
			return 0;
		}
		long l = endDate.getTime() - startDate.getTime(); 
		long d = l/(24*60*60*1000); 
		return (int)d;
	}
	/**返回在包括两个日期之间的所有日期
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List listBetweenDate(String startDate,String endDate){
		int i=0,len=getCompareDate(startDate,endDate)+1;
		List<String> list=new ArrayList<String>();		
		for(i=0;i<len;i++){			
			Date date=date(startDate);
			date=todyDays(date(startDate),i);
			list.add(dd.format(date));			
		}
		return list;
	}
	/**返加当前日期时间相差的秒数
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long secondOfDate(Date d1,Date d2){
		SimpleDateFormat fDate = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		long l_d1=Long.valueOf(fDate.format(d1));
		long l_d2=Long.valueOf(fDate.format(d2));
//		System.out.println("l_d1="+l_d1+"    l_d2="+l_d2);
		return l_d1-l_d2;
	}
	/**得到当前日期的周数
	 * @param date
	 * @return
	 */
	public static int weekOfDay(Date date) {   
        Calendar c =  Calendar.getInstance();   
        c.setFirstDayOfWeek(Calendar.MONDAY);   //星期第1天是星期一   
        c.setMinimalDaysInFirstWeek(4);  //年和月算周，要4天及以上才算是1周   
           
        c.setTime (date);
        int weeknum = c.get(Calendar.WEEK_OF_YEAR);   
        int vyear = c.get(Calendar.YEAR);   
        int vmonth = c.get(Calendar.MONTH)+1;   
           
        //当1月分首周不满一周时算为去年的周数，故要年号减1   
        if(vmonth == 1 && weeknum>6){   
            vyear--;   
        }  
           
        //当最后一周不满一周算为下一年的周数，故要年号加1   
        if(vmonth == 12 && weeknum==1){   
            vyear++;   
        }            
        /*DateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
        System.out.println(format.format(date)+",weeknum:"+weeknum+",year:"+vyear);*/              
        return weeknum;   
    }
	/**给定一个日期判断是星期几
	 * @param d
	 * @return
	 * @throws ParseException
	 */
	public static int getWeek(Date d){		
		Calendar cd = Calendar.getInstance();
		cd.setTime(d);
		 int mydate = cd.get(Calendar.DAY_OF_WEEK);
		 String showDate = "星期六";
		 int date_num=0;
		 switch(mydate){
		   case 1:
			   showDate = "星期日";
			   date_num=7;
			   break;
		  case 2:
			   showDate = "星期一";
			   date_num=1;
			   break;
		  case 3:
			   showDate = "星期二";
			   date_num=2;
			   break;
		  case 4:
			   showDate = "星期三";
			   date_num=3;
			   break;
		  case 5:
			   showDate = "星期四";
			   date_num=4;
			   break;
		  case 6:
			   showDate = "星期五";
			   date_num=5;
			   break;
		  default:
			   showDate = "星期六";
		 	   date_num=6;
			   break;
		 }
		 return date_num;
	}
	/**给定一个日期判断是星期几
	 * @param d
	 * @return
	 * @throws ParseException
	 */
	public static String getWeekName(Date d){		
		Calendar cd = Calendar.getInstance();
		cd.setTime(d);
		 int mydate = cd.get(Calendar.DAY_OF_WEEK);
		 String showDate = "星期六";
		 int date_num=0;
		 switch(mydate){
		   case 1:
			   showDate = "星期日";
			   date_num=7;
			   break;
		  case 2:
			   showDate = "星期一";
			   date_num=1;
			   break;
		  case 3:
			   showDate = "星期二";
			   date_num=2;
			   break;
		  case 4:
			   showDate = "星期三";
			   date_num=3;
			   break;
		  case 5:
			   showDate = "星期四";
			   date_num=4;
			   break;
		  case 6:
			   showDate = "星期五";
			   date_num=5;
			   break;
		  default:
			   showDate = "星期六";
		 	   date_num=6;
			   break;
		 }
		 return showDate;
	}
	/**给定一个日期判断是周几
	 * @param d
	 * @return
	 * @throws ParseException
	 */
	public static String getWeekNameOther(Date d){		
		Calendar cd = Calendar.getInstance();
		cd.setTime(d);
		 int mydate = cd.get(Calendar.DAY_OF_WEEK);
		 String showDate = "周六";
		 int date_num=0;
		 switch(mydate){
		   case 1:
			   showDate = "周日";
			   date_num=7;
			   break;
		  case 2:
			   showDate = "周一";
			   date_num=1;
			   break;
		  case 3:
			   showDate = "周二";
			   date_num=2;
			   break;
		  case 4:
			   showDate = "周三";
			   date_num=3;
			   break;
		  case 5:
			   showDate = "周四";
			   date_num=4;
			   break;
		  case 6:
			   showDate = "周五";
			   date_num=5;
			   break;
		  default:
			   showDate = "周六";
		 	   date_num=6;
			   break;
		 }
		 return showDate;
	}
	/**
	 * 通过星期名字得到NUM 如星期一得到：1 星期日得到：7
	 * @param weekName
	 * @return
	 */
	public static int getNumByWeekName(String weekName){
		int date_num=0;
		if(weekName.equals("星期日")||weekName.equals("周日"))
			date_num=7;
		else if(weekName.equals("星期一")||weekName.equals("周一"))
			date_num=1;
		else if(weekName.equals("星期二")||weekName.equals("周二"))
			date_num=2;
		else if(weekName.equals("星期三")||weekName.equals("周三"))
			date_num=3;
		else if(weekName.equals("星期四")||weekName.equals("周四"))
			date_num=4;
		else if(weekName.equals("星期五")||weekName.equals("周五"))
			date_num=5;
		else if(weekName.equals("星期六")||weekName.equals("周六"))
			date_num=6;
			
		return date_num;
		
	}
	/**返回开始日期到结束日期的日期列表
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<String> listDays(int orderBy,String startDate,String endDate){
		List<String> list=new ArrayList<String>();
		if(StringUtils.isNotEmpty(startDate)&&StringUtils.isNotEmpty(endDate)){
			Date dateStart=date(startDate);
			Date dateEnd=date(endDate);
			if(orderBy==1){
				dateStart=date(endDate);
				dateEnd=date(startDate);
			}
			Date d=dateStart;
			
			list.add(dd.format(dateStart));			
			while(true){
				d=todyDays(d,1);
				if(d.getTime()>dateEnd.getTime()){
					break;
				}
				list.add(dd.format(d));
			}
		}
		return list;
	}
	/**
     * 两个时间相差距离多少天多少小时多少分多少秒
     * @param start 时间参数 1 格式：1990-01-01 12:00:00
     * @param end 时间参数 2 格式：2009-01-01 12:00:00
     * @return long[] 返回值为：{天, 时, 分, 秒}
     */
    public static long[] differTimes(Date start, Date end) {     
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        
        if(start!=null&&end!=null){
	        long time1 = start.getTime();
	        long time2 = end.getTime();
	        long diff ;
	        if(time1<time2) {
	            diff = time2 - time1;
	        } else {
	            diff = time1 - time2;
	        }
	        day = diff / (24 * 60 * 60 * 1000);
	        hour = (diff / (60 * 60 * 1000) - day * 24);
	        min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
	        sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
        }
        long[] times = {day, hour, min, sec};
        return times;
    }
	/**字符串转换成日期
	 * @param format
	 * @param d
	 * @return
	 */
	public static Date parse(String format,String d){
		try {
			return  new java.text.SimpleDateFormat(format).parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**格式化日期
	 * @param format
	 * @param d
	 * @return
	 */
	public static String format(String format,Date d){
		if(d==null){
			return "";
		}
		return  new java.text.SimpleDateFormat(format).format(d);
	}
	
	/**
	 * 判断date，与start,end时间区间的关系
	 * -1，date在start之前
	 * 0，date在start，end之间
	 * 1，date在end之后
	 * @param date
	 * @param start
	 * @param end
	 * @return
	 */
	public static int in_time_zone(Date date,Date start,Date end){
		if(date==null||start==null||end==null)
			return 0;
		if(start.after(end)){//如start为09:00:00,end为02:00:00则end视为第二天凌晨
			if(start.after(date))
				return -1;
			else
				return 0;
		}else{
			if(start.after(date))
				return -1;
			else if(end.after(date))
				return 0;
		}
		return 1;
	}
	 /**分钟增加
     * @param date
     * @param num
     * @return
     */
    public static Date minuteDate(Date date,int num) {	
        Calendar now = Calendar.getInstance();
		now.setTime(date);
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		now.set(year, month, day);		
		now.add(Calendar.MINUTE, num);
        return now.getTime();
	}
    /**两个时差
     * @param start
     * @param end
     * @return
     */
    public static long timeDiffer(Date start,Date end){
		return end.getTime()-start.getTime();		
	}
    /**判断date0是否在date1与date2之间
	 * @param date0
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean betweenDate(Date date0, Date date1,Date date2,String format) {
		date0=DateUtils.parse(format,format(format,date0));
		date1=DateUtils.parse(format,format(format,date1));
		date2=DateUtils.parse(format,format(format,date2));
		if(date0.getTime()>=date1.getTime()&&date0.getTime()<=date2.getTime()){
			return true;
		}
		return false;
	}
	/**比较时间大小
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean isDateDiff_2(String pattern,String time2,String time1){
		Date d1=parse(pattern,time1);
		Date d2=parse(pattern,time2);
		long diff=d2.getTime()-d1.getTime();
		if(diff>0){
			return true;
		}
		return false;
	}
	/**比较时间大小
	 * @param time1
	 * @param time2
	 * @return time1>time2 true
	 */
	public static boolean isDateDiff(Date d1,Date d2){
		long diff=d1.getTime()-d2.getTime();
		//Log.i(TAG, "diff="+diff);
		if(diff>0){
			return true;
		}
		return false;
	}
	//----------------------判断当前时间是否在StartDate,EndDate 之间-------------------------------
	
	/**字符转换日期
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static Date toDate(String pattern,String date){
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//年月日
	public static boolean betweenDateByTime(String StartDate,String EndDate){
		Date startDate = toDate("yyyy-MM-dd HH:mm:ss",StartDate);
		Date endDate = toDate("yyyy-MM-dd HH:mm:ss",EndDate);
		Date newDate = new Date();
		if(newDate.getTime()>=startDate.getTime()&&newDate.getTime()<=endDate.getTime()){
			return true;
		}
		return false;
	}
	
	//----------------------判断当前时间是否在StartDate,EndDate 之间-------------------------------
	
	/**
	 * 按15分钟规整，7下8上
	 */
	public static int formatMinBy15(int min){
		int return_min = min;
		if(min>0){
			int remainder = min%15;
			if(remainder>=8){
				return_min = min - remainder +15;
			}else if(remainder<=7){
				return_min = min - remainder;
			}
		}
		return return_min;
	}
	
	//根据分钟数，增加的分钟数
	public static int turn_to_min(int min){
		if (min>=0&&min<=14) {
			return 0;
		} else if (min>=15&&min<=44) {
			return 30;
		}else if (min>=45&&min<=59) {
			return 60;
		}
		return 0;
	}
	
	/**
	 * 
	 * @param early_week 提早几周
	 * @param week_day 星期几
	 * @return
	 */
	public static String getDateByWeekDay(int early_week,int week_day){
		Calendar time = Calendar.getInstance();
		if(week_day>-1 && week_day<7)
			time.set(Calendar.DAY_OF_WEEK, week_day);
		if(early_week>-1 && early_week<54)
			time.set(Calendar.WEEK_OF_YEAR,time.get(Calendar.WEEK_OF_YEAR)-early_week);
		SimpleDateFormat fDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return fDate.format(time.getTime());
	}
	/**
	 * 处理查询时间
	 */
	public static JSONObject formatQuerryDate(String startTime,String endTime){
		JSONObject date_info = new JSONObject();
		String start_time = "";//查询开始时间
		String end_time = "";//查询结束时间
		String start_time_his = "";//历史查询开始时间
		String end_time_his = "";//历史查询结束时间
		if(StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(endTime)){
			Date today = new Date();//最近一个月的结束时间
			Date lastDay = DateUtils.todyDays(today, -60);//最近二个月的开始时间
			Date inputStartTime = DateUtils.parse("yyyy-MM-dd", startTime);//查询的开始时间
			Date inputEndTime = DateUtils.parse("yyyy-MM-dd", endTime);//查询的结束时间
			
			//查询开始时间大于最近二个月的开始时间
			if(DateUtils.equalDate(lastDay, inputStartTime)){
				start_time = DateUtils.format("yyyy-MM-dd", inputStartTime);
				end_time = DateUtils.format("yyyy-MM-dd", inputEndTime);
			}
			//查询结束时间小于最近二个月的开始时间
			else if(DateUtils.equalDate(inputEndTime, lastDay)){
				start_time_his = DateUtils.format("yyyy-MM-dd", inputStartTime);
				end_time_his = DateUtils.format("yyyy-MM-dd", inputEndTime);
			}
			//
			else{
				start_time = DateUtils.format("yyyy-MM-dd", lastDay);
				end_time = DateUtils.format("yyyy-MM-dd", inputEndTime);
				start_time_his = DateUtils.format("yyyy-MM-dd", inputStartTime);
				end_time_his = DateUtils.format("yyyy-MM-dd", DateUtils.todyDays(lastDay, -1));
			}
		}
		date_info.put("start_time", start_time);
		date_info.put("end_time", end_time);
		date_info.put("start_time_his", start_time_his);
		date_info.put("end_time_his", end_time_his);
		return date_info;
	}
}
