# Data Structure

| 문제 번호                                      | 이름                        |
| ---------------------------------------------- | --------------------------- |
| [10816](https://www.acmicpc.net/problem/10816) | [숫자 카드 2](#숫자-카드-2) |

<br>

<hr>

#### #숫자 카드 2

[숫자 카드 2 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.04/Solution_10816.java)

upper bound, lower bound를 이용해서 푼 문제라 DS라고 할 순 없지만 문제 분류가 DS라서 여기다가 풀이한다.

실버 4의 어려운 문제는 아니었고 내가 원하는 숫자 하나를 찾는 것과 달리 같은 수가 몇 장인지 알려면 upper bound와 lower bound를 알아내서 그 범위를 알아내면 된다.

아직 upper bound와 lower bound가 좀 어색한 개념이긴 한데 lower bound는 특정 target보다 크거나 같은 **첫 번째 원소의 인덱스**를 반환하기 때문에 target 값보다 크거나 같을 때 거기를 끝지점이라고 생각하면 된다. upper bound는 이와는 반대로 **특정 target보다 큰 첫번째 원소의 인덱스**를 반환하기 때문에 target 값보다 작거나 같으면 그 지점 이상부터 탐색하면 된다.

