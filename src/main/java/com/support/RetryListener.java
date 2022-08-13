package com.support;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import ui.auto.core.support.TestContext;

public class RetryListener implements IRetryAnalyzer {
    private int counter = 0;

    @Override
    public boolean retry(ITestResult result) {
        System.out.println(result);
        int number_to_retry = TestContext.getTestProperties().getTestDefaultRetry();
        if(counter < number_to_retry) {
            counter++;
            return true;
        }
        return false;
    }
}
