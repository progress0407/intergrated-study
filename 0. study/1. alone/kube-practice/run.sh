#!bin/bash

ka namespace.yml

ka configmap-db.yml && \
ka configmap-was.yml

ka deploy-was.yml && \
ka deploy-db.yml

ka service-conn-was-db.yml
ka service-nodeport.yml

curl $(minikube ip):30000/version

# check
while true;\                                                                                      
do curl $(minikube ip):30000/version; \
sleep 1; \
done;