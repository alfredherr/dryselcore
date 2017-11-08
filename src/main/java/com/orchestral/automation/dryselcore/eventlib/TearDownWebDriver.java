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
package com.orchestral.automation.dryselcore.eventlib;

import org.openqa.selenium.WebDriver;

public class TearDownWebDriver extends TestEvent {

	public TearDownWebDriver() {
	}

	@Override
	public void fire(final WebDriver webDriver, final String xPath, final String value) throws ElementNotEnabledException {
		// try {
		// // check if the web-driver is already closed/quit
		// if (webDriver != null && webDriver.getTitle() != null) {
		// webDriver.quit();
		// // this is required to cleanup the instance.
		// webDriver = null;
		// }
		// } catch (final Exception ex) {
		//
		// }
	}
}
