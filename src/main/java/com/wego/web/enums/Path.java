package com.wego.web.enums;

public enum Path {
  UPLOAD_PATH, CRAWLING_TARGET;
  @Override
	public String toString() {
		String result = "";
		switch(this) {
		case UPLOAD_PATH:
			result = "C:\\Users\\user\\Downloads\\TEXAS_SPRING5_WEGO-develop_srch\\TEXAS_SPRING5_WEGO-develop_srch\\src\\main\\webapp\\resources\\upload\\temp";
			break;
		case CRAWLING_TARGET:
			result = "https://store.naver.com/accommodations/detail?entry=plt&id=1285629759&tab=bookingReview&tabPage=1";
		}
		
		return result;
  }
}
