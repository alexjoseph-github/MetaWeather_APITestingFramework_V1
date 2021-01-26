# API Framework: YAML (Single Data Provider for Diff APIs)

1. Framework support GET request as of now. However can be enhanced for other request.
2. All the test data for different type of APIs are kept under common Yaml file (src\test\resources\testdata\all_test_data.yaml)
3. For every test cases, we have single Data Provider which is of great importance
4. Test Data is kept in a YAML file rather json, excel, csv etc. Yaml gives huge advantages over other format in terms of readability, code minimization, maintenance
5. This framework can be run according to different suites like smoke, reg. Suites has been implemented based on test data provided.
6. Logger has been implemented and logs can be taken from /target/output.log

*********************************************************************************************************
Overview of different layers: 

	#Data Layer (src/test/java/com/data)
		a. Data layer will read yaml, convert it into AllTestCaseData.java (src/test/java/com/data/yaml)
		b. AllTestCaseData contains a Map which contains all data present in yaml file
		c. Map is based on test cases name and their respective data
		d. At runtime Data Provider will provider only specific data to @Test method which is required
		e. Data Provider will filter the test data based on test category provided in test data e.g. sanity, reg etc
		   test category defined in properties.yaml file (cases_to_be_run)
	
	#Business Layer (src/test/java/com/businesslayer)
		a. Sole purpose is to perform business logic tasks
		b. Methods expects some data and populate response POJOs (src/test/java/com/pojos)
		
	#Test Case Layer (src/test/java/testcases)
		a. Will get data from Data Provider, Call Business Layer for operation and perform Assertions

*********************************************************************************************************
