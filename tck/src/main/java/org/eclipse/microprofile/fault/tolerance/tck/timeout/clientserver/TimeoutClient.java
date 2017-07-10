/*
 *******************************************************************************
 * Copyright (c) 2016-2017 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.eclipse.microprofile.fault.tolerance.tck.timeout.clientserver;

import java.sql.Connection;

import javax.enterprise.context.RequestScoped;

import org.eclipse.microprofile.faulttolerance.Timeout;
/**
 * A client to test Timeouts
 * 
 * @author <a href="mailto:neil_young@uk.ibm.com">Neil Young</a>
 *
 */
@RequestScoped
public class TimeoutClient {

    
    @Timeout
    public Connection serviceA() {
        try {
            Thread.sleep(20000);
            throw new RuntimeException("Timeout did not interrupt");
        } catch (InterruptedException e) {
            //expected
        }
        return null;
    }

    @Timeout
    public Connection serviceB() {
        try {
            Thread.sleep(10);
            throw new RuntimeException("Timeout did not interrupt");
        } catch (InterruptedException e) {
            //expected
        }
        return null;
    }
    
}
