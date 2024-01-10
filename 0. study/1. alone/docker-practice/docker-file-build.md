# 생활코딩 Docker Tutorial

### docker 이미지 컨테이너로 생성 후 실행 (없다면 이름 부여)

```bash
docker run --name web-server -it ubuntu:20.04
```

### 현재 도커 이미지를 업데이트 (새로운 이름으로)

```bash
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
docker build -t web-server-build .;
docker run -p 8888:8000 --name web-server-ct web-server-build;
```
