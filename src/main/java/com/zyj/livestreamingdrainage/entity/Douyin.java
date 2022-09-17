package com.zyj.livestreamingdrainage.entity;

import com.zyj.livestreamingdrainage.exception.ClientError;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Douyin implements Domain {
    @Override
    public String parse(String url) {
        WebDriver driver = new ChromeDriver(getChromeOptions());
        driver.get(url);
        String entries = ((JavascriptExecutor) driver).executeScript("return performance.getEntries()").toString();
        try {
            int end = entries.indexOf(".flv") + 4;
            int start = entries.substring(0, end).lastIndexOf("name=") + 5;
            return entries.substring(start, end);
        } catch (NullPointerException e) {
            throw ClientError.LIVE_CLOSED;
        }finally {
            driver.quit();
        }
    }
}