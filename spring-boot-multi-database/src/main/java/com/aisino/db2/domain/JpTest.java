package com.aisino.db2.domain;

public class JpTest {
    private String testId;

    private String testName;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId == null ? null : testId.trim();
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }

	@Override
	public String toString() {
		return "JpTest [testId=" + testId + ", testName=" + testName + "]";
	}

	public JpTest(String testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}

	public JpTest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}