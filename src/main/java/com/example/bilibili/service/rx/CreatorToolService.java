package com.example.bilibili.service.rx;


import com.example.bilibili.entity.TakeAdvertise;

import java.util.List;
import java.util.Map;

public interface CreatorToolService {
    public List<Map<String, Object>> getAnalysisDataById(Integer ID);
    public int takeAdvertise(TakeAdvertise tk, Integer UploadID, Integer PositionID, Integer progress);
    public int getProgress(Integer ad_id);
    public List<Map<String,Object>> setAdvertise(Integer TakeAdId);

    //计算广告转化率
    public Double getAdConversionRate(Integer TakeAdId);
}
