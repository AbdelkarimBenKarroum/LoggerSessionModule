package com.abdelkarim.wowza.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class LoggerSession {
	 public enum LoggerLevel{
		SEVERE,WARN,INFO,FINE;
	   }
	LoggerLevel level;
	String loggerName;
	Date date;
	String message;
	String appName;
	String clientID;
	
	
	public LoggerSession(LoggerLevel level, String loggerName, Date date, String message, String appName,
			String clientID) {
		super();
		this.level = level;
		this.loggerName = loggerName;
		this.date = date;
		this.message = message;
		this.appName = appName;
		this.clientID = clientID;
	}
	public LoggerLevel getLevel() {
		return level;
	}
	public void setLevel(LoggerLevel level) {
		this.level = level;
	}
	public String getLoggerName() {
		return loggerName;
	}
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	@Override
	public String toString() {
		return "LoggerSession [loggerName=" + loggerName + ", date=" + date + ", message=" + message + ", appName="
				+ appName + ", clientID=" + clientID + "]";
	}
	//credentials kullanmak isteyecegimiz icin metoda credentials ekleyebiliriz sonra
	//suan test oldugu icin boyle yazdim
	
	public void toMongo(LoggerSession logger) {
	    //implementation for mongodb goes here	
	
		MongoClient mongoClient=new MongoClient("127.0.1.1",27017);
		
		MongoDatabase database = mongoClient.getDatabase("test");
		System.out.println("connected successfully");
		System.out.println("Server is ready");
		//document to be added to selected database
		Document document= new Document()
				.append("Name", logger.getLoggerName())
				.append("ApplicationName", logger.getAppName())
		        .append("Date", logger.getDate())
		        .append("ClientID", logger.getClientID())
		        
		        .append("Message", logger.getMessage());
		
		//insertion operation
		MongoCollection<Document> collection = database.getCollection("loggers");
		collection.insertOne(document);
		mongoClient.close();
	}
	public void toFile(LoggerSession logger) {
		//saving to file code goes here
		try {
			File file=new File("Logs.log");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw=new FileWriter(file);
			fw.write(logger.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
	}
	public void saveAsSimpleText(String filePath) {
		//code goes here
	}
	
	
	
	
	
	

}

