package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * 日期工具类
 * 
 * @author 李关钦
 * @version 2016年12月10日
 */
public class DateUtil {

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String ymdhms = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static SimpleDateFormat ymdhmsSDF = new SimpleDateFormat(ymdhms);

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String ymdhm = "yyyy-MM-dd HH:mm";
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static SimpleDateFormat ymdhmSDF = new SimpleDateFormat(ymdhm);

	/**
	 * yyyy-MM-dd
	 */
	public static final String ymd = "yyyy-MM-dd";
	/**
	 * yyyy-MM-dd
	 */
	public static SimpleDateFormat ymdSDF = new SimpleDateFormat(ymd);

	/**
	 * yyyyMMddHHmmss
	 */
	public static final String ymdhms_not = "yyyyMMddHHmmss";
	/**
	 * yyyyMMddHHmmss
	 */
	public static SimpleDateFormat ymdhms_not_SDF = new SimpleDateFormat(ymdhms_not);

	/**
	 * yyyyMMdd
	 */
	public static final String ymd_not = "yyyyMMdd";
	/**
	 * yyyyMMdd
	 */
	public static SimpleDateFormat ymd_not_SDF = new SimpleDateFormat(ymd_not);

	/**
	 * yyyy
	 */
	public static final String year = "yyyy";
	/**
	 * yyyy
	 */
	public static SimpleDateFormat yearSDF = new SimpleDateFormat(year);

	/**
	 * MM
	 */
	public static final String month = "MM";
	/**
	 * MM
	 */
	public static SimpleDateFormat monthSDF = new SimpleDateFormat(month);

	/**
	 * dd
	 */
	public static final String day = "dd";
	/**
	 * dd
	 */
	public static SimpleDateFormat daySDF = new SimpleDateFormat(day);

	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * 根据要求的时间格式（空值则返回yyyy-MM-dd HH:mm:ss格式）获取当前时间
	 * 
	 * @param dateFormat
	 * @return String
	 */
	public static String getCurrentTime(String dateFormat) {
		String date = "";
		try {
			if (null != dateFormat && !"".equals(dateFormat)) {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
				date = sdf.format(new Date());
			} else {
				date = ymdhmsSDF.format(new Date());
			}
		} catch (Exception e) {
			logger.error("get current time by dateFormat error : ", e);
		}
		return date;
	}


	/**
	 * 根据要求的时间格式（空值则返回yyyy-MM-dd HH:mm:ss格式）获取N天后的日期
	 * 
	 * @param days
	 *            >=1
	 * @param dateFormate
	 * @return
	 */
	public static String getAfterDaysDate(int days, String dateFormate) {
		Assert.notNull(days, "days not be null");
		String date = "";
		try {
			if (days >= 1) {
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, days);
				if (null != dateFormate && !"".equals(dateFormate)) {
					SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
					date = sdf.format(calendar.getTime());
				} else {
					date = ymdhmsSDF.format(calendar.getTime());
				}
			}
		} catch (Exception e) {
			logger.error("get after days date error : ", e);
		}
		return date;
	}

	/**
	 * 根据要求的时间格式（空值则返回yyyy-MM-dd HH:mm:ss格式）获取N天前的日期
	 * 
	 * @param days
	 *            >=1
	 * @param dateFormate
	 * @return
	 */
	public static String getBeforeDaysDate(int days, String dateFormate) {
		Assert.notNull(days, "days not be null");
		String date = "";
		try {
			if (days >= 1) {
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, -days);
				if (null != dateFormate && !"".equals(dateFormate)) {
					SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
					date = sdf.format(calendar.getTime());
				} else {
					date = ymdhmsSDF.format(calendar.getTime());
				}
			}
		} catch (Exception e) {
			logger.error("get before days date error : ", e);
		}
		return date;
	}

	/**
	 * N天前或者N天后的日期
	 * 
	 * @param days
	 *            正数：N天前，负数：N天后
	 * @param dateFormate
	 *            空值则返回yyyy-MM-dd HH:mm:ss格式
	 * @return
	 */
	public static String addDays(int days, String dateFormate) {
		String date = "";
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, days);
			if (null != dateFormate && !"".equals(dateFormate)) {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
				date = sdf.format(calendar.getTime());
			} else {
				date = ymdhmsSDF.format(calendar.getTime());
			}
		} catch (Exception e) {
			logger.error("add days error : ", e);
		}
		return date;
	}

	/**
	 * N月前或者N月后的日期
	 * 
	 * @param months
	 *            正数：N月前，负数：N月后
	 * @param dateFormate
	 *            空值则返回yyyy-MM-dd HH:mm:ss格式
	 * @return
	 */
	public static String addMonths(int months, String dateFormate) {
		String date = "";
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, months);
			if (null != dateFormate && !"".equals(dateFormate)) {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
				date = sdf.format(calendar.getTime());
			} else {
				date = ymdhmsSDF.format(calendar.getTime());
			}
		} catch (Exception e) {
			logger.error("add months error : ", e);
		}
		return date;
	}

	/**
	 * 获取日期date的N天前或者N天后的日期
	 * 
	 * @param date
	 *            格式：yyyy-MM-dd HH:mm:ss ，空值则为当前时间
	 * @param days
	 *            正数：N月前，负数：N月后
	 * @param dateFormate
	 *            空值则返回yyyy-MM-dd HH:mm:ss格式
	 * @return
	 */
	public static String addDays(String date, int days, String dateFormate) {
		Assert.notNull(days, "days not be null");
		String date2 = "";
		try {
			Calendar calendar = Calendar.getInstance();
			if (null != date && !"".equals(date)) {
				calendar.setTime(ymdhmsSDF.parse(date));
			}
			calendar.add(Calendar.DATE, days);
			if (null != dateFormate && !"".equals(dateFormate)) {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
				date2 = sdf.format(calendar.getTime());
			} else {
				date2 = ymdhmsSDF.format(calendar.getTime());
			}
		} catch (Exception e) {
			logger.error("add months error : ", e);
		}
		return date2;
	}



}
