package listener;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.soapui.util.DateUtil;

public class TestDateUtil {

	public static void main(String[] args) throws ParseException {
		System.out.println(DateUtil.getNowTime());
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date1 = "2016-03-14 17:54:55";
		String date2 = "2016-03-14 18:23:22";
		Date date11 = sim.parse(date1);
		Date date22 = sim.parse(date2);
		System.out.println(date11);
		System.out.println(date22);
		long time = (date22.getTime()-date11.getTime())/1000;
		 int MM = (int)time/60;   //共计分钟数
		  int hh=(int)time/3600;  //共计小时数
		  int dd=(int)hh/24;   //共计天数
		  int ss=(int) (time-(MM*60));
		  
		
		  System.out.println(dd+"天"+hh+"小时"+MM+"分钟"+ss+"秒");
		
		
		
		
		
	}

}
