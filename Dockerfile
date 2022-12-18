FROM bitnami/wildfly:27.0.1
COPY target/medical_store.war /app

# FROM tomcat:10.0.8
# COPY target/medical_store.war /usr/local/tomcat/webapps/