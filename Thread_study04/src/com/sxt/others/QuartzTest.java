
package com.sxt.others;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
//quartz学习入门
public class QuartzTest {

  public void run() throws Exception {

    //1，创建Scheduler工厂
    SchedulerFactory sf = new StdSchedulerFactory();
    //从工厂中获得调度器
    Scheduler sched = sf.getScheduler();
    
    //3，创建JobDetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    
    //时间
    Date runTime = evenSecondDateAfterNow();
    
    // 4，触发器
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    //5注册任务和触发条件
    sched.scheduleJob(job, trigger);


    //6，启动
    sched.start();

    try {
    	//5秒停止
      Thread.sleep(5L * 1000L);
    } catch (Exception e) {
    }
    sched.shutdown(true);
  }

  public static void main(String[] args) throws Exception {

    QuartzTest example = new QuartzTest();
    example.run();

  }

}
