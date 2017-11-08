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
package com.orchestral.automation.dryselcore.helper;

import java.util.ArrayList;
import java.util.List;

public abstract class TestObjectHelper<T> {
	protected final List<T> testObjects;

	public TestObjectHelper() {
		this.testObjects = new ArrayList<T>();
	}

	public List<T> getTestObjects() {
		// add test object to the list
		addTestObjects();
		return this.testObjects;
	}

	abstract protected void addTestObjects();
}
