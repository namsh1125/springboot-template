package com.example.template.service;

import com.example.template.util.ObjectStorageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileService {

    private final ObjectStorageUtil objectStorageUtil;

    public String upload(MultipartFile file) {
        return objectStorageUtil.upload(file);
    }
}
