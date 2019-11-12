package com.wego.web.enums;

public enum SQL {
	CREATE_DB, CREATE_USER, DROP_USER, CREATE_ITEM;
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
		case CREATE_ITEM:
			result = "CREATE TABLE ITEM()";
			break;
		
		case DROP_USER:
			result = "DROP TABLE USER";
			break;
		}
		return result;
	}
	
}
