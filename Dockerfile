FROM jenkins/jenkins:2.168

USER jenkins

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

COPY jenkins.yaml /usr/share/jenkins/ref/jenkins.yaml
COPY setupWizard.groovy /usr/share/jenkins/ref/init.groovy.d/setupWizard.groovy

# Configuration AS Code env variable
ENV CASC_JENKINS_CONFIG=/usr/share/jenkins/ref/
