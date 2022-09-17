package com.zyj.livestreamingdrainage.mapper.master;

import com.zyj.livestreamingdrainage.entity.Domain;
import com.zyj.livestreamingdrainage.entity.Douyin;
import com.zyj.livestreamingdrainage.entity.Huya;

import java.util.Hashtable;

public final class LiveStreamingMapper{
    public static final Hashtable<String, Domain> LIVES = new Hashtable<>();
    static{
        LIVES.put("douyin",new Douyin());
        LIVES.put("huya",new Huya());
    }
}