package com.csii.demo.sim.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csii.pe.service.comm.Server;

public class TCPSimServer {
	public  static void main(String[] args){
		TCPSimServer server=new TCPSimServer();
		System.out.println("启动XML服务器....");
		server.startXmlServer();
		
	}
	
	@SuppressWarnings("resource")
	public  void startXmlServer() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:/META-INF/config/*.xml"});
		context.refresh();
		Server server = (Server) context.getBean("TcpServer");
		server.start();
		
	}
}
