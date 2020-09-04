# Programmers 👩‍💻

| 문제 이름                   |
| --------------------------- |
| [문자열 압축](#문자열-압축) |
| [실패율](#실패율)           |

<br>

<hr>

#### #문자열 압축

[문자열 압축 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2020.09/문자열%20압축.java)

이 문제는 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 요구한다.

```
예를 들어, ababcdcdababcdcd의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 2ab2cd2ab2cd로 표현할 수 있다. 다른 방법으로 8개 단위로 잘라서 압축한다면 2ababcdcd로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법이다.
```

어려운 문제는 아니었지만, 생각보다 시간이 좀 걸렸던 문제였다. 

압축 단위는 1부터 문자열 s의 길이 1/2까지 올 수 있다. 1/2가 넘으면 겹치는 부분이 없어 압축될 수 없기 때문이다.

일단 정답이긴 하지만, 다른 사람의 풀이를 봤더니 재귀 같은 다른 방식으로 푼 것도 있어 참고하면서 더 공부해야겠다.

내 풀이 방식은 다음과 같다.

1. 문자열을 분리하는 단위를 하나씩 늘려가기 위해 (즉, 2개 단위로 단어를 끊다가 3개 단위로 단어를 끊는 방식) 반복문을 돌린다.

2. 반복문 안에서 1번의 반복 인자만큼의 단위로 자르고, 각각의 것을 보관하기 위해 배열을 선언한다. 만약, 3개의 단위로 자르는데 문자열의 길이가 3으로 나누어 떨어지지 않을 수 있기 때문에 1만큼의 여분 인덱스를 더 선언한다.

3. 문자열 집합에 자른 문자열을 보관할 때도 2번과 마찬가지로 그 단위의 수에 맞게 항상 나누어 떨어지진 않기 때문에 배열에 값을 저장할 때마다 remain이라는 문자열 s의 길이를 저장한 변수에 단위 만큼 빼준다.

4. 만약 단위는 3, remain이 2라면 배열에 남은 문자열을 다 저장하고, 반복문에서 빠져나온다.

5. 문자열 배열의 값들은 equals 함수를 통해 비교한다.

6. 이때, aa 뿐만 아니라 aaa 같이 반복의 수가 정해져 있지 않으므로, 주의해야 한다.

   예를 들어, cccab라는 문자열이 있다고 하자. 문자열을 자르는 단위는 1이고, 현재 위치는 0이라고 하면 c는 3번 반복되기 때문에 3c가 될 것이다. 이후 인덱스는 다시 2로 넘어갈 필요없이 (이미 검사를 진행했으므로) 인덱스 4의 값 a로 넘어가면 된다. 이때 반복의 수를 저장하는 m을 선언해 m은 3이 되고, 인덱스의 값은 다시 원래대로 돌려줘야하기 때문에 idx - m을 해준다.

7. cnt가 1보다 더 크면 중복되는 값이 있기 때문에 cnt와 함께 str[idx]를 새로운 문자열 newStr에 저장한다.

8. cnt가 1보다 작으면 중복 값이 없기 때문에 str[idx]를 newStr에 저장한다.

9. 2번부터 8번까지의 반복이 끝나면 원래 문자열 s의 길이를 저장한 answer와 새로운 문자열 newStr의 길이를 비교해 작은 값을 저장한다.

10. 1의 과정으로 넘어가 다시 반복한다.

<br>

<hr>

#### #실패율

[실패율 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/Programmers/2020.09/실패율.java)

아주 쉬운 문제였지만 Comparator가 까다로웠다. 파이썬으로 하면 람다식으로 깔끔하게 코드를 짤 수 있으나 자바로 하면 아무래도 코드가 좀 지저분해지는 건 어쩔 수 없다...😥

Comparator 부분은 종종 나오기 때문에 아예 개념으로 따로 정리하려고 한다. 여기서는 그냥 단순 문제 풀이만 정리해야지.

<br>

1. 스테이지 개수만큼 실패율을 저장해야 하기 때문에 fail이라는 Stage형 배열을 선언한다. (Comparator을 위해 따로 Stage라는 클래스를 정의한 뒤, 객체로 사용한다.)

2. stages를 돌며 스테이지 개수를 찾아야 하기 때문에 double형 cnt를 선언한다. (int형으로 선언 뒤, typecasting도 가능하다.) 이때, 스테이지는 1 ~ N이 올 수 있고 stages의 값들도 이러한 값들이 오기 때문에 2번은 1번의 반복문 안에서 돌아야 한다.

3. fail 배열에 인덱스인 idx, 실패율인 cnt / userNum을 넣는다.

4. 유저의 수는 처음엔 stages의 길이와 동일하고, 반복문을 돌 때마다 cnt만큼 빼야 한다.

5. 1번의 반복문이 끝이 나면 Comparator를 통해 실패율을 기준으로 idx를 내림차순으로 정렬한다.

   






