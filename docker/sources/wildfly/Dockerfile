FROM quay.io/wildfly/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#007 --silent

# #Add the PostgreSQL driver
USER jboss

RUN mkdir -p /opt/jboss/wildfly/modules/org/postgresql/main/
COPY ./module.xml /opt/jboss/wildfly/modules/org/postgresql/main/
COPY ./postgresql-42.5.0.jar /opt/jboss/wildfly/modules/org/postgresql/main/

# #Configure the new Datasource whose JNDI is java:jboss/datasources/Postgres_DS
COPY ./standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml

EXPOSE 9990
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
