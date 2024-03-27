# ビルド用ステージ
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# プロジェクトの依存関係をコピー
COPY backend/pom.xml /app

# 依存関係をインストール
RUN mvn dependency:go-offline

# ソースコードをコピー
COPY backend/src /app/src

# アプリケーションのパッケージング
RUN mvn package -DskipTests

# 実行用ステージ
FROM openjdk:17-jdk-slim
WORKDIR /app

# ビルドステージから成果物をコピー
COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
