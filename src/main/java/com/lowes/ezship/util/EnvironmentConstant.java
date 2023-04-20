
package com.lowes.ezship.util;

import java.util.HashMap;
import java.util.Map;

public enum EnvironmentConstant {
	/**
	 * Add more environments as required
	 */
	LOCAL, DEV, STAGE;

	private static final Map<EnvironmentConstant, String> envMap = new HashMap<>();

	static {
		envMap.put(EnvironmentConstant.LOCAL, "http://localhost");
		envMap.put(EnvironmentConstant.DEV, "https://smsdevhci-ssl.lowes.com");
		envMap.put(EnvironmentConstant.STAGE, "https://smsstghci-ssl.lowes.com");
	}

	public static String getBaseURI(EnvironmentConstant environmentConstant) {
		return envMap.get(environmentConstant);
	}

	public static EnvironmentConstant fromString(String env) {
		return EnvironmentConstant.valueOf(env);
	}
}
