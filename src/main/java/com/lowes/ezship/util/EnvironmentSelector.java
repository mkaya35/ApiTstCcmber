
package com.lowes.ezship.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnvironmentSelector {

	private static final Logger log = LoggerFactory.getLogger(EnvironmentSelector.class.getName());

	private static final EnvironmentConstant ezshipEnvironment;

	static {
		String env = System.getProperty("env");

		if (StringUtils.isEmpty(env)) {
			log.warn("System environment is not set.");
			ezshipEnvironment = EnvironmentConstant.DEV;
			log.warn("Using Default environment: {}", ezshipEnvironment.name());
		} else {                                                                                                                              
			ezshipEnvironment = EnvironmentConstant.fromString(env);
		}
	}

	private EnvironmentSelector() {
	}

	public static String getEzshipEnvUri() {
		return EnvironmentConstant.getBaseURI(getEzshipEnvironment());
	}

	public static EnvironmentConstant getEzshipEnvironment() {
		return ezshipEnvironment;
	}

}
