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

public class UIElement {

	private String key;
	private String elementID;
	private TestEvent inputEvent;
	private TestEvent outputEvent;

	public UIElement() {

	}

	public UIElement(final String key, final String elementID) {
		setKey(key);
		setElementID(elementID);
	}

	public UIElement(final String key, final String elementID, final TestEvent inputEvent,
			final TestEvent outputEvent) {
		this(key, elementID);
		setInputEvent(inputEvent);
		setOutputEvent(outputEvent);
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public String getElementID() {
		return this.elementID;
	}

	public void setElementID(final String elementID) {
		this.elementID = elementID;
	}

	public TestEvent getInputEvent() {
		return this.inputEvent;
	}

	public void setInputEvent(final TestEvent inputEvent) {
		this.inputEvent = inputEvent;
	}
	public TestEvent getOutputEvent() {
		return this.outputEvent;
	}

	public void setOutputEvent(final TestEvent outputEvent) {
		this.outputEvent = outputEvent;
	}
}
