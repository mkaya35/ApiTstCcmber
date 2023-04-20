
package com.lowes.ezship.util.data.loader;

import com.lowes.ezship.cucumber.actions.Actions;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import static java.util.Objects.nonNull;

@Slf4j
public class Loader {
	private static final String TEST_DATA_PATH = "TEST-DATA-PATH";
	private static final String TEST_DATA_DIR = "/test-data/";

	protected static BufferedReader getTestDataReader(String fileName) {

		final URL itemUrl = Actions.class.getResource(TEST_DATA_DIR + fileName);
		String path = System.getProperty(TEST_DATA_PATH);
		BufferedReader bufferedReader = null;

		try {
			if (nonNull(path)) {
				bufferedReader = new BufferedReader(new FileReader(new File(path)));
			} else if (nonNull(itemUrl)) {
				path = itemUrl.getPath();
				bufferedReader = new BufferedReader(new InputStreamReader(itemUrl.openStream()));
			} else {
				path = TEST_DATA_DIR + fileName;
				bufferedReader = new BufferedReader(new FileReader(new File(path)));
				log.info("*****item test data file is not available*****");
			}

		} catch (IOException e) {
			e.printStackTrace();
			log.error("unable to read file from :{}", itemUrl.getPath());
		}
		log.info("test data path for {} json is : {}", fileName, path);
		return bufferedReader;
	}


}
