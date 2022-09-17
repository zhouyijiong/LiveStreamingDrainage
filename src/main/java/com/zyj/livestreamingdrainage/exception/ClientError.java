package com.zyj.livestreamingdrainage.exception;

/**
 * 客户端异常
 */
public interface ClientError {
    ClientException LIVE_CLOSED = new ClientException("直播间关闭");
    ClientException UNKNOWN_ERROR = new ClientException("未知错误,请查看虎牙直播间是否关闭");
}