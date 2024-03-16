FROM openjdk:17-jdk
ADD /FantomShop-0.0.1-SNAPSHOT.jar target/FantomShop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "target/FantomShop-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
