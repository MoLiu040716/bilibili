package com.example.bilibili.service.agh.impl;

import com.example.bilibili.entity.Upload;
import com.example.bilibili.mapper.agh.UploaderMapper;
import com.example.bilibili.service.agh.UploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploaderServiceImpl implements UploaderService {
    @Autowired
    private UploaderMapper uploaderMapper;
    @Override
    public List<Upload> getAllUploaders() {
        return uploaderMapper.getAllUploaders();
    }

    @Override
    public int updateUploaderStatus(Integer id) {
        return uploaderMapper.updateUploaderStatus(id);
    }
}
