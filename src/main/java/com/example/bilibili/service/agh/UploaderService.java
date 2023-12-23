package com.example.bilibili.service.agh;

import com.example.bilibili.entity.Upload;

import java.util.List;

public interface UploaderService {
    public List<Upload> getAllUploaders();

    public int updateUploaderStatus(Integer id);
}
