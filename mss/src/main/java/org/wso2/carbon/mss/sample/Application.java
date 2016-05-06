package org.wso2.carbon.mss.sample;/*
*Copyright (c) 2005-2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*WSO2 Inc. licenses this file to you under the Apache License,
*Version 2.0 (the "License"); you may not use this file except
*in compliance with the License.
*You may obtain a copy of the License at
*
*http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing,
*software distributed under the License is distributed on an
*"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*KIND, either express or implied.  See the License for the
*specific language governing permissions and limitations
*under the License.
*/
import org.wso2.msf4j.MicroservicesRunner;

/**
 * This is the entry point to the Micro service. This initializes an instance of a
 * BuzzWordManager.
 * This Application.java class is referred in the pom.xml as a property.
 */
public class Application {
    public static void main(String[] args) {
        new MicroservicesRunner()
                .deploy(new BuzzWordManager())
                .deploy(new SwaggerDefinitionService())
                .start();
    }
}
