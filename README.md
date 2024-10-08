# 🍳How2Cook
## 프로젝트 소개 
How2Cook은 사용자들이 요리 레시피를 검색하고, 공유할 수 있는 프로그램입니다. 사용자들은 자유롭게 자신만의 레시피를 작성하여 공유하거나 찾아볼 수 있는 편리한 기능을 이용할 수 있습니다.

### 기능 소개

**1. 주요 기능**
   - 레시피 검색
   - 레시피 등록, 수정, 삭제

**2. 사용자 기능**
   - 회원등록 
   - 회원탈퇴 

## 활용 장비 및 재료  
- Spring boot
- Kotiln
- Intellij
- zulu JDK 17
- Github
- Thymeleaf
- MySQL
- Docker
- Google Cloud Platform
- ERD Cloud

### 프로젝트 구조

**ERD**

![Recipe](https://github.com/user-attachments/assets/11534001-4aa7-4bbf-9f0c-85dc68423b23)

### REST API 명세
**Ingredient API**
1. 재료 목록 조회
요청 : GET /api/ingredients

모든 활성화된 재료를 조회합니다.

응답 : 
```
  {
  "status": "success",
  "data": [
    {
      "id": 1,
      "name": "계란",
      "type": "MEAT",
      "isActive": true
    },
    {
      "id": 2,
      "name": "간장",
      "type": "SEASONINGS",
      "isActive": true
    }
  ]
}
```

2. 재료 상세 조회
요청 : GET /api/ingredients/{id}

- 특정 재료의 상세 정보를 조회합니다.

응답 :
```
{
  "status": "success",
  "data": {
    "id": 1,
    "name": "계란",
    "type": "MEAT",
    "isActive": true
  }
}
```

3. 재료 생성
요청 : POST /api/ingredients

- 새 재료를 생성합니다.

요청 바디 :
```
{
  "name": "새 재료명",
  "type": "GRAINS",
  "isActive": true
}
```

응답 : 
```
{
  "status": "success",
  "data": {
    "id": 4,
    "name": "새 재료명",
    "type": "GRAINS",
    "isActive": true
  }
}
```

4. 재료 수정
요청 : PUT /api/ingredients/{id}
- 특정 재료의 정보를 수정합니다.

요청 바디 :
```
{
  "name": "수정된 재료명",
  "type": "FRUITS",
  "isActive": false
}
```

응답 : 
```
{
  "status": "success",
  "data": {
    "id": 4,
    "name": "수정된 재료명",
    "type": "FRUITS",
    "isActive": false
  }
}
```

5. 재료 삭제
요청 : DELETE /api/ingredients/{id}
- 특정 재료를 삭제합니다.

응답 : 
```
{
  "status": "success",
  "data": {
    "id": 4,
    "name": "수정된 재료명",
    "type": "FRUITS",
    "isActive": false
  }
}
```

**Recipe API**
1. 레시피 목록 조회
요청 : GET /api/recipes
- 모든 활성화된 레시피를 조회합니다.

응답 : 
```
{
  "status": "success",
  "data": [
    {
      "id": 1,
      "name": "간장계란밥",
      "description": "첫번째 자취 요리 레시피",
      "cookingTime": "PT10M",
      "servingSize": 1,
      "method": "간단한 요리법",
      "isActive": true,
      "ingredients": [
        {
          "id": 1,
          "name": "계란",
          "type": "MEAT",
          "isActive": true
        },
        {
          "id": 2,
          "name": "간장",
          "type": "SEASONINGS",
          "isActive": true
        }
      ]
    }
  ]
}
```

2. 레시피 상세 조회
요청 : GET /api/recipes/{id}
- 특정 레시피의 상세 정보를 조회합니다.

응답 : 
```
{
  "status": "success",
  "data": {
    "id": 1,
    "name": "간장계란밥",
    "description": "첫번째 자취 요리 레시피",
    "cookingTime": "PT10M",
    "servingSize": 1,
    "method": "간단한 요리법",
    "isActive": true,
    "ingredients": [
      {
        "id": 1,
        "name": "계란",
        "type": "MEAT",
        "isActive": true
      },
      {
        "id": 2,
        "name": "간장",
        "type": "SEASONINGS",
        "isActive": true
      }
    ]
  }
}
```

3. 레시피 생성
요청 : POST /api/recipes
- 새 레시피를 생성합니다.

요청 바디 :
```
{
  "name": "새 레시피명",
  "description": "레시피 설명",
  "cookingTime": "PT20M",
  "servingSize": 2,
  "method": "레시피 요리 방법",
  "isActive": true,
  "ingredients": [1, 2]
}
```

응답 :
```
{
  "status": "success",
  "data": {
    "id": 2,
    "name": "새 레시피명",
    "description": "레시피 설명",
    "cookingTime": "PT20M",
    "servingSize": 2,
    "method": "레시피 요리 방법",
    "isActive": true,
    "ingredients": [
      {
        "id": 1,
        "name": "계란",
        "type": "MEAT",
        "isActive": true
      },
      {
        "id": 2,
        "name": "간장",
        "type": "SEASONINGS",
        "isActive": true
      }
    ]
  }
}
```

4. 레시피 수정
요청 : PUT /api/recipes/{id}
- 특정 레시피의 정보를 수정합니다.

요청 바디 :
```
{
  "name": "수정된 레시피명",
  "description": "수정된 설명",
  "cookingTime": "PT15M",
  "servingSize": 1,
  "method": "수정된 요리 방법",
  "isActive": false
}
```

응답 : 
```
{
  "status": "success",
  "data": {
    "id": 1,
    "name": "수정된 레시피명",
    "description": "수정된 설명",
    "cookingTime": "PT15M",
    "servingSize": 1,
    "method": "수정된 요리 방법",
    "isActive": false
  }
}
```

5. 레시피 삭제
요청 : DELETE /api/recipes/{id}
- 특정 레시피를 삭제합니다.

응답 : 
```
{
  "status": "success",
  "message": "레시피가 삭제되었습니다."
}
```

**RecipeIngredient API**
1. 레시피에 재료 추가
요청 : POST /api/recipes/{recipeId}/ingredients
- 특정 레시피에 재료를 추가합니다.

요청 바디 : 
```
{
  "ingredientIds": [1, 2]
}
```

응답 : 
```
{
  "status": "success",
  "data": {
    "recipeId": 1,
    "ingredients": [
      {
        "id": 1,
        "name": "계란",
        "type": "MEAT"
      },
      {
        "id": 2,
        "name": "간장",
        "type": "SEASONINGS"
      }
    ]
  }
}
```
