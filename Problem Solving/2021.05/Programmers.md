# Programmers

| 문제 이름                                      | 문제 링크                                                    |
| :--------------------------------------------- | ------------------------------------------------------------ |
| [섬 연결하기](#섬-연결하기)                    | [섬 연결하기](https://programmers.co.kr/learn/courses/30/lessons/42861) |
| [삼각 달팽이](#삼각-달팽이)                    | [삼각 달팽이](https://programmers.co.kr/learn/courses/30/lessons/68645) |
| [행렬 테두리 회전하기](#행렬-테두리-회전하기)⭐ | [행렬 테두리 회전하기](https://programmers.co.kr/learn/courses/30/lessons/77485?language=java) |
| [다단계 칫솔 판매](#다단계-칫솔-판매)          | [다단계 칫솔 판매](https://programmers.co.kr/learn/courses/30/lessons/77486?language=java) |
| [기둥과 보 설치](#기둥과-보-설치)⭐             | [기둥과 보 설치](https://programmers.co.kr/learn/courses/30/lessons/60061) |
| [입국심사](#입국심사)⭐                         | [입국심사](https://programmers.co.kr/learn/courses/30/lessons/43238?language=java) |
| [순위](#순위)                                  | [순위](https://programmers.co.kr/learn/courses/30/lessons/49191?language=java) |

<br>

<hr>

#### #섬 연결하기

[섬 연결하기 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.05/%EC%84%AC%20%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0.java)

기본적인 크루스칼 알고리즘 문제이다. 별도의 풀이는 생략한다.

<br>

<hr>

#### #삼각 달팽이

[삼각 달팽이 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.05/%EC%82%BC%EA%B0%81%20%EB%8B%AC%ED%8C%BD%EC%9D%B4.java)

규칙을 찾아서 풀면 되는 문제이다. 규칙은 찾았는데 이걸 어떻게 활용해야 하나 고민하다가 다른 사람 풀이를 참고했다.

[풀이](https://minhamina.tistory.com/58)는 이 블로그를 참고했다!

여담이지만... 최근에 봤던 코딩 테스트 문제와 유사한 문제이다. 사실 시험 문제가 더 어렵긴 했는데 비슷한 문제라도 풀고 싶어서 풀었다.

내가 별로 좋아하지 않는 수학 유형이고... 정말 안타깝지만 시간이 더 있어도 못 풀었을 것 같다. 그러니까 뭔가 더 후련해지는 것 같기도...? 약한 부분도 잘 준비해서 다음에 또 도전해 봐야겠다~!

<br>

<hr>

⭐⭐⭐⭐⭐

#### #행렬 테두리 회전하기

[행렬 테두리 회전하기 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.05/%ED%96%89%EB%A0%AC%20%ED%85%8C%EB%91%90%EB%A6%AC%20%ED%9A%8C%EC%A0%84%ED%95%98%EA%B8%B0.java)

백엔드 개발자 데브매칭 때 나왔던 문제이다. 그때는 컨디션이 너무 안 좋기도 했고 배열을 돌리는 걸 잘 못하는 편이라 [미세먼지 안녕!](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.10/Implementation.md#%EB%AF%B8%EC%84%B8%EB%A8%BC%EC%A7%80-%EC%95%88%EB%85%95!) 풀이를 참고해서 풀었고 어렵지 않게 맞았다. 이번에는 의존하지 않고 스스로 풀었는데 약간의 고비가 있었지만 다행히 맞았다!

이 부분은 설명할 것도 없기 때문에 풀이는 생략한다. 하지만 아직 서툰 부분이 남았으므로 다시 풀기를 바란다!

<br>

<hr>

#### #다단계 칫솔 판매

[다단계 칫솔 판매 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.05/%EB%8B%A4%EB%8B%A8%EA%B3%84%20%EC%B9%AB%EC%86%94%20%ED%8C%90%EB%A7%A4.java)

데브매칭 기출 문제이다. 당시에 아무 생각없이 풀었다가 맞혀서 당황했던 기억이 난다. 몇 개의 테스트케이스만 맞고 틀렸겠거니 했는데 그때와 비슷하게 풀었는데 정답처리가 된 걸 보니 틀린 풀이는 아니었나 보다! 체감 레벨2이다.

1. 추천인을 매칭하고 각 판매원에 따른 금액을 정해야 하기 때문에 HashMap 2개를 생성하고 초기화한다.
2. seller 배열을 순회하면서 해당 seller가 판매한 amount에 100을 곱해 판매 금액을 구한 뒤 10%를 제외한 금액을 수익으로 저장한다.
3. 2번의 seller 추천인을 map에서 찾은 뒤 마찬가지로 share의 10퍼센트를 뺀 뒤 수익으로 더하고 다시 추천인을 찾는 과정을 반복한다.
4. enroll의 사용자에 매칭되는 moneyMap 값을 찾아 출력한다.

<br>

<hr>

⭐⭐⭐⭐⭐

#### #기둥과 보 설치

[기둥과 보 설치 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.05/%EA%B8%B0%EB%91%A5%EA%B3%BC%20%EB%B3%B4%20%EC%84%A4%EC%B9%98.java)

2020 카카오 공채 기출 문제이다. 역시 어렵다^^...

1시간 30분 정도 풀다가 안 되겠다 싶어서 풀이를 봤다. 결론적으로 말하면 접근 방식은 크게 틀리지 않았다. 다만, 전체적인 구조를 확인하는 대신 난 매번 옆 기둥과 보를 체크하는 방식으로 구현했는데 이 방식으로 하면 조건들이 많아져서 풀기가 어려워진다고 한다. 💦

그래서 '이것이 코딩 테스트다' 교재의 풀이를 참고해서 풀었다.

1. operate 값이 0 즉, 삭제 연산일 때 우선 삭제부터 수행하기 위해 build_frame 값과 같은 원소를 찾는다.
2. 해당 인덱스의 원소를 tmp에 저장하고 graph에서 삭제한다.
3. 전체 구조물이 규칙에 위배되지 않는지 possible 함수를 호출해 확인한다. 위배된다면 다시 tmp 값을 graph에 삽입한다.
4. operate 값이 1 즉, 삽입 연산일 때 우선 삽입부터 수행하기 위해 build_frame 값을 graph에 삽입한다.
5. 마찬가지로 3번의 과정을 거친다. 규칙에 위배된다면 다시 tmp 값을 graph에서 제거한다.
6. graph의 값을 answer 배열로 옮겨준 뒤 문제 요구사항에 따라 정렬한 후 반환한다.

<br>

possible 함수 동작과정

possible 함수는 규칙을 지켰을 때만 flag 값을 true로 초기화한 뒤, flag가 true이면 true를 반환하는 형식으로 진행한다.

1. 기둥인 경우를 먼저 생각해 보자. 

2. 바닥 위일 때는 세울 수 있으므로 true를 반환한다.

3. '보의 한 쪽 끝 부분 위' 혹은 '다른 기둥 위'라면 true를 반환한다.

4. flag 값이 true가 아니라면 false를 반환한다.

5. 보인 경우를 생각해 보자.

6. '한쪽 끝 부분이 기둥 위' 혹은 '양쪽 끝 부분이 다른 보와 동시에 연결'되었는지 확인하고 true를 반환한다.

7. flag 값이 true가 아니라면 false를 반환한다.


<br>

<hr>

⭐⭐⭐⭐⭐

#### #입국심사

[입국심사 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.05/%EC%9E%85%EA%B5%AD%EC%8B%AC%EC%82%AC.java)

어떤 것을 시작점으로 잡고 끝점으로 잡아서 이진 탐색을 수행해야 할지 감이 잡히지 않아서 조금 고민하다가 검색해서 힌트를 얻었다.

사실상 거의 답을 알아버린 거나 다름 없지만 코드는 스스로 짰다. (뻔뻔)

이 문제의 핵심은 **추정 시간 값 / 심사관별 심사 시간 = 심사관당 맡을 수 있는 인원 수**이다.

1.  times 배열을 오름차순으로 정렬한다.
2. 정렬된 times 배열의 마지막 원소에 n을 곱한 값이 심사가 제일 오래 걸리는 심사관이 n명을 맡았을 때 소요 시간이 나온다. 즉, 이 값이 최댓값이 되므로 e 값이 된다.
3. s를 0으로 초기화 하고, e도 2번에서 초기화한 뒤 이분 탐색을 시작한다.
4. mid 값은 추정 시간이 되고 이 값을 심사관 별 심사시간으로 나눈 뒤 합을 구한다. 즉, 이 sum은 mid에 해당하는 소요시간에 최대 몇 명을 심사할 수 있는지를 나타낸다.
5. sum이 mid 값보다 작다면 최소 n명 이상은 심사해야 하는 문제의 요구 조건과 부합하지 않기 때문에 s를 mid + 1로 하여 다시 탐색한다.
6. sum이 mid 값보다 크거나 같다면 n명 이상은 심사했을 때 소요 시간이기 때문에 Long의 최댓값으로 초기화한 answer와 값을 비교해 더 작은 값을 answer로 갱신한다.
7. 이진탐색이 끝난 뒤 answer를 반환한다.

<br>

<hr>

#### #순위

[순위 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2021.05/%EC%88%9C%EC%9C%84.java)

[정확한 순위](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/java-for-coding-test/Shortest%20Path.md#%EC%A0%95%ED%99%95%ED%95%9C-%EC%88%9C%EC%9C%84)와 아주 유사한 문제이다. 문제 출처 링크가 깨져서 같은 문제인지는 확인이 불가능하지만 같은 문제인 것 같다는 생각이 든다.

보자마자 플로이드라고는 생각했지만 마지막에 정확한 순위를 가리는 코드에서 감이 잡히지 않아 이전에 풀었던 코드를 좀 참고했다.

풀이는 생략!

