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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Click extends TestEvent {

	public Click() {
	}

	@Override
	public void fire(final WebDriver webDriver, final String xPath, final String value) throws ElementNotEnabledException {
		final WebElement webElement = webDriver.findElement(By.xpath(xPath));
		clickIfEnabled(webElement);
	}

	private void clickIfEnabled(final WebElement webElement) throws ElementNotEnabledException {
		final String disabled = webElement.getAttribute("disabled");
		if (Boolean.valueOf(disabled)) {
			throw new ElementNotEnabledException("Element not enabled.");
		} else {
			webElement.click();
		}
	}
}
