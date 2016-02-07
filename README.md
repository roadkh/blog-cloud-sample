# blog-cloud-sample

## Blog 3

Spring-cloud 를 이용한 Configuration Server와 Eureka Server 를 이용한 실제 사용예제.


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

==Configuration Server를 실행한 후에 Configuration Server가 완전히 구동된 것을 확인하고 5번부터 진행필요.==


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

**8. Rabbit Server 실행**

==필요사항으로 각자 Rabbit Server를 준비하여 실행 필요.==


**9. Hystrix-dashboard 실행**

```
## Terminal 8 (Hystrix-dashboard)
cd {Project Base Dir}/support/hystrix-dashboard/build/libs
java -jar support-hystrix-dashboard.jar
```

**10. Turbin serer 실행**

```
## Terminal 9 (Turbine)
cd {Project Base Dir}/support/turbine/build/libs
java -jar support-turbine.jar
```

**11. 각종 URL(localhost기준)**

- Eureka 확인 : http://localhost:8761/ 또는 http://localhost:8762/
- Product List : http://localhost:9000/composite/product/
- Product : http://localhost:9000/composite/product/{product id}
- Hystrix dashboard : http://localhost:7979/hystrix
- Turbine 의 확인 : Hystrix dashboard input 에 http://localhost:8989/ 를 넣고 Monitor Stream 클릭. (단, 최소 한번 이상 API 를 호출한 후에 해야만 정상적인 데이터가 나옴)