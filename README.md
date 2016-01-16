# blog-cloud-sample

## Blog 1

**1. 프로젝트 빌드하는 법**

```
cd {Project Base Dir} 
./gradlew build
```

**2. 실행하는 법**
세개의 Terminal 을 띄운후에 하는 것이 편함.
```
##Terminal 1
cd {Projcet Base Dir}/server/discovery/build/libs
cp server-discovery.jar server-discovery-peer1.jar
cp server-discovery.jar server-discovery-peer2.jar

java -jar -Dspring.profiles.active=peer1 server-discovery-peer1.jar

## Terminal 2
java -jar -Dspring.profiles.active=peer2 server-discovery-peer2.jar

## Terminal 3
cd {Project Base Dir}/server/configuration/build/libs
java -jar server-configuration.jar
```

