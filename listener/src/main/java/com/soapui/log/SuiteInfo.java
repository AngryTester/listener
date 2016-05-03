package com.soapui.log;

import java.util.ArrayList;
import java.util.List;

public class SuiteInfo {

	/** 测试套件名称 */
	public String suiteName;

	/** 测试套件包含用例 */
	public List<CaseInfo> testCases = new ArrayList<CaseInfo>();
	
	/** 套件结果 */
	public boolean suiteResult;

	/** 套件执行开始时间 */
	public String runStartTime;

	/** 套件执行结束时间 */
	public String runEndTime;
	
	/** 套件执行持续时间 */
	public String duration;
	

	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	public List<CaseInfo> getTestCases() {
		return testCases;
	}

	public void setTestCases(List<CaseInfo> testCases) {
		this.testCases = testCases;
	}

	public boolean isSuiteResult() {
		return suiteResult;
	}

	public void setSuiteResult(boolean suiteResult) {
		this.suiteResult = suiteResult;
	}

	public String getRunStartTime() {
		return runStartTime;
	}

	public void setRunStartTime(String runStartTime) {
		this.runStartTime = runStartTime;
	}

	public String getRunEndTime() {
		return runEndTime;
	}

	public void setRunEndTime(String runEndTime) {
		this.runEndTime = runEndTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
