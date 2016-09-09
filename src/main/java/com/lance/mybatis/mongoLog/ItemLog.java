package com.lance.mybatis.mongoLog;

public class ItemLog {

	private String URL;
	private String HTTP_METHOD;
	private String IP;
	private String CLASS_METHOD;
	private String ARGS;

	private String RESPONSE;
	private String SPEND_TIME;
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getHTTP_METHOD() {
		return HTTP_METHOD;
	}
	public void setHTTP_METHOD(String hTTP_METHOD) {
		HTTP_METHOD = hTTP_METHOD;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getCLASS_METHOD() {
		return CLASS_METHOD;
	}
	public void setCLASS_METHOD(String cLASS_METHOD) {
		CLASS_METHOD = cLASS_METHOD;
	}
	public String getARGS() {
		return ARGS;
	}
	public void setARGS(String aRGS) {
		ARGS = aRGS;
	}
	public String getRESPONSE() {
		return RESPONSE;
	}
	public void setRESPONSE(String rESPONSE) {
		RESPONSE = rESPONSE;
	}
	public String getSPEND_TIME() {
		return SPEND_TIME;
	}
	public void setSPEND_TIME(String sPEND_TIME) {
		SPEND_TIME = sPEND_TIME;
	}
	public ItemLog() {
		super();
	}
	public ItemLog(String uRL, String hTTP_METHOD, String iP, String cLASS_METHOD, String aRGS) {
		super();
		URL = uRL;
		HTTP_METHOD = hTTP_METHOD;
		IP = iP;
		CLASS_METHOD = cLASS_METHOD;
		ARGS = aRGS;
	}
	
}
