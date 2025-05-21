#!/bin/bash

docker build . -t ajcm/springboot-cognito:latest
docker tag ajcm/springboot-cognito:latest 423623860374.dkr.ecr.eu-west-1.amazonaws.com/springboot-cognito:latest
docker push 423623860374.dkr.ecr.eu-west-1.amazonaws.com/springboot-cognito:latest
