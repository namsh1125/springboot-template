package com.example.template.util;

import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorageUtil {

    /**
     * 객체 스토리지에 파일을 업로드하는 메서드
     */
    String upload(MultipartFile file);

}
