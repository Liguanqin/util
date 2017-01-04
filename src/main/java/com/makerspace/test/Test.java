package com.makerspace.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.DateUtil;


/**
 * 
 * 
 * @author 李关钦
 * @version 2017年1月4日
 */
public class Test {

	private static final Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		logger.info("获取当前时间 ： [{}]", DateUtil.getCurrentTime(null));
		logger.info("获取当前时间 ： [{}]", DateUtil.getCurrentTime(DateUtil.ymd));
		logger.info("获取2天后的时间 ： [{}]", DateUtil.getAfterDaysDate(2, null));
		logger.info("获取2天后的时间 ： [{}]", DateUtil.getAfterDaysDate(2, DateUtil.ymd));
		logger.info("获取2天前的时间 ： [{}]", DateUtil.getBeforeDaysDate(2,null));
		logger.info("获取2天前的时间 ： [{}]", DateUtil.getBeforeDaysDate(2, DateUtil.ymd));
		logger.info("+2天的时间 ： [{}]", DateUtil.addDays(2, DateUtil.ymd));
		logger.info("+2天的时间 ： [{}]", DateUtil.addDays(2, null));
		logger.info("-2天的时间 ： [{}]", DateUtil.addDays(-2, DateUtil.ymd));
		logger.info("-2天的时间 ： [{}]", DateUtil.addDays(-0, null));
		logger.info("+2月的时间 ： [{}]", DateUtil.addMonths(2, DateUtil.ymd));
		logger.info("+2月的时间 ： [{}]", DateUtil.addMonths(2, null));
		logger.info("-2月的时间 ： [{}]", DateUtil.addMonths(-2, DateUtil.ymd));
		logger.info("-2月的时间 ： [{}]", DateUtil.addMonths(-0, null));
		logger.info("+2天的时间 ： [{}]", DateUtil.addDays("2017-02-28 00:00:00", 2, DateUtil.ymd));
	}
}

