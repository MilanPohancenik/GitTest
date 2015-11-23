package com.pohancenik.timer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class EjbManualTimerConfiguration2Bean {
	
	private static final Logger log = LoggerFactory.getLogger( EjbManualTimerConfiguration2Bean.class );
	
	@Resource
	private TimerService timerService; 
	
	private Timer timer;
	
	@PostConstruct
	public void postConstruct() {
		//
		ScheduleExpression expression = new ScheduleExpression();
		expression.hour("*");
		expression.minute("*/2");
		expression.second("*/10");
		//
		TimerConfig config = new TimerConfig();
		config.setInfo("Manual-Timer-2");
		//
		timer = timerService.createCalendarTimer(expression, config);
	}
	
	@Timeout
	public void timeout(Timer timer) {
		log.info(String.format("Timer [%1$s] expired....", timer.getInfo()));
	}
	
	@PreDestroy
	public void preDestroy() {
		timer.cancel();
	}
	
}
