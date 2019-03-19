FROM jenkins/jenkins:2.168

USER jenkins

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY jenkins.yaml /usr/share/jenkins/ref/jenkins.yaml

# Configuration AS Code env variable
ENV CASC_JENKINS_CONFIG=/usr/share/jenkins/ref/

RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

