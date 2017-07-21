package com.abdelkarim.wowza.log;

import java.util.Date;

import com.abdelkarim.wowza.log.LoggerSession.LoggerLevel;


public class LoggerSessionBuilder {

	private LoggerLevel newLevel;
	private String newLoggerName;
	private Date newDate;
	private String newMessage;
	private String newAppName;
	private String newClientID;
	public LoggerSessionBuilder setNewLevel(LoggerLevel info) {
		this.newLevel = info;
		return this;
	}
	public LoggerSessionBuilder setNewLoggerName(String newLoggerName) {
		this.newLoggerName = newLoggerName;
		return this;
	}
	public LoggerSessionBuilder setNewDate(Date newDate) {
		this.newDate = newDate;
		return this;
	}
	public LoggerSessionBuilder setNewMessage(String newMessage) {
		this.newMessage = newMessage;
		return this;
	}
	public LoggerSessionBuilder setNewAppName(String newAppName) {
		this.newAppName = newAppName;
		return this;
	}
	public LoggerSessionBuilder setNewClientID(String newClientID) {
		this.newClientID = newClientID;
		return this;
	}
	public LoggerSession createLoggerSession() {
		return new LoggerSession(newLevel, newLoggerName, newDate, newMessage, newAppName, newClientID);
	}
}
