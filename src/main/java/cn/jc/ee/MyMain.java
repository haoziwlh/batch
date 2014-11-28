package cn.jc.ee;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动
 * @author jince
 *
 */
public class MyMain implements org.quartz.Job {

	public  void start() {
		ClassPathXmlApplicationContext ctx =    new ClassPathXmlApplicationContext("launch-context.xml");  
		JobLauncher launcher = (JobLauncher)ctx.getBean("jobLauncher");
       try {
    	   JobParameter jop = new JobParameter(1416189000L);
	   		Map<String,JobParameter> map= new HashMap<String, JobParameter>();
	   		map.put("id", jop);//reader 的参数
	   		map.put("month", new JobParameter(new Date()));//job的标志
            launcher.run((Job) ctx.getBean("myjob"), new JobParameters(map));  
       } catch (Exception e) {  
    	   e.printStackTrace(); 
    	   ctx.close();
       }  
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		start();
	}
}
