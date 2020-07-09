## Build Stage
FROM gradle:6.4-jdk11 as builder

WORKDIR /code
COPY . .

ARG NEXUS_USERNAME
ARG NEXUS_PASSWORD

ENV NEXUS_USERNAME=${NEXUS_USERNAME} \
    NEXUS_PASSWORD=${NEXUS_PASSWORD}

RUN gradle assemble

FROM openjdk:11-jre

ENV APP_HOME="/opt/mp" \
    LANG="en_US.utf8" \
    JAR_OPTS="--spring.profiles.active=prod"

RUN wget -q https://storage.googleapis.com/devops-store/container-tools/gosu-amd64 -O /usr/local/bin/gosu && \
    chmod +x /usr/local/bin/gosu && \
    useradd -U -m -d ${APP_HOME} -r -s /bin/bash mpuser

COPY --from=builder --chown=mpuser:mpuser /code/build/libs/*.jar ${APP_HOME}/app.jar

EXPOSE 8080/tcp

WORKDIR ${APP_HOME}

CMD ["gosu", "mpuser", "bash", "-c", "java -jar ${APP_HOME}/app.jar ${JAR_OPTS}"]
# CMD ["java", "-jar", "/home/middleplatform/ayalaasia-business-platform/lib/aylaasia-business-platform-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
