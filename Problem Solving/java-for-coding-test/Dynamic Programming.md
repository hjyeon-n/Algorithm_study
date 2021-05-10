# Dynamic Programming

| 문제 이름                   | 풀이 날짜  |
| --------------------------- | ---------- |
| [금광](#금광)               | 2021.05.06 |
| [정수 삼각형](#정수-삼각형) | 2021.05.06 |

<br>

<hr>

#### #금광

[금광 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/Dynamic%20Programming/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EA%B8%88%EA%B4%91.java)

정말 간만에 푼 DP 문제. DP를 어려워해서 보자마자 포기하고 싶었는데 침착하게 생각하니 문제를 풀 수 있었다! 뿌듯하다 😊

매번 오른쪽 위, 오른쪽, 오른쪽 아래로 이동할 수 있다는 말은 거꾸로 현재 위치로 오기까지 왼쪽 위, 왼쪽, 왼쪽 아래에서 진입을 했다는 것이다. 이를 토대로 코드를 짜면 된다.

문제는 금의 최대 크기를 요구하고 있기 때문에 왼쪽 위, 왼쪽, 왼쪽 아래에서 가장 큰 값을 현재 위치와 더해주면 된다.

이때, 위와 아래의 경우 범위를 벗어날 수 있으므로 첫 행에 위치할 때는 왼쪽과 왼쪽 아래만 그리고 마지막 행에 위치할 때는 왼쪽과 왼쪽 위만 고려하면 된다. 나머지는 세 가지 경우를 모두 고려한다.

<br>

<hr>

#### #정수 삼각형

[정수 삼각형 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/Dynamic%20Programming/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EC%A0%95%EC%88%98%20%EC%82%BC%EA%B0%81%ED%98%95.java)

정수 삼각형 문제는 진짜 여러 번 풀었는데 한 번도 내 힘으로 처음부터 끝까지 풀어본 적이 없었다... 😥

그래서 이번에도 별 기대를 안 했는데 차분히 생각하면서 문제에 접근하니 의외로 쉽게 풀렸다! 앞으로도 이런 마음가짐으로 문제를 풀어야겠다! 😉

금광 문제와 비슷하다. 오른쪽 대각선과 왼쪽 대각선 중 큰 값을 구해 현재 값과 더해나가면 된다.

다만, 왼쪽과 오른쪽의 가장자리 부분은 주의해야 한다. 왼쪽 가장자리는 오른쪽 대각선만 고려하면 되고 반대로 오른쪽 가장자리는 왼쪽 대각선만 고려하면 되기 때문에 이 경우 큰 값을 찾을 필요 없이 더해나가면 된다.

가운데 부분은 왼쪽 대각선과 오른쪽 대각선 중 큰 값을 고려하면 된다. 이 경우도 단순히 열을 더하고 빼는 게 아니라 그림을 그리면서 올바른 인덱스를 찾는 게 좋다! 