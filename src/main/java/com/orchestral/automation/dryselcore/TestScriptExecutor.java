/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 * Author: Kuldeep Sinh Chauhan (@KuldeepSinhC)
 * emails: kuldeeps@orionhealth.com, chauhan.kuldeep.sinh@gmail.com
 *
 * This file is provided to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 */
package com.orchestral.automation.dryselcore;

import java.util.List;
import java.util.SortedMap;

import org.openqa.selenium.WebDriver;

import com.orchestral.automation.dryselcore.eventlib.ElementNotEnabledException;
import com.orchestral.automation.dryselcore.model.ScriptType;
import com.orchestral.automation.dryselcore.model.TestDatum;
import com.orchestral.automation.dryselcore.model.TestStep;
import com.orchestral.automation.dryselcore.model.UIElement;

public class TestScriptExecutor {

	private final WebDriver webDriver;
	private final TestScript testScript;

	public TestScriptExecutor(final WebDriver webDriver) {
		this.webDriver = webDriver;
		this.testScript = new TestScript();
	}

	public void executeInputScript(final List<UIElement> uiElements, final List<TestDatum> testData)
			throws ElementNotEnabledException {
		this.testScript.prepareScript(ScriptType.InputScript, uiElements, testData);
		executeScript(this.testScript.getTestScript());
	}

	public void executeOutputScript(final List<UIElement> uiElements, final List<TestDatum> testData)
			throws ElementNotEnabledException {
		this.testScript.prepareScript(ScriptType.OutputScript, uiElements, testData);
		executeScript(this.testScript.getTestScript());
	}

	private void executeScript(final SortedMap<Integer, TestStep> script) throws ElementNotEnabledException {
		for (final SortedMap.Entry<Integer, TestStep> testStep : script.entrySet()) {
			executeStep(testStep.getValue());
		}
	}

	private void executeStep(final TestStep testStep) throws ElementNotEnabledException {
		if (testStep.getTestEvent() != null) {
			System.out.println("UI Element = " + testStep.getElementID() + ", Value = " + testStep.getValue()
					+ ", Test Event = " + testStep.getTestEvent().toString());
			testStep.getTestEvent().fire(this.webDriver, testStep.getElementID(), testStep.getValue());
		}
	}
}
