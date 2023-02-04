#!/usr/bin/bash
#---------------Build process------------------
#Crate a build container
export DOCKER_BUILDKIT=1
docker build -t petclinic/ubuntu .
docker network create clinic
#Create a DataBase container

docker stop db
docker rmi -f petclinic/db
cd ../DB
docker build -t petclinic/db .

#Create a Web
docker stop web
docker rmi -f petclinic/web
cd ../WebUi
docker build -t petclinic/web .

#Create a Print
docker stop print
docker rmi -f petclinic/print
cd ../Print
docker build -t petclinic/print .

#Create a AdminPanel
docker stop admpanel
docker rmi -f petclinic/admpanel
cd ../AdmPanel
docker build -t petclinic/admpanel .

docker run -d --rm  --name db --network clinic -p 3306:3306 petclinic/db
sleep 20
docker run -d --rm --name web --network clinic -p 8080:8080 petclinic/web
sleep 10
docker run -d --rm --name print --network clinic -p 8081:8081 petclinic/print
docker run -i -d --rm --name admpanel --network clinic -p 8083:8083 petclinic/admpanel
