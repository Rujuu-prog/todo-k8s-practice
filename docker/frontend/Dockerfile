FROM node:21-alpine as build-stage

WORKDIR /app

# キャッシュ用
COPY ./package*.json /app
COPY ./yarn.lock /app

# 依存関係のインストール
RUN yarn install

# フロントエンドのファイルをコンテナにコピー
COPY ./ /app

EXPOSE 5173

CMD ["yarn", "dev", "--host"]
