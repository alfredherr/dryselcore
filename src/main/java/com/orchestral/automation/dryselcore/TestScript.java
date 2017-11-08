/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 * Author: Kuldeep Sinh Chauhan (@KuldeepSinhC)
 * emails: kuldeeps@orionhealth.com, chauhan.kuldeep.sinh@gmail.com
 *
 * This file is provided to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an  "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,  either express or implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.orchestral.automation.dryselcore;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.orchestral.automation.dryselcore.model.ScriptType;
import com.orchestral.automation.dryselcore.model.TestDatum;
import com.orchestral.automation.dryselcore.model.TestStep;
import com.orchestral.automation.dryselcore.model.UIElement;

public class TestScript {

	private final SortedMap<Integer, TestStep> testScript;

	public TestScript() {
		this.testScript = new TreeMap<Integer, TestStep>();
	}

	public SortedMap<Integer, TestStep> getTestScript() {
		return this.testScript;
	}

	public void prepareScript(final ScriptType scriptType, final List<UIElement> uiElements, final List<TestDatum> testData) {
		for (final TestDatum testDatum : testData) {
			for (final UIElement uiElement : uiElements) {
				if (testDatum.getKey().equals(uiElement.getKey())) {
					addStepToScript(scriptType, uiElement, testDatum);
					break;
				}
			}
		}
	}

	private void addStepToScript(final ScriptType scriptType, final UIElement uiElement, final TestDatum testElement) {
		if (scriptType == ScriptType.InputScript) {
			this.testScript.put(testElement.getStepNumber(),
					new TestStep(uiElement.getElementID(), uiElement.getInputEvent(), testElement.getValue()));
		} else {
			this.testScript.put(testElement.getStepNumber(),
					new TestStep(uiElement.getElementID(), uiElement.getOutputEvent(), testElement.getValue()));
		}
	}
}