#  Data Structure

| 문제 번호                                      | 이름                    |
| ---------------------------------------------- | ----------------------- |
| [1927](https://www.acmicpc.net/problem/1927)   | [최소 힙](#최소-힙)     |
| [11279](https://www.acmicpc.net/problem/11279) | [최대 힙](#최대-힙)     |
| [11286](https://www.acmicpc.net/problem/11286) | [절댓값 힙](#절댓값-힙) |

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