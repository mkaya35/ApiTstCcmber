
package com.lowes.ezship.util.data.loader;

import com.google.gson.Gson;
import com.lowes.ezship.exception.LoaderException;
import com.lowes.ezship.model.vendor.VendorServiceRequest;

import java.io.BufferedReader;
import java.io.IOException;

public class VendorRequestLoader extends Loader {

	public static VendorServiceRequest loadVendorServiceRequestFromJson(String fileName) {
		try (BufferedReader testDataReader = getTestDataReader(fileName)) {
			return new Gson().fromJson(testDataReader, VendorServiceRequest.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new LoaderException("Exception while loading file", e);
		}
	}

}
