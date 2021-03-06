/*
 * Copyright 2000-2013 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.tests.push;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.tests.tb3.MultiBrowserTest;

public class PushFromInitTest extends MultiBrowserTest {
    @Test
    public void testPushFromInit() {
        openTestURL();

        for (int second = 0;; second++) {
            if (second >= 30) {
                Assert.fail("timeout");
            }
            try {
                if ("1. Logged in init".equals(vaadinElementById(
                        "Log_row_1").getText())) {
                    break;
                }
            } catch (Exception e) {
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }

        Assert.assertEquals(
                "2. Logged from background thread started in init",
                vaadinElementById("Log_row_0").getText());

    }
}