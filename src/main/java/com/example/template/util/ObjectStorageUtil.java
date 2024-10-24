package com.example.template.util;

import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorageUtil {

    /**
     * 객체 스토리지에 파일을 업로드하는 메서드
     *
     * @param file 업로드할 파일
     */
    String upload(MultipartFile file);

    /**
     * 객체 스토리지에 파일을 업로드하는 메서드
     *
     * @param file      업로드할 파일
     * @param directory 업로드를 원하는 디렉토리
     */
    String upload(MultipartFile file, String directory);

}
