FROM zenika/alpine-maven
ADD main/docker src
WORKDIR /src
RUN mvn install

#RUN mvn install
#RUN chmod 777 -Rf /usr/local/dockerize/
#RUN cd /usr/local/dockerize/estudo/ponto-inteligente
#RUN mvn install
#ADD /target/ponto-inteligente-0.0.1-SNAPSHOT.jar /usr/local/dockerize/
#ADD run.sh run.sh
#RUN chmod +x run.sh
#CMD ./run.sh