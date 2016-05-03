package com.soapui.log;

import java.util.ArrayList;
import java.util.List;

public class ProjectInfo {

	/** 项目名称 */
	public String projectName;

	/** 项目包含套件 */
	public List<SuiteInfo> suites = new ArrayList<SuiteInfo>();

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<SuiteInfo> getSuites() {
		return suites;
	}

	public void setSuites(List<SuiteInfo> suites) {
		this.suites = suites;
	}
}
