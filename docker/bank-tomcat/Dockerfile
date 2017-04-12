FROM tomcat:latest

#RUN apk add --no-cache curl tar bash

RUN apt-get update && \
        apt-get install -y \
                git \
                maven \
                openjdk-8-jdk

#RUN git clone https://github.com/wmifsud/bank-system

#RUN cd bank-system/bank-data && mvn clean install -DskipTests