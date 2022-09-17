package com.zyj.livestreamingdrainage.service.master;

import com.zyj.livestreamingdrainage.mapper.master.LiveStreamingMapper;
import com.zyj.livestreamingdrainage.tool.config.ConfigTool;
import com.zyj.livestreamingdrainage.tool.md5.MD5;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class LiveStreamingService {
    public String getLiveLink(String url) {
        return LiveStreamingMapper.LIVES.get(getDomain(url)).parse(url);
    }

    public String download(HttpServletResponse response, String url) {
        try {
            String fileName = "直播流视频" + MD5.encrypt(url);
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json;charset=GBK");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            response.setHeader("content-type","application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
            BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
            ServletOutputStream sos = response.getOutputStream();
            int len;
            byte[] size = new byte[1024 * 1024 * ConfigTool.downloadSpeed];
            while ((len = bis.read(size)) > 0) {
                sos.write(size,0,len);
                sos.flush();
            }
            bis.close();
            sos.close();
        } catch (IOException e) {
            return e.getMessage();
        }
        return null;
    }

    String getDomain(String url) {
        int start = url.indexOf(".");
        int end = url.indexOf('.', start + 1);
        return url.substring(start + 1, end);
    }
}