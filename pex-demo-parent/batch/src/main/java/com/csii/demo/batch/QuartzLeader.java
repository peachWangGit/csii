package com.csii.demo.batch;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.util.StopWatch;

import java.util.Date;

/**
 * Created by darkstar on 2017/11/29.
 */
public class QuartzLeader  {

    private static final Logger LOG = LoggerFactory.getLogger(QuartzLeader.class);

    @Setter
    @Getter
    private JobLauncher jobLauncher;
    @Setter
    @Getter
    private Job ledgerJob;
    @Setter
    @Getter
    JobParametersBuilder jobParameterBulider;

    private static long counter = 0L;

    public void execute() throws Exception {
        LOG.debug("start...");
        StopWatch sw = new StopWatch();
        sw.start();
        /*
         * Spring Batch Job同一个job instance，成功执行后是不允许重新执行的【失败后是否允许重跑，
         * 可通过配置Job的restartable参数来控制，默认是true】，如果需要重新执行，可以变通处理，
         * 添加一个JobParameters构建类,以当前时间作为参数，保证其他参数相同的情况下却是不同的job instance
         */
        jobParameterBulider.addDate("date", new Date());
        jobLauncher.run(ledgerJob, jobParameterBulider.toJobParameters());
        sw.stop();
        LOG.debug("Time elapsed:{},Execute quartz ledgerJob:{}", sw.prettyPrint(), ++counter);
    }

}
