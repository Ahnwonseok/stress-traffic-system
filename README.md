![스크린샷 2023-03-14 오후 3 44 33](https://user-images.githubusercontent.com/22368351/224917663-c77598dc-a738-4709-aa11-dd216232b666.png)
### 1000만건의 상품데이터,200만 유저데이터로 대규모 트래픽 상황 속에서 서버지키기

***

# 💡프로젝트&nbsp;기능

<img width="1210" alt="스크린샷 2023-03-14 오후 4 20 28" src="https://user-images.githubusercontent.com/22368351/224924964-38473336-c041-49c3-8126-0923a8bb46bd.png">

💠 검색 기능
```
- 상품데이터 1000만개
- 검색 4가지 모드
    - Like → 가장 간단하고 기초적인 로직으로 밑에 나올 방법들과 비교차원에서 구현한 모드
    - full text index → db로 구현할 수 있는 대규모 데이터를 다룰 수 있는 방법이라 판단하였고, redis와의 명확한 차이를 알아보기 위함.
    - redis read through 방식 → 자주 쓰이는 데이터를 정하고 redis에 미리 올려두는 방식으로 db의 부하를 redis의 사용으로 분산
    - redis look aside 방식 → read through와 다른 캐싱 전략방법을 도입해 둘의 차이를 명확히 알아보고자 함.
```
💠 주문 기능
```
- 단시간에 많은 고객이 주문요청을 해도 데이터 정합성을 유지하기 위한 방안 마련
    - pessimistic lock
    - redisson
```
💠 실시간
```
- redis를  활용한 단기간 빠르게 증가하는 트래픽과 이벤트를 처리하는 방안 마련
```
***

# 💡기술스택

|분류|기술스택|
|------|---|
|Language|<img src="https://img.shields.io/badge/JAVA-EE4353?style=for-the-badge&logo=&logoColor=white">|
|Framework|<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">|
|Build Tool|<img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white">|
|DB|<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">|
|Server|<img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=for-the-badge&logo=Amazon EC2&logoColor=white"><img src="https://img.shields.io/badge/AWS MSK-FF9900?style=for-the-badge&logo=&logoColor=white"><img src="https://img.shields.io/badge/AWS Elasticache-FF9900?style=for-the-badge&logo=&logoColor=white">|
|CI/CD|<img src="https://img.shields.io/badge/GitHub Actions-2088FF?style=for-the-badge&logo=GitHub Actions&logoColor=white">|
|Caching|<img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=Redis&logoColor=white">|

***

# 💡아키텍처

![스크린샷 2023-03-12 오후 7 04 37](https://user-images.githubusercontent.com/22368351/225811735-96f7d7ff-b427-48a1-8d99-c6a3074da08e.png)

***

# 💡테스트 커버리지
![image (1)](https://user-images.githubusercontent.com/95980876/224950652-43b2cc17-e628-487b-82de-fa63c0de9072.png)

# 💡시연 영상
[![시연 영상](https://img.youtube.com/vi/7YHfGiI6sjc/0.jpg)](https://youtu.be/7YHfGiI6sjc)

# 💡노션 페이지
[대규모 트래픽 연구소](https://www.notion.so/e5f437969114433ea90293fb8c2dadd1)
