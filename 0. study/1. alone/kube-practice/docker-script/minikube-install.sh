apt-get udpate
apt install -y curl

curl -fsSL https://get.docker.com -o get-docker.sh && \
sh get-docker.sh

curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 && \
install minikube-linux-amd64 /usr/local/bin/minikube
