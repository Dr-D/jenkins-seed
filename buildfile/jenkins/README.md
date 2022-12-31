#Jenkins with seed job
Jenkins setup using groovy scripts in init.groovy.d directory, example of using this: 
https://github.com/cinqict/jenkins-init-groovy

Plugins are added via plugins.sh file, run from dockerfile when the image updated.

##Create Jenkins image
In the buildfile directory run:
docker build -t myjenkins:2.375.1 .

Ubuntu 20.04 seems to need to run with build kit
DOCKER_BUILDKIT=1 docker build -t myjenkins:2.375.1 .

##Create Jenkins network
docker network create jenkins

##Run Jenkins docker container
When testing the image it is easier to run without a volume

```shell
docker run --name jenkins --restart=on-failure --detach \
--network jenkins --env DOCKER_HOST=tcp://docker:2376 \
--publish 8080:8080 \
--mount type=bind,source="$(pwd)",target=/opt \
myjenkins:2.375.1
```

If you run with the volume attached, if you need to make any changes you will have to delete the volume for changes to 
take effect, but will lose the build info.
```shell
docker run --name jenkins --restart=on-failure --detach \
--network jenkins --env DOCKER_HOST=tcp://docker:2376 \
--publish 8080:8080 --publish 50000:50000 \
--mount type=bind,source="$(pwd)",target=/opt \
--volume jenkins-data:/var/jenkins_home \
myjenkins:2.375.1
```
Jenkins should be available on localhost:8080.

