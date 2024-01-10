# 생활코딩 Docker Tutorial

## Docker Build

### 컨테이너 생성 & 실행

```bash
docker run --name {생성할 컨테이너 이름} -it {이미지 이름}
docker run --name web-server -it ubuntu:20.04
```

### 현재 도커 이미지를 업데이트 (새로운 이름으로)

```bash
docker commit {현재 이미지} {바꿀 이미지 이름}
docker commit web-server web-server-commit
```

## Dockfile

```
WORKDIR /var/www/html
```

해당 경로를 만들고 이동 -> 그 이후 명령어는 모두 저 경로에서 이루어짐

```bash
mkdir -p 경로 # 하위 경로까지 모두 생성
cd 경로
```

### docker build

```bash
docker build -t {새로 생성할 이미지 이름} .;
docker run -p 8888:8000 --name {생성할 컨테이너 이름} {이미지 이름};
```

```bash
docker build -t web-server-build .;
docker run -p 8888:8000 --name web-server-ct web-server-build;
```

## Docker Compose

```yml
services:
  db: # 컨테이너 이름
    image: mysql:5.7
    volumes: # 볼륨 마운트
      - ./db_data:/var/lib/mysql # 호스트 : 컨테이너 내부
    environment:
      MYSQL_ROOT_PASSWORD: 1234
      ...
  
  app:
    depends_on: # 선행으로 set-up되어야 할 컨테이너
      - db
    image: wordpress:latest
    volumes:
      - ./app_data:/var/www/html
    ports:
      - 8080:80
    restart: always
    environment:
      WORDPRESS_DB_HOST: db:3306
      WORDPRESS_DB_NAME: wordpress
      ...

```