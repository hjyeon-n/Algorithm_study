# Binary Search

| 문제 이름                                                    | 풀이 날짜  |
| ------------------------------------------------------------ | ---------- |
| [공유기 설치](#공유기-설치)                                  | 2021.05.12 |
| [정렬된 배열에서 특정 수의 개수 구하기](#정렬된-배열에서-특정 수의-개수-구하기) | 2021.05.13 |
| [고정점 찾기](#고정점-찾기)                                  | 2021.05.14 |

<br>

<hr>

#### #공유기 설치

[공유기 설치 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/BinarySearch/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EA%B3%B5%EC%9C%A0%EA%B8%B0%20%EC%84%A4%EC%B9%98.java)

[풀이](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2021.05/Binary%20Search.md#%EA%B3%B5%EC%9C%A0%EA%B8%B0-%EC%84%A4%EC%B9%98)는 여기서 참조!

<br>

<hr>

#### #정렬된 배열에서 특정 수의 개수 구하기

[정렬된 배열에서 특정 수의 개수 구하기 소스 코드]()

upper bound와 lower bound 문제이다. 보자마자 이 유형의 문제인 건 알았으나 역시나 다른 사람 코드를 참고하면서 코드를 짰다...💦

낯설었지만 이제는 익숙해진 백트래킹 문제처럼 이 유형도 익숙해지도록 자주 봐야겠다...!

<br>

<hr>

#### #고정점 찾기

[고정점 찾기 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/Binary%20Search/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EA%B3%A0%EC%A0%95%EC%A0%90%20%EC%B0%BE%EA%B8%B0.java)

아주 기본적인 이진 탐색 문제이다. 

mid 값과 arr[mid] 값을 비교한 후, arr[mid]가 크다면 그 이후의 값들은 더 크기 때문에 왼쪽 범위를 탐색하고 arr[mid] 값이 더 작다면 오른쪽 범위를 탐색한다. 이때 같은 값이 나오면 answer에 해당 값을 저장한 후 break 하여 반복문에서 빠져나온다.  