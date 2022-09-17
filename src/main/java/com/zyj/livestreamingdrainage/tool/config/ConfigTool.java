package com.zyj.livestreamingdrainage.tool.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ConfigTool {
    public static String chromeDriverPath;
    public static Integer downloadSpeed;

    static {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("./config")))){
            String row = bufferedReader.readLine();
            chromeDriverPath = row.substring(row.indexOf(":") + 2,row.lastIndexOf('}'));
            row = bufferedReader.readLine();
            downloadSpeed = Integer.parseInt(row.substring(row.indexOf(":") + 2,row.lastIndexOf('}')));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}