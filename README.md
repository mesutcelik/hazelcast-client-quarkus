
# RUNNING JAR 

> $ mvn clean package   
> $ java -jar target/getting-started-1.0-SNAPSHOT-runner.jar   
 
> $ curl "localhost:8080/map/put?key=key_1&value=value_1"   
> $ curl "localhost:8080/map/get?key=key_1"   



# BUILDING NATIVE IMAGE
See prerequisites here: https://quarkus.io/guides/building-native-image-guide    
Docker must be running

--------

> $ mvn package -Pnative -Dnative-image.docker-build=true

------------------------------------

# Dockerfile content

```
FROM registry.access.redhat.com/ubi8/ubi-minimal
WORKDIR /work/
COPY target/*-runner /work/application
RUN chmod 775 /work
EXPOSE 8080
CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
```


# Run image
> $ docker build -f src/main/docker/Dockerfile.native -t quarkus-quickstart/getting-started .   
> $ docker run -i -p 8080:8080 quarkus-quickstart/getting-started
