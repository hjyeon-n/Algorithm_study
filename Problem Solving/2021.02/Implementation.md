# Implementation

| 문제 번호                                      | 이름                    |
| ---------------------------------------------- | ----------------------- |
| [18870](https://www.acmicpc.net/problem/18870) | [좌표 압축](#좌표-압축) |
| [11723](https://www.acmicpc.net/problem/11723) | [집합](#집합)           |

<br>

<hr>

#### # 좌표 압축

[좌표 압축 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.02/Solution_18870.java)

무슨 말인지 이해조차 안 돼서 인터넷을 참고했는데 어떻게 접근하는지만 알고 풀기는 내가 풀었다.

그래도 접근법이 90%여서 내가 풀었다고 하기는 좀 그런 문제...

**정렬한 뒤, 처음 등장했을 때 몇 번째**였는지 알면 된다. 즉, idx라는 인덱스 변수를 0이라고 선언하고 HashMap을 사용해서 반복문을 돌면서 만약 수가 처음 나왔다면 idx를 증가시키는 방법으로 진행하면 된다.

실버5답게 어려운 문제는 아니었다.

<br>

<hr>

#### #집합

[집합 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.02/Solution_11723.java)

비트마스킹 문제이다. 비트마스킹은 아무래도 익숙해지지가 않는다.💦

[참고](https://rebro.kr/63) 풀이이다.

