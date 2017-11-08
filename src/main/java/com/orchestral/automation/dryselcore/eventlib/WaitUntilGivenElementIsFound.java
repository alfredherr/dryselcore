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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitUntilGivenElementIsFound extends TestEvent {

	public WaitUntilGivenElementIsFound() {
	}

	@Override
	public void fire(final WebDriver webDriver, final String xPath, final String value) {
		final ExpectedCondition<Boolean> elementFound = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(final WebDriver wd) {
				wd.findElement(By.xpath(xPath));
				return true;
			}
		};
		final int tries = 10;
		for (int thisTry = 1; thisTry <= tries; thisTry++) {
			final Boolean result = elementFound.apply(webDriver);
			if (result != null && result) {
				return;
			}

			try {
				Thread.sleep(5000);
			} catch (final InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		throw new TimeoutException("Failed to find the element with xpath = " + xPath);
	}
}