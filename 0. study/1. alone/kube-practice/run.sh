#!bin/bash

ka deployment-was.yml

ka deployment-db.yml

ka service-conn-was-db.yml

ka service-nodeport.yml

curl $(minikube ip):30000/version