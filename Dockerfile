FROM amazoncorretto:21.0.4-alpine3.20
COPY target/bmi-calculator-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java","-jar","bmi-calculator-0.0.1-SNAPSHOT.jar" ]