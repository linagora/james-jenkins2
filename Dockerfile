FROM jenkins/jenkins:2.222.1

USER jenkins

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

COPY jenkins.yaml /usr/share/jenkins/ref/jenkins.yaml
COPY setupWizard.groovy /usr/share/jenkins/ref/init.groovy.d/setupWizard.groovy

COPY init-gatling-job.groovy /usr/share/jenkins/ref/init.groovy.d/init-gatling-job.groovy
COPY gatling-job.groovy /usr/share/jenkins/ref/init.groovy.d/jobs/gatling-job.groovy

COPY init-stress-job.groovy /usr/share/jenkins/ref/init.groovy.d/init-stress-job.groovy
COPY stress-job.groovy /usr/share/jenkins/ref/init.groovy.d/jobs/stress-job.groovy

# Configuration AS Code env variable
ENV CASC_JENKINS_CONFIG=/usr/share/jenkins/ref/
