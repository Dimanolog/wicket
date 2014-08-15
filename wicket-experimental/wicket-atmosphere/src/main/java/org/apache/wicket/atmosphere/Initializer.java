/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.atmosphere;

import de.agilecoders.wicket.webjars.WicketWebjars;
import org.apache.wicket.Application;
import org.apache.wicket.IInitializer;

/**
 * Initializes Wicket Atmosphere application.
 * Installs Webjars support.
 */
public class Initializer implements IInitializer
{
	@Override
	public void init(Application application)
	{
		try
		{
			WicketWebjars.settings();
		}
		catch (IllegalStateException x)
		{
			// try to install only if it is not already installed
			// TODO simplify once wicket-webjars has WicketWebjars#isInstalled(application)
			WicketWebjars.install((org.apache.wicket.protocol.http.WebApplication) application);
		}
	}

	@Override
	public void destroy(Application application)
	{
	}
}