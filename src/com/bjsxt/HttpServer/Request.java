package com.bjsxt.HttpServer;
import java.io.*;
import java.util.*;
import java.net.*;
public class Request {
	private InputStream is;
	private Socket s;
	private String sRequestInfo;
	private String sMethod;

	private String sUrl;
	private String sPage;

	private Map parameters;

	public Request(){
		s = null;
		is = null;
		sRequestInfo = null;
		sMethod = null;
		sUrl = null;
		sPage = null;
		parameters = new HashMap<String,ArrayList<String>>();
	}
	public Request(InputStream is){
		this();
		this.is = is;
		getRequest();
	}
	public void getRequest(){
		try {
			byte[] requestRawData = new byte[20480];
			int len = is.read(requestRawData);
			//System.out.println(len+"bytes read!");
			sRequestInfo = new String(requestRawData,0,len);
			System.out.println(sRequestInfo);
			parseRequestInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void parseRequestInfo(){
		String sParameter = null;;
		if (sRequestInfo.trim().length() == 0 || sRequestInfo == null){
			return;
		}
		String firstLine = sRequestInfo.substring(0, sRequestInfo.indexOf(HttpServer.CRLN));
		int idx = firstLine.indexOf("/");
		sMethod = firstLine.substring(0, idx).trim();
		sUrl = firstLine.substring(idx,firstLine.indexOf("HTTP/"));
		
		if (sMethod.equalsIgnoreCase("GET")){
			if (!firstLine.contains("?")){
				return; // no parameters
			} else {
				sPage = sUrl.substring(sUrl.indexOf("/")+1, sUrl.indexOf("?"));
				sParameter = sUrl.substring(sUrl.indexOf("?")+1);
			}
		} else if (sMethod.equalsIgnoreCase("POST")){
			sPage = firstLine.substring(idx+1, firstLine.indexOf("HTTP/"));
			sParameter = sRequestInfo.substring(sRequestInfo.lastIndexOf(HttpServer.CRLN)).trim();
		}
		if (sParameter != null){
			paraseParameter(sParameter);			
		}
	}
	public void paraseParameter(String sParameter){ //needs to analyze the parameter and put the parameters into the map
		StringTokenizer token = new StringTokenizer(sParameter,"&");
		while (token.hasMoreTokens()){
			String keyValue = token.nextToken().trim();
			String[] keyValues = keyValue.split("=");
			if (keyValues.length == 1){
				keyValues = Arrays.copyOf(keyValues, 2);
				keyValues[1] = null;
			}
			String key = keyValues[0].trim();
			String value = null==keyValues[1]?null:keyValues[1];
			if (!parameters.containsKey(key)){
				parameters.put(key, new ArrayList<String>());
			} 
			List<String> values = (List<String>) parameters.get(key);
			values.add(value);
		}
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}
	public String getsPage() {
		return sPage;
	}
	public String getsUrl() {
		return sUrl;
	}
}
