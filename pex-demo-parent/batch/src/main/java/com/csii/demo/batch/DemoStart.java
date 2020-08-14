package com.csii.demo.batch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by darkstar on 2017/11/29.
 */
public class DemoStart {

    /**
     * 使用quartz定时执行
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

       /* JobLauncher jobLauncher = context.getBean("jobLauncher",JobLauncher.class);
*/

       while (true){

       }

    }

}
