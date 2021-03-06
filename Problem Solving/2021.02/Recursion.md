# Recursion

| 문제 번호                                    | 이름                            |
| -------------------------------------------- | ------------------------------- |
| [2630](https://www.acmicpc.net/problem/2630) | [색종이 만들기](#색종이-만들기) |
| [1992](https://www.acmicpc.net/problem/1992) | [쿼드트리](#쿼드트리)           |
| [1780](https://www.acmicpc.net/problem/1780) | [종이의 개수](#종이의-개수)⭐    |

<br>

<hr>

#### #색종이 만들기

[색종이 만들기 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.02/Solution_2630.java)

예전이나 지금이나 재귀는 나에게 어려운 개념이라 실버3의 낮은 난이도였는데도 겁먹어서 조금 고민하다가 다른 사람 풀이를 참고했다.😥

대충 N/2로 재귀를 도는 건 알겠는데 종이의 개수를 어떻게 셀지 감이 잘 잡히지 않았다.

이 문제는 크게 재귀를 도는 함수와 어떤 지점에 다다라서 어떤 범위에 있는 종이가 같은 색인지 확인하기 위한 함수가 필요하다.

1. 4분할해야 하기 때문에 이 방향을 생각해서 4번의 재귀식을 쓴다. [참고](https://girawhale.tistory.com/5)
2. 해당 범위에 있는 모든 종이 색을 알아내기 위해서 완전 탐색한다. 이때 시작했던 종이의 색깔과 다른 색이 나온다면 false를 반환해서 다시 종이를 나눈다.

<br>

<hr>

#### #쿼드트리

[쿼드트리 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.02/Solution_1992.java)

색종이 만들기와 비슷한 문제다. 이런 유형의 문제들을 쿼드트리라고 하는데 그래서 이 문제 이름도 쿼드 트리이다. 난이도는 이 문제가 더 높았지만 워낙에 비슷한 유형이라 어렵지 않게 풀었다.

다만, 이번에는 괄호와 영상을 압축해서 출력해야 한다. 처음엔 출력문조차 이해가 어려웠다. 하지만 똑같이 4분할이라고 생각하니 쉽게 눈에 들어왔다.

1. 4분할을 하면서 영역에 같은 숫자들만 있는지 확인하는 방식으로 진행한다. 따라서 같은지 확인하고 나서 만약 같다면, 압축이 가능한 것이기 때문에 현재 map의 값을 str에 더해준다.
2. 4분할을 하기 전 괄호를 열고 모두 끝난다면 괄호를 닫아준다.

<br>

<hr>

⭐⭐⭐⭐⭐

#### #종이의 개수

[종이의 개수 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.02/Solution_1780.java)

이 문제는 실버2 난이도지만 나한테는 쿼드트리보다 어려운 문제였다... 아직 재귀가 다 이해가 되지 않아서 그런 것 같다. 💦

이 문제는 4분할이 아니라 9분할을 해야 한다. 이 부분을 빼고는 색종이 만들기와 똑같은 문제이다.