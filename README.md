## 프로젝트 개요
콘솔 기반 숫자 야구 게임 프로젝트입니다.

## 요구사항
### 1. 정답 숫자 생성하기
- 서로 다른 3자리 수
- 각 자리는 1 ~ 9사이의 정수
- 중복 허용하지 않음
### 2. 숫자 입력
- 서로 다른 숫자를 입력 받아야한다.
  - 중복 입력 시 예외 발생
  - 숫자 외 입력 시 예외 발생
### 3. 결과 출력
  - 입력 받은 숫자와 정답 숫자를 비교
    - 스트라이크 : 입력값과 정답을 비교해 같은 자리에 같은 숫자가 있는 경우
    - 볼 : 숫자는 같지만, 자리는 다른 경우
    -  아웃 : 숫자도, 자리도 다른 경우
  - 결과 출력 (ex : "1스트라이크 1볼")
### 4. 기록 조회
  - 지금껏 입력한 횟수와 몇번째 게임인지 출력
### 5. 난이도 지정
  - 3, 4, 5자리 수 정할 수 있도록 입력을 받아야한다.
    - 3, 4, 5 외의 입력은 예외 발생

## 협력에 필요한 객체 설계
![협력에 필요한 객체](https://befitting-subway-0bf.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Fec696ef1-489c-4a9e-b954-fe7608e4327d%2F9ca1d757-0b10-449e-9294-6f86b86fd912%2F%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2024-09-12_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_1.37.47.png?table=block&id=159ea734-2315-46b3-bbf2-86d788602bb5&spaceId=ec696ef1-489c-4a9e-b954-fe7608e4327d&width=1280&userId=&cache=v2)

## 설계에 따라 객체에 책임 할당
### 야구 게임 
- 게임을 실질적으로 시작한다.

**domain.game.BaseballGame.java**
### 화면
- 모든 입/출력을 담당

**domain.display.Display.java**
### 야구 숫자
- 게임에 이용되는 숫자들 생성
- 게임에 이용되는 숫자들 검증
- 랜덤한 숫자를 생성한다.
- 정답과 입력받은 수를 이용해 결과를 계산한다.

**domain.numbers.BaseballNumber.java** <br />
**domain.numbers.BaseballNumbers.java**

### 점수
- 현재 게임이 종료 조건을 만족했는지 판별
- 결과 출력 포멧 반환

**domain.score.BaseballScore.java**

### 경기 기록
- 게임 순번과 시도 횟수를 저장한다.

**domain.log.Log.java** <br />
**domain.log.Logs.java**

## 패키지 구성
``` 
constants
├── BaseballConstants
domain
├── game
│    ├── BaseballGame
│    ├── Level
│    └── Menu
├── numbers
│    ├── BaseballNumber
│    ├── BaseballNumbers
├── score
│    └── BaseballScore
├── log
│    ├── Log
│    └── Logs
└── display
     └── Display
```

### 과제 구현 중 고민했던 점
#### 1.객체에 책임 할당하기
처음 설계를 진행했을 때에는 꽤나 명확하게 각 객체의 책임이 보이는듯했습니다. 하지만 구현을 진행하면서 모호한 부분들이 생겼습니다. <br />
예를들어 점수 계산하는`calculateScore()`는 어느 객체의 책임인가? `BaseballScore`의 책임인가, `BaseballNumbers`의 책임인가에 대해서 고민을 하게 되었습니다. <br />
만약 `BaseballScore`의 책임으로 보고 메서드를 `BaseballScore`에 구현하였다면 필연적으로 `BaseballNumbers`의 내부 필드를 가져오는 getter를 구현하여야 하기 때문에 캡슐화가 위반된다고 생각했습니다. <br /> 
그렇기 때문에 상태는 스스로 관리하는 것이 맞다고 판단하여 `BaseballNumbers`에 구현해 주었습니다.
#### 2.`Level.java` -> enum vs class
`Level` 즉, 난이도는 3, 4, 5만 입력 가능하다고 명시 되어있기 때문에 처음에는 enum으로 구현했습니다. 하지만 만약 요구사항이 변경되고 난이도가 증가 된다면 그 때마다 enum에 필드를 추가하는 것보다 class에서 상수를 두고 검증을 하는 것이 낫다고 판단하여 class로 변경해주었습니다.
#### 3. `Logs.java`의 출력포맷 반환
결과 출력을 위해 `Logs`의 `List<Log> logs`를 getter를 통해 반환하여 Display에서 반복문을 통해 오버라이드한 `Log`의 `toString()`을 호출하도록 구현했었습니다. <br />
하지만 이는 객체의 상태를 외부에 노출시키는 부분이라고 판단되었고 `Logs`의 내부에서 가공을 통해 `List<String>`의 형태로 반환하여 출력하도록 구현했습니다.