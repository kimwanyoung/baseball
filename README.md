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
### 결과 출력
  - 입력 받은 숫자와 정답 숫자를 비교
    - 스트라이크 : 입력값과 정답을 비교해 같은 자리에 같은 숫자가 있는 경우
    - 볼 : 숫자는 같지만, 자리는 다른 경우
    -  아웃 : 숫자도, 자리도 다른 경우
  - 결과 출력 (ex : "1스트라이크 1볼")

## 협력에 필요한 객체 설계
![협력에 필요한 객체](https://befitting-subway-0bf.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Fec696ef1-489c-4a9e-b954-fe7608e4327d%2F9ca1d757-0b10-449e-9294-6f86b86fd912%2F%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2024-09-12_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_1.37.47.png?table=block&id=159ea734-2315-46b3-bbf2-86d788602bb5&spaceId=ec696ef1-489c-4a9e-b954-fe7608e4327d&width=1280&userId=&cache=v2)

## 설계에 따라 객체에 책임 할당
### 야구 게임 
- 게임을 실질적으로 시작한다.
- 랜덤한 숫자를 생성한다.
- 정답과 입력받은 수를 이용해 결과를 계산한다.

**Baseball.java**
### 화면
- 모든 입/출력을 담당

**domain.display.Display.java**
### 야구 숫자
- 게임에 이용되는 숫자들 생성
- 게임에 이용되는 숫자들 검증

**domain.numbers.BaseballNumber**

## 패키지 구성
``` 
constants
└── BaseballConstants
domain
├── game
│    ├── BaseballGame
│    └── Menu
├── numbers
│    ├── BaseballNumber
│    ├── BaseballNumbers
│    └── RandomNumbersGenerator
├── score
│    └── BaseballScore
├── level
│    └── Level
├── log
│    ├── Log
│    └── Logs
└── ui
     └── Display

```