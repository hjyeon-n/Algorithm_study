# Programmers

| 문제 이름                                                 | 문제 링크                                                    |
| --------------------------------------------------------- | ------------------------------------------------------------ |
| [N개의 최소공배수](#N개의-최소공배수)                     | [N개의 최소공배수](https://programmers.co.kr/learn/courses/30/lessons/12953) |
| [더 맵게](#더-맵게)                                       | [더 맵게](https://programmers.co.kr/learn/courses/30/lessons/42626) |
| [디스크 컨트롤러](#디스크-컨트롤러)                       | [디스크 컨트롤러](https://programmers.co.kr/learn/courses/30/lessons/42627) |
| [메뉴 리뉴얼](#메뉴-리뉴얼)                               | [메뉴 리뉴얼](https://programmers.co.kr/learn/courses/30/lessons/72411) |
| [방문 길이](#방문-길이)                                   | [방문 길이](https://programmers.co.kr/learn/courses/30/lessons/49994) |
| [보석 쇼핑](#보석-쇼핑)                                   | [보석 쇼핑](https://programmers.co.kr/learn/courses/30/lessons/67258) |
| [숫자의 표현](#숫자의-표현)                               | [숫자의 표현](https://programmers.co.kr/learn/courses/30/lessons/12924) |
| [신규 아이디 추천](#신규-아이디-추천)                     | [신규 아이디 추천](https://programmers.co.kr/learn/courses/30/lessons/72410) |
| [이중 우선순위 큐](#이중-우선순위-큐)                     | [이중 우선순위 큐](https://programmers.co.kr/learn/courses/30/lessons/42628) |
| [이진 변환 반복하기](#이진-변환-반복하기)                 | [이진 변환 반복하기](https://programmers.co.kr/learn/courses/30/lessons/70129) |
| [정수 내림차순으로 배치하기](#정수-내림차순으로-배치하기) | [정수 내림차순으로 배치하기](https://programmers.co.kr/learn/courses/30/lessons/12933) |
| [정수 제곱근 판별](#정수-제곱근-판별)                     | [정수 제곱근 판별](https://programmers.co.kr/learn/courses/30/lessons/12934) |
| [행렬의 덧셈](#행렬의-덧셈)                               | [행렬의 덧셈](https://programmers.co.kr/learn/courses/30/lessons/12950) |

<br>

<hr>

#### #N개의 최소공배수

[N개의 최소공배수 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.02/N%EA%B0%9C%EC%9D%98%20%EC%B5%9C%EC%86%8C%EA%B3%B5%EB%B0%B0%EC%88%98.java)

한참동안 문제 풀이를 귀찮아서 미뤘더니 지난 7월과 모양이 비슷해졌다... 와르르 쓰는 모양새가 말이다.

똑같은 내가 풀었는데 시간이 조금만 지나도 너무 생경해진다... 이건 또 어떻게 풀었더라. 😫

<br>

최소공배수를 어떻게 구하는지 생각해서 코드로 나타내면 되는데 최소공배수는 모든 수가 한꺼번에 나누어지는 수가 나올 때만 나누는 게 아니라 어떤 수이더라도 나누어 떨어지는 수가 있다면 그 수로 나눠야 한다. 이 과정을 newArr라는 새로운 int형 배열로 표현하였다.

1. n으로 나눠서 어떤 수가 나누어 떨어지는 즉, 공배수를 구할 때 n은 2 이상이어야 하는데 그 수가 계속 증가하는 게 아니라 다시 2가 될 수도 더 큰 수가 될 수도 있기 때문에 제일 큰 루프문으로 무한 반복문을 묶는다.
2. 공배수가 나누려는 값보다 커지진 않기 때문에 배열을 오름차순으로 정렬하고 그 마지막 값을 max 값으로 잡는다.
3. n이 max보다 크거나 같을 때까지 반복하는 루프문을 만든다.
4. 3번의 반복문에서 arr의 크기만큼 돌면서 n으로 나눠지는 수가 있는지 검사한다. 이때 만약 나누어지는 수가 있다면 flag 값을 true로 둔다. 나누어지든 그렇지 않든 newArr 값에 나눈 값, 아니면 그대로의 값을 넣는다.
5. 만약 4번에서 나온 flag 값이 true이면 최소공배수인 answer 값에 n만큼 곱해주고 3번의 반복문을 빠져나온다. 그렇지 않다면 다시 n을 늘려서 나누어 떨어지는 수가 있는지 체크한다.
6. status 값을 false로 둬서 arr 값이 모두 1인지 확인한다. 만약 하나라도 1이 아니라면 아직 최소공배수는 나오지 않은 것이기 때문에 1번의 반복문으로 돌아간다. 그렇지 않다면, 반복문을 빠져나와 answer를 반환한다.