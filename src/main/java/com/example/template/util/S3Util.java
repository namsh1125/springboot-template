package com.example.template.util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class S3Util implements ObjectStorageUtil {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 s3;

    @Override
    public String upload(MultipartFile file) {
        // 입력받은 파일이 비어있는 지 확인
        if (file.isEmpty() || Objects.isNull(file.getOriginalFilename())) {
            throw new IllegalArgumentException("File is empty");
        }

        // 파일 이름 변경 (중복된 파일 이름을 방지하기 위해)
        String originalFilename = file.getOriginalFilename();
        String newFilename = System.currentTimeMillis() + "_" + originalFilename; // FIXME: 요구사항에 맞게 파일 이름 변경

        // 파일 메타데이터 설정
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());

        // 파일 업로드
        try {
            // S3에 업로드 요청할 때 사용할 객체 생성
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, newFilename, file.getInputStream(), objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead); // FIXME: 요구사항에 맞게 ACL 설정

            // S3에 파일 업로드
            s3.putObject(putObjectRequest);

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Failed to upload file");
        }

        // 업로드한 파일의 URL 반환
        return s3.getUrl(bucket, newFilename).toString();
    }
}
