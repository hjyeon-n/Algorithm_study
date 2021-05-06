# Implementation

| 문제 이름                           | 풀이 날짜  |
| ----------------------------------- | ---------- |
| [럭키 스트레이트](#럭키-스트레이트) | 2021.05.05 |
| [문자열 재정렬](#문자열-재정렬)     | 2021.05.05 |
| [문자열 압축](#문자열-압축)         | 2021.05.06 |

<br>

<hr>

#### #럭키 스트레이트

[럭키 스트레이트 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/Implementation/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EB%9F%AD%ED%82%A4%20%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B4%ED%8A%B8.java)

브론즈 2의 아주 쉬운 문제. 풀이할 것도 없다...

<br>

<hr>

#### #문자열 재정렬

[문자열 재정렬 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/Implementation/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EB%AC%B8%EC%9E%90%EC%97%B4%20%EC%9E%AC%EC%A0%95%EB%A0%AC.java)

단순히 문자열을 정렬한 후 숫자들은 합을 구해 뒤에 붙이기만 하면 된다.

<br>

<hr>

#### #문자열 압축

[문자열 압축 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/Implementation/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EB%AC%B8%EC%9E%90%EC%97%B4%20%EC%95%95%EC%B6%95.java)

이전에 풀었던 문제이다. [풀이](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.09/Programmers.md#%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%95%95%EC%B6%95)

지금 보니 뭘 이렇게까지 풀었나... 싶다... 😅 예전에 풀었을 때는 굉장히 오래 걸린 걸로 기억하는데 이번에는 35분만에 풀었다.

저번 코드는 정말 이해도 힘들게 인덱스를 지칭하는 변수를 정하고 이를 움직이면서 풀었는데 이번에는 간단하게 풀었다.

1. 문자열을 자르는 단위는 최소 1에서 최대 문자열의 절반 길이까지다. 
2. 문자열을 단위만큼 자른다 → divide 함수
3. 문자열을 압축한다 → comp 함수

3번이 약간 헷갈렸지만 어렵지 않게 풀 수 있었다. 코드도 직관적이기 때문에 별도의 풀이는 생략!

