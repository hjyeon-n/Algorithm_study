# Sort

| 문제 번호                                      | 이름                            |
| ---------------------------------------------- | ------------------------------- |
| [10825](https://www.acmicpc.net/problem/10825) | [국영수](#국영수)               |
| [18310](https://www.acmicpc.net/problem/18310) | [안테나](#안테나)               |
| [1715](https://www.acmicpc.net/problem/1715)   | [카드 정렬하기](#카드-정렬하기) |

<br>

<hr>

#### 국영수

[국영수 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.05/Solution_10825.java)

ㅋㅋ... 엄청 오래 풀었다... 문제가 어려운 건 아니고 Compartor를 사용하는데 자꾸 4%에서 틀려서 정신 나가는 줄 알았다...

다른 사람 풀이를 보니 Integer의 compare 함수를 사용해서 풀었길래 나도 if-else의 굴레에서 벗어나서 시도했더니 한방에 맞았다...

메소드 사용도 유연하게 사용해야겠다... 💦

<br>

<hr>

#### #안테나

[안테나 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.05/Solution_18310.java)

풀이하기에도 민망한 문제... 정렬 후에 가운데 값을 출력하면 된다.

<br>

<hr>

#### #카드 정렬하기

[카드 정렬하기 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.05/Solution_1715.java)

난이도를 보고 좀 겁먹긴 했는데 너무 쉽게 풀린 문제... 생각한대로 바로 풀려서 당황했다.

난이도 기여란을 보니 사실상 어려운 문제가 맞고 증명이 엄청 까다로운 문제인 듯하다.

항상 가장 작은 크기의 두 카드 묶음을 합쳤을 때 최적의 해를 보장하기 때문에 우선순위 큐를 사용해서 문제를 풀면 된다.