/**
 * 
 */
package com.pohancenik.timer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author pohancenik
 *
 */
@Singleton
@Startup
public class EjbManualTimerConfiguration1Bean {

	private static final Logger log = LoggerFactory.getLogger( EjbManualTimerConfiguration1Bean.class );
	
	@Resource
	private TimerService timerService; 
	
	private Timer timer;
	
	@PostConstruct
	public void postConstruct() {
		timer = timerService.createTimer(5000, "Manual-timer-1");
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
