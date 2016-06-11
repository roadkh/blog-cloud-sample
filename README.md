# blog-cloud-sample

## Docker, Dockder-compose 를 이용

기존 Blog_03 브랜치를 Docker와 Docker Compose 를 이용하도록 수정.

기본 서비스 이외에 RabbitMQ 도 Docker로 시작되도록 작업이 되어있음.

혹시 로컬에 RabbitMQ 가 돌고 있을 경우에는 해당 Rabbit과 port 충돌이 있을 수 있으니 주의할 것.


**1. Git Clone**

```
git clone https://github.com/roadkh/blog-cloud-sample.git
git checkout blog_cloud_docker
```

**2. 사전 준비사항**
- docker 설치
	- Mac OS X : https://docs.docker.com/engine/installation/mac/
	- Windows : https://docs.docker.com/engine/installation/windows/
	- Ubuntu : https://docs.docker.com/engine/installation/linux/ubuntulinux/
- docker compose 설치 : https://docs.docker.com/compose/install/ 

**3. 개발 및 테스트 환경**
- Ubuntu 14.04 LTS
- IDEA 2016.1.3
- Gradle 2.10
- Oracle JDK 1.8.0_65


**4. 프로젝트 빌드하는 법**

```
cd {Project Base Dir} 
./gradlew clean build
```

**5. docker compose 를 이용한 실행**

```
cd {Project Base Dir}
docker-compose build
docker-compose up -d # backgroud 로 실행
or
docker-compose up    # foregroud 로 실행
```

**6. 각종 URL(localhost기준)**

- Eureka 확인 : http://localhost:8761/ 또는 http://localhost:8762/
- Product List : http://localhost:9000/composite/product/
- Product : http://localhost:9000/composite/product/{product id}
- Hystrix dashboard : http://localhost:7979/hystrix
- Turbine 의 확인 : Hystrix dashboard input 에 http://turbine:8989/ 를 넣고 Monitor Stream 클릭. (단, 최소 한번 이상 API 를 호출한 후에 해야만 정상적인 데이터가 나옴)
