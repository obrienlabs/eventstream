#!/bin/bash
# http://wiki.obrienlabs.cloud/display/DEV/AWS+ECR+E2E+Architecture
# source from http://jira.obrienlabs.cloud/browse/ECS-1
# https://github.com/obrienlabs/refarch
# Michael O'Brien

# variables
CONTAINER_IMAGE=eventstream
PORT_IN=8080
PORT_OUT=8888
RELEASE_ID=0.0.1
DOCKERFILE=DockerFile

# static templates
BUILD_ID=10001
BUILD_DIR=builds
mkdir ../../$BUILD_DIR
TARGET_DIR=../../$BUILD_DIR/$BUILD_ID
mkdir $TARGET_DIR

cd ../../
#mvn clean install -U -DskipTests=true
cd src/docker
cp ../../target/*.jar $TARGET_DIR
cp $DOCKERFILE $TARGET_DIR
cp startService.sh $TARGET_DIR
cd $TARGET_DIR
docker build --rm=true --no-cache --build-arg build-id=$BUILD_ID -t obrienlabs/$CONTAINER_IMAGE -f $DOCKERFILE .
#docker tag $CONTAINER_IMAGE:latest $CONTAINER_IMAGE:latest
docker tag obrienlabs/$CONTAINER_IMAGE obrienlabs/$CONTAINER_IMAGE:$RELEASE_ID
docker tag obrienlabs/$CONTAINER_IMAGE obrienlabs/$CONTAINER_IMAGE:latest
# dockerhub
docker push obrienlabs/$CONTAINER_IMAGE:$RELEASE_ID
docker push obrienlabs/$CONTAINER_IMAGE:latest
# locally
docker stop $CONTAINER_IMAGE
docker rm $CONTAINER_IMAGE
echo "starting: $CONTAINER_IMAGE"
docker run --name $CONTAINER_IMAGE \
    -d -p $PORT_OUT:$PORT_IN \
    -e os.environment.configuration.dir=/ \
    -e os.environment.ecosystem=sbx \
    obrienlabs/$CONTAINER_IMAGE:$RELEASE_ID

# Health check


cd ../../src/docker

