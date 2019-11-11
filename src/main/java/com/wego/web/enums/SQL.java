package com.wego.web.enums;

public enum SQL {
	CREATE_DB, CREATE_USER, DROP_USER;
	@Override
	public String toString() {
		String result = "";
		switch(this) {
		case CREATE_DB:
			result = "CREATE DATABASE WEGODB";
			break;
		case CREATE_USER:
			result = "CREATE TABLE USER()";
			break;
		
		case DROP_USER:
			result = "DROP TABLE USER";
			break;
		}
		return result;
	}
	
}
