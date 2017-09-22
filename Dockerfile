FROM jenkins/jenkins:2.79

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN xargs /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

USER root

#https://get.docker.com/builds/
RUN mkdir -p /tmp/download && \
 curl -L https://get.docker.com/builds/Linux/x86_64/docker-17.05.0-ce.tgz | tar -xz -C /tmp/download && \
 rm -rf /tmp/download/docker/dockerd && \
 mv /tmp/download/docker/docker* /usr/local/bin/ && \
 rm -rf /tmp/download

RUN groupadd docker

RUN usermod -a -G staff,docker jenkins

USER jenkins

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/jre

