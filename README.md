# eventstream
Event Stream

launch
http://127.0.0.1:8081/event/

API
http://127.0.0.1:8081/event/health/
http://127.0.0.1:8081/event/events/

swagger
http://127.0.0.1:8081/event/swagger-ui.html#/health-api-controller/health

Override properties
https://docs-stage.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config

Running the app

First time run with ddlgen on

java -jar target/field-0.0.1-SNAPSHOT.jar --spring.datasource.url=jdbc:h2:file:/Users/michaelobrien/ised/field --spring.jpa.hibernate.ddl-auto=create

Populate some records

curl -X GET "http://127.0.0.1:8081/event/populate" -H "accept: */*"

Add a record using curl

curl -X POST "http://127.0.0.1:8081/event/createEvent" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"category\": \"ca2\", \"id\": 13, \"key\": \"key\", \"label\": \"label1\", \"state\": \"state1\", \"timestamp\": 22, \"type\": \"type1\", \"value\": \"value1\"}"

rerun without create on to keep the DB as-is

java -jar target/field-0.0.1-SNAPSHOT.jar --spring.datasource.url=jdbc:h2:file:/Users/michaelobrien/ised/field --spring.jpa.hibernate.ddl-auto=create

