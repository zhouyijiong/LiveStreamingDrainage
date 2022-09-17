package com.zyj.livestreamingdrainage.controller.master;

import com.zyj.livestreamingdrainage.service.master.LiveStreamingService;
import com.zyj.livestreamingdrainage.tool.response.Response;
import com.zyj.livestreamingdrainage.tool.xor.Codec;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/liveStreaming")
@RequiredArgsConstructor
public class LiveStreamingController {
    private final LiveStreamingService liveStreamingService;

    @PostMapping("/getLiveLink")
    public Response<String> getLiveLink(String url) {
        return Response.success(liveStreamingService.getLiveLink(url));
    }

    @GetMapping("/download/{url}")
    public String download(HttpServletResponse response, @PathVariable String url) {
        return liveStreamingService.download(response, Codec.complex(url, 65537));
    }
}