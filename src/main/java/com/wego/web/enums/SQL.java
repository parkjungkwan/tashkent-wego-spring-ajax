package com.wego.web.enums;

public enum SQL {
	CREATE_DB, CREATE_USER, DROP_USER, CREATE_ITEM, TRUNCATE_USER, CREATE_COMMUNITY, DROP_COMMUNITY;
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
			result = "TRUNCATE TABLE COMMU";
			result = "CREATE TABLE ITEM()";
			break;
		case CREATE_COMMUNITY :
           result = "CREATE TABLE COMMUNITY("
                  + "ARTSEQ VARCHAR(30)INT AUTO_INCREMENT PRIMARY KEY,"
                  + "IMG VARCHAR(30)  REFERENCES IMG,"
                  + "UID VARCHAR(30)  REFERENCES USER,"
                  + "COMMENTS VARCHAR(30),"
                  + "MSG VARCHAR(30),"
                  + "RATING VARCHAR(30), "
                  + "BOARDTYPE VARCHAR(30),"
                  + "TITLE VARCHAR(30),"
                  + "CONTENT VARCHAR(30))";
			break;
		case DROP_COMMUNITY:
			result = "DROP TABLE COMMUNITY";
			break;
		}
		
		return result;
	}
	
}
