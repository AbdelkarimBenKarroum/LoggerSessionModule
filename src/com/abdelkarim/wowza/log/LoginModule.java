package com.abdelkarim.wowza.log;

import com.wowza.wms.application.*;

import java.util.Date;
import com.wowza.wms.amf.*;
import com.wowza.wms.client.*;
import com.wowza.wms.module.*;
import com.wowza.wms.request.*;
import com.wowza.wms.stream.*;
import com.wowza.wms.rtp.model.*;
import com.wowza.wms.httpstreamer.model.*;
import com.wowza.wms.httpstreamer.cupertinostreaming.httpstreamer.*;
import com.wowza.wms.httpstreamer.smoothstreaming.httpstreamer.*;

public class LoginModule extends ModuleBase {
	
	LoggerSession logger=null;
	public void doSomething(IClient client, RequestFunction function, AMFDataList params) {
		getLogger().info("doSomething");
		sendResult(client, params, "Hello Wowza");
		
	}

	public void onAppStart(IApplicationInstance appInstance) {
		String fullname = appInstance.getApplication().getName() + "/" + appInstance.getName();
		getLogger().info("onAppStart: " + fullname);
		getLogger().info("Hello from Abdelkarim Test");
//		logger=new LoggerSessionBuilder()
//				.setNewAppName(appInstance.getName().toString())
//				.setNewClientID(String.valueOf(appInstance.getClientCount()))
//				.setNewDate(new Date())
//				.setNewMessage("Application Started")
//				.createLoggerSession();
//		logger.toMongo(logger);
		//logger.toFile(logger);
		
		logger= new LoggerSessionBuilder()
				.setNewLoggerName("AppLogger")
				.setNewAppName("myApp")
				.setNewClientID("1241")
				.setNewMessage("this is onStartEvenet")
				.setNewDate(new Date())
				.createLoggerSession();
		//logger.toFile(logger);
		logger.toMongo(logger);
	}

	public void onAppStop(IApplicationInstance appInstance) {
		String fullname = appInstance.getApplication().getName() + "/" + appInstance.getName();
		getLogger().info("onAppStop: " + fullname);
		getLogger().info("This is app when it stopped");
//		logger=new LoggerSessionBuilder()
//				.setNewAppName(appInstance.getName().toString())
//				.setNewClientID(String.valueOf(appInstance.getClientCount()))
//				.setNewDate(new Date())
//				.setNewMessage("Application Stopped")
//				.createLoggerSession();
//		logger.toMongo(logger);
		
		
		logger= new LoggerSessionBuilder()
				.setNewLoggerName("AppLogger")
				.setNewAppName("myApp")
				.setNewClientID("1241")
				.setNewMessage("this is onStartEvenet")
				.setNewDate(new Date())
				.createLoggerSession();
		//logger.toFile(logger);
		logger.toMongo(logger);
	}

	public void onConnect(IClient client, RequestFunction function, AMFDataList params) {
		getLogger().info("onConnect: " + client.getClientId());
//		logger=new LoggerSessionBuilder()
//				.setNewAppName(client.getAppInstance().getName().toString())
//				.setNewClientID(String.valueOf(client.getClientId()))
//				.setNewDate(new Date())
//				.setNewMessage("Client "+client.getClientId()+" is connected")
//				.createLoggerSession();
//		logger.toMongo(logger);
	}

	public void onConnectAccept(IClient client) {
		getLogger().info("onConnectAccept: " + client.getClientId());
//		logger=new LoggerSessionBuilder()
//				.setNewAppName(client.getAppInstance().getName().toString())
//				.setNewClientID(String.valueOf(client.getClientId()))
//				.setNewDate(new Date())
//				.setNewMessage("Client with id= "+client.getClientId()+" connection Accepted")
//				.createLoggerSession();
//		logger.toMongo(logger);
	}

	public void onConnectReject(IClient client) {
		getLogger().info("onConnectReject: " + client.getClientId());
	}

	public void onDisconnect(IClient client) {
		getLogger().info("onDisconnect: " + client.getClientId());
//		logger=new LoggerSessionBuilder()
//				.setNewAppName(client.getAppInstance().getName().toString())
//				.setNewClientID(String.valueOf(client.getClientId()))
//				.setNewDate(new Date())
//				.setNewMessage("Client with id= "+client.getClientId()+" Disconnected")
//				.createLoggerSession();
//		logger.toMongo(logger);
	}

}
