package com.soapui.log;

import java.util.ArrayList;
import java.util.List;

public class CaseInfo {

	/** 用例名称 */
	public String caseName;

	/** 用例包含步骤 */
	public List<StepInfo> steps = new ArrayList<StepInfo>();

	/** 用例结果 */
	public boolean caseResult;

	/** 用例执行开始时间 */
	public String runStartTime;

	/** 用例执行结束时间 */
	public String runEndTime;

	/** 用例执行持续时间 */
	public String duration;

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public List<StepInfo> getSteps() {
		return steps;
	}

	public void setSteps(List<StepInfo> steps) {
		this.steps = steps;
	}

	public boolean isCaseResult() {
		return caseResult;
	}

	public void setCaseResult(boolean caseResult) {
		this.caseResult = caseResult;
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
