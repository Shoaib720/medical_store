FROM bitnami/wildfly:27.0.1
USER root
RUN apt update && apt install wget unzip -y
RUN wget https://github.com/aws/aws-xray-java-agent/releases/latest/download/xray-agent.zip
RUN unzip xray-agent.zip -d /opt
COPY target/medical_store.war /app
RUN echo "JAVA_OPTS=\"$JAVA_OPTS -Djboss.modules.system.pkgs=org.jboss.byteman,com.manageengine -javaagent:/opt/disco/disco-java-agent.jar=pluginPath=/opt/disco/disco-plugins\"" >> /opt/bitnami/wildfly/bin/standalone.conf
USER 1001

# FROM tomcat:10.0.8
# COPY target/medical_store.war /usr/local/tomcat/webapps/