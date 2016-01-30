# blog-cloud-sample

## Blog 1

Spring-cloud 를 이용한 Configuration Server 와 Eureka Server　구성

**1. Git Clone**

```
git clone https://github.com/roadkh/blog-cloud-sample.git
git checkout blog_01
```

**2. 개발 및 테스트 환경**
- Ubuntu 14.04 LTS
- IDEA 15
- Gradle 2.10
- Oracle JDK 1.8.0_65

**3. 프로젝트 빌드하는 법**

```
cd {Project Base Dir} 
./gradlew build
```

**4. Discovery Server와 Configuration Server의 실행**

세개의 Terminal 을 띄운후에 하는 것이 편함.

```
## Terminal 1 (Discovery peer1)
cd {Projcet Base Dir}/server/discovery/build/libs
cp server-discovery.jar server-discovery-peer1.jar
cp server-discovery.jar server-discovery-peer2.jar

java -jar -Dspring.profiles.active=peer1 server-discovery-peer1.jar

## Terminal 2 (Discovery peer2)
java -jar -Dspring.profiles.active=peer2 server-discovery-peer2.jar

## Terminal 3 (Configuration)
cd {Project Base Dir}/server/configuration/build/libs
java -jar server-configuration.jar
```

**5. 각 API의 실행**

```
## Terminal ４ (Product)
cd {Project Base Dir}/api/product/build/libs
java -jar api-product.jar

## Terminal 5 (Recommendation)
cd {Project Base Dir}/api/recommendation/build/libs
java -jar api-recommendation.jar

## Terminal 6 (Review)
cd {Project Base Dir}/api/review/build/libs
java -jar api-review.jar
```

**6. Composite API의 실행**

```
## Terminal 6 (Composite)
cd {Project Base Dir}/api/composite/build/libs
java -jar api-composite.jar
```

**7. Edge Server 의 실행**

```
## Terminal 7 (Edge)
cd {Project Base Dir}/server/edge/build/libs
java -jar server-edge.jar
```
