package cn.jc.ee;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class MyScheduler {

	public static void main(String[] args) {
		try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            
            JobDetail job = newJob(MyMain.class).withIdentity("MyMain","group1")
            		.build();
            
            Trigger trigger = newTrigger().withIdentity("myTrigger", "group1")
            .startNow().withSchedule(simpleSchedule().withIntervalInSeconds(60).repeatForever()
            		)
            		.forJob(job)
            		.build();
           
            scheduler.scheduleJob(job,trigger);
            //gracefully shutdown until all job finished
           // scheduler.shutdown(true);

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
	}
}
