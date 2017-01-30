FROM tomcat:7-jre8
MAINTAINER Chih-Wei Lin <Chih.W.Lin@colorado.edu>
ENV PATH ${PATH}:/usr/lib/jvm/java-8-openjdk-amd64/bin
RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
RUN ["rm", "-rf", "/root/.gradle/"]
ADD ./target/ApplicationBuilder-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]