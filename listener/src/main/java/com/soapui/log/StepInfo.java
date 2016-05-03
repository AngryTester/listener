package com.soapui.log;

public class StepInfo {
	
	/** 步骤序号 */
	public int stepIndex;

	/** 步骤名称 */
	public String stepName;

	/** 请求方法 */
	public String requestMethod;

	/** 请求url*/
	public String requestUrl;

	/** 请求内容 */
	public String requestQueryString;

	/** 请求cookies */
	public String requestCookies;

	/** 请求头 */
	public String requestHeaders;

	/** 响应头 */
	public String responseHeaders;

	/** 响应内容 */
	public String responseData;
	
	/** 响应时间 */
	public String responseTime;
	
	/** 响应码 */
	public int responseCode;
	
	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestQueryString() {
		return requestQueryString;
	}

	public void setRequestQueryString(String requestQueryString) {
		this.requestQueryString = requestQueryString;
	}

	public String getRequestCookies() {
		return requestCookies;
	}

	public void setRequestCookies(String requestCookies) {
		this.requestCookies = requestCookies;
	}

	public String getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(String requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	public String getResponseHeaders() {
		return responseHeaders;
	}

	public void setResponseHeaders(String responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public int getStepIndex() {
		return stepIndex;
	}

	public void setStepIndex(int stepIndex) {
		this.stepIndex = stepIndex;
	}


}
