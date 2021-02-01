FROM gradle:jdk8
COPY . /usr/src/RestMicroService
WORKDIR /usr/src/RestMicroService
RUN gradle clean build --no-daemon
CMD [ "java","-jar","build/libs/RestMicroService-0.0.1-SNAPSHOT.jar" ]