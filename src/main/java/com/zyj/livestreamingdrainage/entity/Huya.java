package com.zyj.livestreamingdrainage.entity;

import com.zyj.livestreamingdrainage.exception.ClientError;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Huya implements Domain {
    @Override
    public String parse(String url) {
        WebDriver driver = new ChromeDriver(getChromeOptions());
        driver.get(url);
        try{
            String liveLink = ((JavascriptExecutor) driver).executeScript("streamInfo = window.hyPlayerConfig.stream.data[0].gameStreamInfoList[0];" +
                    "return streamInfo.sFlvUrl + '/' + streamInfo.sStreamName + '.' + streamInfo.sFlvUrlSuffix + '?' + streamInfo.sFlvAntiCode;").toString();
            return liveLink.substring(0, liveLink.length() - 1);
        }catch (Exception e){
            throw ClientError.UNKNOWN_ERROR;
        }finally {
            driver.quit();
        }
    }
}