FROM postgres:9.6

RUN apt-get update 
RUN  apt-get clean && \
     rm -rf /var/cache/apt/* /var/lib/apt/lists/*

ENTRYPOINT ["/docker-entrypoint.sh"]

ADD bank.sql /docker-entrypoint-initdb.d

EXPOSE 5432
CMD ["postgres"]
