package com.zyj.livestreamingdrainage.entity;

import com.zyj.livestreamingdrainage.tool.config.ConfigTool;
import org.openqa.selenium.chrome.ChromeOptions;

public interface Domain {
    default ChromeOptions getChromeOptions() {
        System.getProperties().setProperty("webdriver.chrome.driver", ConfigTool.chromeDriverPath);
        // 设置浏览器参数
        ChromeOptions chromeOptions = new ChromeOptions();
        //禁用沙箱
        chromeOptions.addArguments("--no-sandbox");
        //禁用开发者shm
        chromeOptions.addArguments("--disable-dev-shm-usage");
        //无头浏览器,这样不会打开浏览器窗口
        chromeOptions.addArguments("--headless");
        return chromeOptions;
    }

    String parse(String url);
}