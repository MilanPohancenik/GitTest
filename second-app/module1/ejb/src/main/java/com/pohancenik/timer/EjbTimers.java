package com.pohancenik.timer;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;
import javax.ejb.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Timers definition EJB3 Bean. This class defines all automatic timers and shows a corresponding message in the log.
 * All the timers are persistent by default, so after Jboss crash or shutdown, they will recover.
 * <br/>
 * <br/>Sometimes there is a <b>ERROR Message saying something like "Failed to reinstate timer..."</b> - in this case,
 * go to the WildFly home / standalone / data and delete the folder "timer-service-data" containing all the
 * persistent timers. If you change a timer, then you sometimes need to do this, because the persistence is
 * based on plain serialization of the timers and not compatible between versions. The "data" folder also 
 * contains some other data that should be deleted from time to time.
 * 
 * @author pohancenik
 *
 */
@Stateless
public class EjbTimers {

	private static final Logger log = LoggerFactory.getLogger( EjbTimers.class );
	
	@Schedule( second = "*/10", minute = "*", hour = "*", info = "Timer1" )
	public void timer1(Timer timer) {
		log.info( "timer1 activated!" );
	}
	
	@Schedules({
		@Schedule( minute = "*", hour = "*" ),
		@Schedule( second = "2", minute = "5", hour = "*" )})
	public void timer2(Timer timer) {
		log.info("timer2 activated! Next timeout in - [" + timer.getNextTimeout()+ "]");
	}
}
