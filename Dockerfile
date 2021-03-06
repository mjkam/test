FROM java

RUN mkdir /test
RUN mkdir -p /tmp
WORKDIR /test
COPY . .
RUN ./gradlew build -x test


CMD ["java", "-jar", "./build/libs/demo-0.0.1-SNAPSHOT.war"]
