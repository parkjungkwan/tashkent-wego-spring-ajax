package com.wego.web.enums;

public enum SQL {
	CREATE_DB, CREATE_USER, DROP_USER, CREATE_ITEM, TRUNCATE_USER;
	@Override
	public String toString() {
		String result = "";
		switch(this) {
		case CREATE_DB:
			result = "CREATE DATABASE WEGODB";
			break;
		case CREATE_USER:
			result = "CREATE TABLE USER(UID VARCHAR(30)PRIMARY KEY,"
                    + " PWD VARCHAR(30) ," +
                    "  UNAME VARCHAR(30) ," +
                    "  BIRTH VARCHAR(30) ," +
                    "  GENDER VARCHAR(10) ," +
                    "  TEL VARCHAR(30)," +
                    "  PETTYPE VARCHAR(30))";
			break;
		case CREATE_ITEM:
			result = "CREATE TABLE ITEM()";
			break;
		
		case DROP_USER:
			result = "DROP TABLE USER";
			break;
		case TRUNCATE_USER :
			result = "TRUNCATE TABLE USER";
			break;
		}
		
		return result;
	}
	
}
