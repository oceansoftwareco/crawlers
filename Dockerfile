FROM tomcat:10

COPY ./target/crawlers.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]