# mss-product

`mss-product`는 MUSINSA 약자(`mss`)와 상품(`product`) 도메인을 결합한 Java/Spring Boot 기반 서비스 과제용 프로젝트입니다.

---

## 구현 범위

1. **카테고리별 최저가 조회 API**

    * 8개 카테고리별 최저가 브랜드 및 가격 조회
    * 총액 계산 및 응답
2. **단일 브랜드 전체 구매 시 총액 최저가 조회 API**

    * 모든 카테고리 특정 브랜드 구매 시 저렴한 브랜드·카테고리별 가격 조회
    * 총액 계산 및 응답
3. **카테고리별 최저·최고가 조회 API**

    * 카테고리명으로 최저가 브랜드 리스트 및 최고가 브랜드 리스트와 가격 조회
4. **브랜드 및 상품 CRUD API**

    * 브랜드 등록/수정/삭제
    * 상품 추가/수정/삭제

---

### 설계 키 포인트

* **ID-only 참조**: Entity 간 연관관계 대신 각 entity는 식별자(`brandId`)만 보유
* **도메인 간 간접 참조**: Reader 인터페이스 + DTO 패턴으로 서비스 간 의존성 통제
* **조인 조회**: QueryDSL을 활용하여 projection DTO로 결과 반환
* **캐싱 전략**: 상품 조회 API 성능 최적화를 위해 Spring Cache(Ehcache) 적용
* **카테고리** : enum으로 정의하여 관리합니다.  

#### 패키지 구조
```
com.jar100.mssproduct
├── controller        # REST API Layer
├── domain
│   ├── brand
│   ├── product
│   └── price
├── common            # 예외, 응답 DTO, 유틸
├── config            # 설정 (JPA, QueryDSL, H2 등)
└── MssProductApplication.java
```

### 카테고리별 최저가 쿼리 최적화
- 운영 가정: 브랜드 10,000개 × 상품 50,000건/브랜드 = 약 500백만 건의 상품 데이터가 있다고 가정
  - 실제 [MUSINSA 브랜드는 2024 기준 8500개](https://newsroom.musinsa.com/newsroom-menu/2025-0430-01)
  - 실제 무신사 등록된 아디다스 노출 상품 수는 2,500건 이상   
- 단일 상관 서브쿼리 방식은 전체 테이블(인덱스) 풀 스캔 후 임시 테이블 생성 및 조인이 필요해 비용이 매우 큼
- 대신 **카테고리당 LIMIT 1 × 8회** 방식으로,
   - `(category, price)` 인덱스를 타고 각 카테고리에서 **O(log N)** 범위 스캔 후 첫 번째(최저가) 레코드를 즉시 가져옴
   - 네트워크 왕복 8회는 카테고리 수(8)로 고정된 상수이므로 전체 지연에 미미한 영향
   - 500M건 규모에서도 8회 경량 쿼리를 통해 안정적이고 예측 가능한 성능 보장
위 이유로 `PriceQueryRepositoryImpl#findMinPriceByCategory()`를 서브쿼리 대신 8회 LIMIT 조회 방식으로 구현했습니다.
---

## 코드 빌드 · 테스트 · 실행 방법

### 요구 사항

* JDK 17
* Gradle Wrapper
* IDE(IntelliJ IDEA) 권장

### 1. 로컬 DB 설정

* H2 메모리 모드 사용 (application.yaml 기본 설정)

### 2. 빌드

```bash
./gradlew clean build
```

### 3. 테스트

```bash
./gradlew test
```

### 4. 실행

```bash
# Gradle BootRun
./gradlew bootRun

# JAR 실행
java -jar backend/build/libs/mss-product-0.0.1-SNAPSHOT.jar
```

#### IntelliJ IDEA 실행

1. `mss-product` 폴더를 Gradle 프로젝트로 Import
2. `MssProductApplication.java`의 `main` 메서드를 Run
3. 기본 포트: 8080

* H2 콘솔: [http://localhost:8080/h2-console](http://localhost:8080/h2-console) (JDBC URL: jdbc\:h2\:mem\:testdb)

---

## 기타 추가 정보
todo
---


