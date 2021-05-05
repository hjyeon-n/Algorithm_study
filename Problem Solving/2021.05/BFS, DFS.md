# BFS, DFS

### DFS로 푼 문제

| 문제 번호                                      | 이름                        |
| ---------------------------------------------- | --------------------------- |
| [18428](https://www.acmicpc.net/problem/18428) | [감시 피하기](#감시-피하기) |

<br>

<hr>

#### #감시 피하기

[감시 피하기 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.05/Solution_18428.java)

[연구소](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.08/BFS%2C%20DFS.md#%EC%97%B0%EA%B5%AC%EC%86%8C)와 아주 흡사한 문제이다. 다만 이 문제는 모든 경우에 대해 탐색할 필요없이 벽을 세울 수 있는 경우의 수 리스트를 구한 후 거기서 감시를 피할 수 있는 상황이 하나만 존재하더라도 break해서 반복문에서 빠져나올 수 있다.