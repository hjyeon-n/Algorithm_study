#  Data Structure

| 문제 번호                                      | 이름                        |
| ---------------------------------------------- | --------------------------- |
| [1927](https://www.acmicpc.net/problem/1927)   | [최소 힙](#최소-힙)         |
| [11279](https://www.acmicpc.net/problem/11279) | [최대 힙](#최대-힙)         |
| [11286](https://www.acmicpc.net/problem/11286) | [절댓값 힙](#절댓값-힙)     |
| [11000](https://www.acmicpc.net/problem/11000) | [강의실 배정](#강의실-배정) |

<br>

<hr>

#### 최소 힙

[최소 힙 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.01/Solution_1927.java)

처음 풀어보는 힙 코드이다. 괜히 트리라서 어려울 것 같아서 안 풀었는데 일단 자바의 PriorityQueue 함수를 이용해서 풀었다. 

다음엔 직접 구현해 봐서 풀어봐야겠다.

<br>

<hr>

#### #최대 힙

[최대 힙 소스 코드](https://www.acmicpc.net/problem/11279)

이전 문제와 달리 큰 값이 우선순위가 더 높다. 이 경우엔 `Collections.reversOrder()`을 이용하면 쉽게 구할 수 있다.

<br>

<hr>

#### #절댓값 힙

[절댓값 힙 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.01/Solution_11286.java)

이 문제는 절댓값이라는 새로운 기준이 등장하기 때문에 Compartor를 사용하면 된다. 

<br>

<hr>

#### #강의실 배정

[강의실 배정 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.01/Solution_11000.java)

이 문제는 [회의실 배정](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2020.07/Solution_1931.java)이랑 비슷한 문제이다. 단, 이 문제는 하루에 최대 몇 개의 수업을 할 지 책정하는 것이 아니라 모든 강의를 하기 위해 필요한 최소한의 강의실을 구해야 한다.

처음에는 회의실 배정 문제처럼 수업이 끝나는 시간을 기준으로 정렬을 하려고 했는데 이 문제는 아까 말했듯이 하루 안에 모든 걸 해야 하기 때문에 다른 강의실을 잡아야 한다. 그래서 **수업이 시작하는 기준**으로 정렬을 해야 한다.

문제의 설명처럼 강의실 중 강의가 빨리 끝나는대로 곧바로 새로운 강의를 할당하기 위해 우선순위 큐를 사용했다.  

