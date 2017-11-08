/*
 * Copyright (c) Orchestral Developments Ltd and the Orion Health group of companies (2001 - 2017).
 * Author: Kuldeep Sinh Chauhan (@KuldeepSinhC)
 * emails: kuldeeps@orionhealth.com, chauhan.kuldeep.sinh@gmail.com
 *
 * This file is provided to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an  "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,  either express or implied.  See the License for the specific language governing    
 * permissions and limitations under the License.
 */
package com.orchestral.automation.dryselcore.model;

import com.orchestral.automation.dryselcore.eventlib.TestEvent;

public class TestStep {

	private String elementID;
	private TestEvent testEvent;
	private String value;

	public String getElementID() {
		return this.elementID;
	}

	public void setElementID(final String elementID) {
		this.elementID = elementID;
	}

	public TestEvent getTestEvent() {
		return this.testEvent;
	}

	public void setTestEvent(final TestEvent testEvent) {
		this.testEvent = testEvent;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public TestStep() {
	}

	public TestStep(final String elementID, final TestEvent testEvent, final String value) {
		setElementID(elementID);
		setTestEvent(testEvent);
		setValue(value);
	}
}
