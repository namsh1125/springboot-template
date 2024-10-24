# springboot-template

## 소개

본 프로젝트는 Spring Boot를 기반으로 개발된 프로젝트로,

반복되는 개발 작업을 줄이고, 개발 생산성을 높이기 위한 목적으로 제작되었습니다.

## 제공하는 기능

1. 객체 스토리지에 파일 업로드 (S3)
2. (추가 예정) 소셜로그인

## 시작하기

1. 프로젝트를 클론합니다.
    
```bash
git clone https://github.com/namsh1125/springboot-template.git
```

2. `secret.yml` 파일을 생성합니다.

```bash
cd springboot-template
cp src/main/resources/secret.yml.example src/main/resources/secret.yml
```

3. `secret.yml` 파일을 수정합니다.

## 참고

S3 객체 스토리지에 파일을 업로드할 때 `AmazonS3Exception 400` 에러가 발생한다면,

[링크](https://velog.io/@vector13/aws-s3-AmazonS3Exception-400-%ED%95%B4%EA%B2%B0)를 참고하여 S3의 ACL 권한을 확인해주세요.