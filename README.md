# 🗓️ 일정 관리 API (Schedule Management API)

> Spring Boot 기반으로 구현한 일정 관리 RESTful API 프로젝트입니다.  
> 사용자는 일정을 생성, 조회, 수정, 삭제할 수 있으며, 각 일정은 비밀번호를 통해 보호됩니다.

---

## 🧱 프로젝트 개요

이 프로젝트는 **CRUD 기능**을 중심으로 설계되었으며, 다음과 같은 기능을 포함합니다.

| 기능 구분 | 기능 설명 |
|:--|:--|
| Lv 1 | 일정 생성 (Create) |
| Lv 2 | 일정 조회 (Read) |
| Lv 3 | 일정 수정 (Update) |
| Lv 4 | 일정 삭제 (Delete) |


---

## 🧾 요구사항 요약

### ✅ Lv 1. 일정 생성
- 일정 생성 시 필수 데이터:
  - `일정 제목(title)`, `일정 내용(content)`, `작성자명(author)`, `비밀번호(password)`, `작성일(createdAt)`, `수정일(modifiedAt)`
- `작성일`과 `수정일`은 **JPA Auditing**을 통해 자동으로 저장
- 최초 생성 시 `작성일`과 `수정일`은 동일
- `비밀번호`는 응답에서 제외

---

### ✅ Lv 2. 일정 조회
- **전체 일정 조회**
  - `작성자명(author)` 기준으로 전체 조회 가능 (조건 선택적)
  - `수정일` 기준 내림차순 정렬
  - `비밀번호`는 응답에서 제외
- **단건 일정 조회**
  - 일정의 고유 식별자 `ID`로 조회
  - `비밀번호`는 응답에서 제외

---

### ✅ Lv 3. 일정 수정
- 수정 가능한 필드: `일정 제목(title)`, `작성자명(author)`
- 수정 시 비밀번호를 함께 전달하여 검증
- `작성일`은 변경 불가, `수정일`은 자동 갱신
- 응답에서 `비밀번호`는 제외

---

### ✅ Lv 4. 일정 삭제
- 선택한 일정 삭제 가능
- 삭제 시 비밀번호를 함께 전달하여 검증

---

### 1️⃣ 일정 생성 (Create)

| 항목 | 내용 |
|:--|:--|
| **URL** | `POST /api/schedules` |
| **Request Body (JSON)** | ```json { "title": "회의 준비", "content": "회의자료 준비하기", "nickname": "이상무", "password": "1234" } ``` |
| **Response (201 Created)** | ```json { "id": 1, "title": "회의 준비", "content": "회의자료 준비하기", "nickname": "이상무", "createdAt": "2025-11-06T12:00:00", "modifiedAt": "2025-11-06T12:00:00" } ``` |

---

### 2️⃣ 전체 일정 조회 (Read All)

| 항목 | 내용 |
|:--|:--|
| **URL** | `GET /api/schedules` |
| **Query Parameter** | `author` (optional) |
| **Example** | `/api/schedules?author=이상무` |
| **Response (200 OK)** | ```json [ { "id": 1, "title": "회의 준비", "content": "회의자료 준비하기", "nickname": "이상무", "modifiedAt": "2025-11-06T12:00:00" }, { "id": 2, "title": "운동", "content": "헬스장 가기", "author": "이상무", "modifiedAt": "2025-11-06T10:30:00" } ] ``` |

---

### 3️⃣ 단건 일정 조회 (Read One)

| 항목 | 내용 |
|:--|:--|
| **URL** | `GET /api/schedules/{id}` |
| **Response (200 OK)** | ```json { "id": 1, "title": "회의 준비", "content": "회의자료 준비하기", "nickname": "이상무", "createdAt": "2025-11-06T12:00:00", "modifiedAt": "2025-11-06T12:00:00" } ``` |

---

### 4️⃣ 일정 수정 (Update)

| 항목 | 내용 |
|:--|:--|
| **URL** | `PUT /api/schedules/{id}` |
| **Request Body (JSON)** | ```json { "title": "회의 준비 완료", "nickname": "이상무", "password": "1234" } ``` |
| **Response (200 OK)** | ```json { "id": 1, "title": "회의 준비 완료", "content": "회의자료 준비하기", "nickname": "이상무", "createdAt": "2025-11-06T12:00:00", "modifiedAt": "2025-11-06T13:00:00" } ``` |

---

### 5️⃣ 일정 삭제 (Delete)

| 항목 | 내용 |
|:--|:--|
| **URL** | `DELETE /api/schedules/{id}` |
| **Request Body (JSON)** | ```json { "title": "회의 준비 완료", "nickname": "이상무", "password": "1234" } ``` |
| **Response (204 No Content)** | ``` ``` |

---

## ERD 
<img width="458" height="234" alt="image" src="https://github.com/user-attachments/assets/63a6cf7b-0401-4f79-bf61-2130b532fde0" />
