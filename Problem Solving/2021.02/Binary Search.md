# Binary Search

| 문제 번호                                    | 이름              |
| -------------------------------------------- | ----------------- |
| [1764](https://www.acmicpc.net/problem/1764) | [듣보잡](#듣보잡) |

<br>

<hr>

#### #듣보잡

[듣보잡 소스 코드](https://github.com/hjyeon-n/Algorithm_study/blob/master/BOJ/2021.02/Solution_1764.java)

클래스3의 은장을 얻기 위해 푼 문제였다. 😜

ArrayList의 contains를 사용하면 되겠거니해서 풀었는데 시간초과가 났다... 그래서 HashSet을 사용했는데 바로 정답처리가 됐다.

똑같은 contains 함수인데 왜 속도 차이가 심하지? 싶어서 검색해 봤다.

ArrayList 즉, List의 경우에는 **입력 순서를 보장**한다. 하지만 HashSet 즉, Set의 경우에는 **입력 순서를 보장하지 않기** 때문에 순서 정보를 따로 관리할 필요가 없다. 이러한 차이로인해 속도 차이가 발생한다고 한다.

이전에는 그냥 생각없이 사용했었는데 어떤 자료구조가 더 유리한지 고민해 봐야겠다.

[참고](https://blog.naver.com/PostView.nhn?blogId=myca11&logNo=221373872927&proxyReferer=https:%2F%2Fwww.google.com%2F)

