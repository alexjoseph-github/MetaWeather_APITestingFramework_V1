package com.data.yaml;

import java.util.List;
import java.util.Map;

/**
 * This class will load the yaml file data
 */
public class AllTestCaseData {
	
	private Map<String, List<TestData>> allTestCaseDataMap;

	public Map<String, List<TestData>> getAllTestCaseDataMap() {
		return allTestCaseDataMap;
	}

	public void setAllTestCaseDataMap(Map<String, List<TestData>> allTestCaseDataMap) {
		this.allTestCaseDataMap = allTestCaseDataMap;
	}

}
