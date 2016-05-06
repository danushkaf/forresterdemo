/*
 *  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.mss.sample;

import io.swagger.util.Json;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * This service returns the Swagger definition of all the APIs of the microservices deployed in this runtime.
 */
@Path("/swagger")
public class SwaggerDefinitionService {

	private MSF4JBeanConfig msf4JBeanConfig;

	@GET
	public Response getSwaggerDefinition(@QueryParam("path") String path) throws Exception {
		if (msf4JBeanConfig == null) {
			msf4JBeanConfig = new MSF4JBeanConfig();
			msf4JBeanConfig.addServiceClass(BuzzWordManager.class);
			msf4JBeanConfig.setScan(true);
		}
		return Response.status(Response.Status.OK).
				entity(Json.mapper().
						writerWithDefaultPrettyPrinter().writeValueAsString(msf4JBeanConfig.getSwagger())).
				               build();
	}
}