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

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RemoveAllWhiteSpacesAndCompareValues extends TestEvent {

	public RemoveAllWhiteSpacesAndCompareValues() {
	}

	@Override
	public void fire(final WebDriver webDriver, final String xPath, final String value) throws ElementNotEnabledException {
		final WebElement formElement = webDriver.findElement(By.xpath(xPath));
		Assert.assertEquals("The expected element is NOT equal to : " + value, value.toLowerCase(),
				formElement.getAttribute("value").replaceAll("\\s+", "").toLowerCase());
		// in above line,
		// replaceAll("\\s+", "") ===> is a regex replacement of white spaces
	}

}
