package com.soapui.listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import com.eviware.soapui.impl.support.http.HttpRequestTestStep;
import com.eviware.soapui.impl.wsdl.teststeps.HttpTestRequest;
import com.eviware.soapui.impl.wsdl.teststeps.RestRequestStepResult;
import com.eviware.soapui.model.support.TestRunListenerAdapter;
import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.model.testsuite.TestStepResult;
import com.soapui.log.CaseInfo;
import com.soapui.log.StepInfo;
import com.soapui.util.DateUtil;
import com.soapui.util.FormatUtil;

public class TestCaseListener extends TestRunListenerAdapter {
	List<StepInfo> steps = new ArrayList<StepInfo>();
	HttpRequestTestStep step = null;
	HttpTestRequest request = null;
	Date stepStartTime = null;
	Date stepStopTime = null;
	Date caseStartTime = null;
	Date caseStopTime = null;
	int stepIndex = 1;

	public void afterRun(TestCaseRunner testRunner, TestCaseRunContext runContext) {
		caseStopTime = new Date();
		CaseInfo caseInfo = new CaseInfo();
		caseInfo.setRunStartTime(caseStartTime.toString());
		caseInfo.setRunEndTime(caseStopTime.toString());
		caseInfo.setCaseName(testRunner.getTestCase().getName());
		caseInfo.setSteps(steps);
		for (StepInfo step : steps) {
			if (step.getResponseCode()!=200) {
				caseInfo.setCaseResult(false);
			} else {
				caseInfo.setCaseResult(true);
			}
		}
		caseInfo.setDuration(DateUtil.getDuration(caseStartTime, caseStopTime));
		String suiteName = testRunner.getTestCase().getTestSuite().getName();
		String projectName = testRunner.getTestCase().getProject().getName();
		String path = System.getProperty("user.dir");
		File file = new File(path.substring(0, path.lastIndexOf("\\")) + "/report/" + projectName + "/" + suiteName);
		if (!file.exists()) {
			file.mkdirs();
		}

		Properties p = new Properties();
		p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		p.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, path.substring(0, path.lastIndexOf("\\")) + "\\");
		Velocity.init(p);
		VelocityContext context = new VelocityContext();
		context.put("caseInfo", caseInfo);
		Template template = Velocity.getTemplate("case.vm");
		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		PrintWriter filewriter;
		try {
			filewriter = new PrintWriter(
					new FileOutputStream(file + "\\" + caseInfo.getCaseName() + "_" + DateUtil.getNowTime() + ".html"),
					true);
			filewriter.println(writer.toString());
			filewriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		steps.clear();
		stepIndex = 1;
	}

	public void afterStep(TestCaseRunner testRunner, TestCaseRunContext runContext, TestStepResult result) {
		stepStopTime = new Date();
		StepInfo stepInfo = new StepInfo();
		step = (HttpRequestTestStep) (result.getTestStep());
		request = (HttpTestRequest) step.getTestRequest();
		stepInfo.setStepIndex(stepIndex);
		stepInfo.setStepName(step.getName());
		stepInfo.setRequestMethod(request.getMethod().name());
		stepInfo.setRequestUrl(request.getEndpoint());
		stepInfo.setRequestQueryString(request.getRequestContent());
		byte[] requestRaw = ((RestRequestStepResult) result).getRawRequestData();
		byte[] responseRaw = ((RestRequestStepResult) result).getRawResponseData();
		String requestHeaders = "";
		String responseHeaders = "";
		try {
			requestHeaders = new String(requestRaw, "UTF-8");
			responseHeaders = new String(responseRaw, "UTF-8").split("\r\n\r\n")[0];
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (requestHeaders.contains("JSESSIONID=")) {
			stepInfo.setRequestCookies(requestHeaders.split("JSESSIONID=")[1].split("Cookie2")[0]);
		} else{
			stepInfo.setRequestCookies("");
		}
		stepInfo.setRequestHeaders(requestHeaders);
		stepInfo.setResponseHeaders(responseHeaders);
		stepInfo.setResponseData(FormatUtil.formatJson(request.getResponseContentAsString()));
		stepInfo.setResponseCode(request.getResponse().getStatusCode());
		stepInfo.setResponseTime(DateUtil.getDuration(stepStartTime, stepStopTime));
		steps.add(stepInfo);
		stepIndex++;
	}

	public void beforeRun(TestCaseRunner testRunner, TestCaseRunContext runContext) {
		caseStartTime = new Date();
	}

	public void beforeStep(TestCaseRunner testRunner, TestCaseRunContext runContext) {

	}

	public void beforeStep(TestCaseRunner testRunner, TestCaseRunContext runContext, TestStep testStep) {
		stepStartTime = new Date();
	}
}
