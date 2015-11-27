# Oracle NoSQL Community Edition

FROM java:7-jre

ENV DOWNLOAD_SITE  download.oracle.com/otn-pub/otn_software/nosql-database
ENV NOSQL_VERSION kv-ce-3.4.7
ENV DOWNLOAD_PATH ${DOWNLOAD_SITE}/${NOSQL_VERSION}.zip
RUN wget ${DOWNLOAD_PATH}
RUN unzip -q ${NOSQL_VERSION}.zip
RUN rm ${NOSQL_VERSION}.zip

EXPOSE 5000
