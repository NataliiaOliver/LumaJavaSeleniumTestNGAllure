package com.lumatest.utils;

import org.testng.ITestResult;

public class ReportUtils {

    private static final String ERROR = "❌";
    private static final String SUCCESS = "✅";

    public static String getTestStatus(ITestResult result) {
        if (result.getStatus() == 1) {
            return SUCCESS + "PASS";
        } else if (result.getStatus() == 2) {
            return ERROR + "FAIL";
        }
        return "-1";
    }
}