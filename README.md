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

### 설계 포인트

* **ID-only 참조**: Entity 간 연관관계 대신 각 Entity는 식별자(`brandId`)만 보유해서 도메인 간 결합도를 최소화합니다.
* **조인 조회**: QueryDSL을 활용해 Projection DTO로 필요한 필드만 조회하여 메모리 오버헤드를 절감합니다.
* **카테고리 관리**: 카테고리 변경 가능성이 낮다는 판단 하에 Enum으로 관리하여 코드 가독성과 안정성을 확보합니다.
* **Summary Tables**: 대용량 상품 데이터를 효율적으로 집계·조회하기 위해 3개의 요약 테이블을 사용합니다:

    * `brand_category_min_price_summary` - 브랜드×카테고리별 최소가를 저장
    * `category_price_summary`          - 카테고리별 최소·최대가를 저장
    * `brand_total_summary`             - 단일 브랜드 구매 시 총액 최소 브랜드를 저장

  **생성 사유 및 처리 방식**:

    * 운영 가정: 브랜드 10,000개 × 상품 50,000건/브랜드 = 약 5억 건의 상품 데이터

        * 실제 [MUSINSA 브랜드는 2024 기준 8,500개](https://newsroom.musinsa.com/newsroom-menu/2025-0430-01)
        * 실제 무신사 노출된 Adidas 상품 수는 2,500건 이상
    * 매번 실시간 쿼리 불가 → **일 배치**로 요약 테이블 생성 및 저장
    * 상품 생성/수정/삭제 시 **비동기 이벤트**로 해당 요약 테이블 부분 갱신
    * 배치 스케줄러(`@Scheduled`)가 **매시간** 전체 요약 재계산으로 데이터 정합성 확보

#### 패키지 구조
```
com.jar100.mssproduct
├── controller        # REST API Layer
├── domain
│   ├── brand
│   ├── product
│   └── summary
├── common            # 예외, 응답 DTO, 유틸
├── config            # 설정 (JPA, QueryDSL, H2 등)
└── MssProductApplication.java
```
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

## API Reference

### Brand APIs

| Operation           | Method | Path                  | Description                 |
| ------------------- | ------ | --------------------- | --------------------------- |
| Create Brand        | POST   | `/api/v1/brands`      | 브랜드 생성                      |
| Get All Brands      | GET    | `/api/v1/brands`      | 모든 브랜드 목록 조회                |
| Get Brand by ID     | GET    | `/api/v1/brands/{id}` | 단일 브랜드 조회                   |
| Update Brand        | PUT    | `/api/v1/brands/{id}` | 브랜드 정보 수정                   |
| Delete Brand (soft) | DELETE | `/api/v1/brands/{id}` | 브랜드 소프트 삭제 (`deleted=true`) |

#### Example: Create Brand

```bash
curl -X POST http://localhost:8080/api/v1/brands \
  -H "Content-Type: application/json" \
  -d '{"name":"A"}'
```

**Response**

```json
{
  "result": "SUCCESS",
  "data": { "id": 1, "name": "A" }
}
```

### Product APIs

| Operation             | Method | Path                    | Description                |
| --------------------- | ------ | ----------------------- | -------------------------- |
| Create Product        | POST   | `/api/v1/products`      | 상품 생성                      |
| Get Product by ID     | GET    | `/api/v1/products/{id}` | 단일 상품 조회                   |
| Update Product        | PUT    | `/api/v1/products/{id}` | 상품 정보 수정                   |
| Delete Product (soft) | DELETE | `/api/v1/products/{id}` | 상품 소프트 삭제 (`deleted=true`) |

#### Example: Create Product

```bash
curl -X POST http://localhost:8080/api/v1/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "TOP_A",
    "brandId": 1,
    "category": "TOP",
    "price": 11200
  }'
```

**Response**

```json
{
  "result":"SUCCESS",
  "data":{
    "id":101,
    "name":"TOP_A",
    "brandId":1,
    "category":"TOP",
    "price":11200
  }
}
```

### Price APIs

| Operation                            | Method | Path                                         | Description                             |
| ------------------------------------ | ------ | -------------------------------------------- | --------------------------------------- |
| Get Category Lowest Prices           | GET    | `/api/v1/prices/categories/lowest`           | 각 카테고리별 최저 가격 브랜드 및 가격 목록 조회            |
| Get Single Brand Lowest Total        | GET    | `/api/v1/prices/brands/lowest-total`         | 모든 카테고리 상품 구매 시 총액 최소 브랜드 및 카테고리별 가격 조회 |
| Get Category Price Range (min & max) | GET    | `/api/v1/prices/categories/{category}/range` | 지정된 카테고리의 최소·최대 가격 브랜드 및 가격 조회          |

#### Example: Get Category Lowest Prices

```bash
curl http://localhost:8080/api/v1/prices/categories/lowest
```

**Response**

```json
{
  "result":"SUCCESS",
  "data":[
    {"category":"TOP","brand":"C","price":10000},
    {"category":"OUTER","brand":"E","price":5000},
    …
  ]
}
```

---


