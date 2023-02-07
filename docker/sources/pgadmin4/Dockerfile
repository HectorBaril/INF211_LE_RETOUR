FROM dpage/pgadmin4:6.18

#USER pgadmin
#RUN mkdir -p /var/lib/pgadmin/storage/pguser@admin.com
#COPY ./pgpass /var/lib/pgadmin/storage/pguser@admin.com/pgpass
#COPY ./servers.json /pgadmin4/servers.json

#VOLUME /var/lib/pgadmin/storage/pguser@admin.com/
#USER root
#RUN chown -R 5050:root /var/lib/pgadmin/storage
#USER pgadmin
#COPY ./pgpass /pgadmin4/pgpass
#RUN chown -R pgadmin:root /var/lib/pgadmin/*
#ENTRYPOINT ["/entrypoint.sh"]

USER pgadmin
RUN mkdir -p  /var/lib/pgadmin/storage/pguser_admin.com
COPY ./pgpass /var/lib/pgadmin/storage/pguser_admin.com/
USER root
RUN chown 5050 /var/lib/pgadmin/storage
#RUN chmo	d 0600 /var/lib/pgadmin/storage/pguser_admin.com/pgpass
USER pgadmin
VOLUME /var/lib/pgadmin/storage/pguser_admin.com
ENTRYPOINT ["/entrypoint.sh"]
