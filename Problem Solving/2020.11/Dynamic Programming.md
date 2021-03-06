# Dynamic Programming

| 문제 번호                                    | 이름          |
| -------------------------------------------- | ------------- |
| [1890](https://www.acmicpc.net/problem/1890) | [점프](#점프) |

<br>

<hr>

#### #점프

[점프 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.11/Solution_1890.java) 🤸‍♀️

간만에 memoization top-down 방식으로 풀었다. 하나의 map 값에 대해 오른쪽, 또는 아래쪽으로 전부 비교해 봐야 하고 이는 재귀로 푸는 게 좋을 것 같아서 탑다운으로 풀었다. 하지만 온전히 내 힘으로 푼 건 아니고 막혔을 때 질문 게시판을 참고해서 풀었다!

<br>

1. 경로의 개수를 담는 memo는 int의 범위를 넘을 수 있기 때문에 long형으로 선언하고, map은 그대로 int형으로 선언한다.
2. map을 입력 받으면서 memo의 값을 -1로 초기화 해준다. 이는 메모에 들어간 값이 없음을 나타내기 위해서다.
3. sol 함수는 재귀호출을 하는 함수이다. base condition은 문제의 조건인 도착지점을 만났을 때다. 즉, x와 y 좌표 각각이 N - 1일 때이다.
4. 만약 memo의 값이 -1이 아니라면 이미 메모에 저장된 값이 있다는 의미이므로 memo 값을 반환한다.
5. memo의 값이 -1이라면 이제 경로의 수를 구해야 한다. 경로는 오른쪽 혹은 아래쪽으로만 이동할 수 있기 때문에 이 경우에 대해서 반복문을 돌면서 확인한다.
6. 단, 이때 현재 좌표 값에 map 값을 더했을 때 map의 범위를 넘을 수 있기 때문에 이를 따로 확인해야 한다.
7. 6번의 조건에 부합한 경로들만 memo 값에 더해준다. 또 거기서 파생된 nx, ny 값을 기준으로 또 경로가 있는지 확인해야 하기 때문에 재귀 호출을 한다.
8. 모든 재귀 호출이 끝나면 메인으로 돌아와서 값을 출력해 준다.