# GraalVM을 기반 이미지로 사용
FROM ghcr.io/graalvm/graalvm-community:21

# 작업 디렉토리 설정
WORKDIR /app

# 소스 코드와 Gradle 래퍼 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Gradle 래퍼에 실행 권한 부여
RUN chmod +x ./gradlew

# 애플리케이션 빌드
RUN ./gradlew clean build

RUN mv build/libs/*.jar /app/app.jar

# 실행할 JAR 파일 지정
# 여기서는 단일 JAR 파일을 가정하고 있지만, 여러 파일이 있는 경우
# 실행할 특정 파일을 지정해야 합니다.
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app/app.jar"]