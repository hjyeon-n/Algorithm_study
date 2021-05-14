# DFS, BFS

| 문제 이름                                       | 풀이 날짜  |
| ----------------------------------------------- | ---------- |
| [연구소](#연구소)                               | 2021.05.05 |
| [괄호 변환](#괄호-변환)                         | 2021.05.05 |
| [감시 피하기](#감시-피하기)                     | 2021.05.05 |
| [특정 거리의 도시 찾기](#특정-거리의-도시-찾기) | 2021.05.06 |
| [경쟁적 전염](#경쟁적-전염)                     | 2021.05.11 |
| [연산자 끼워 넣기](#연산자-끼워-넣기)           | 2021.05.12 |
| [인구 이동](#인구-이동)                         | 2021.05.14 |

<br>

<hr>

#### #연구소

[연구소 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/DFS%2C%20BFS/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EC%97%B0%EA%B5%AC%EC%86%8C.java)

이전에도 풀었던 문제 [풀이](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.08/BFS%2C%20DFS.md#%EC%97%B0%EA%B5%AC%EC%86%8C) 

예전에는 어려워서 다른 사람 코드를 참고하면서 풀었는데 이제 이정도는 어렵지 않게 푼다!

<br>

<hr>

#### #괄호 변환

[괄호 변환 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/DFS%2C%20BFS/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EA%B4%84%ED%98%B8%20%EB%B3%80%ED%99%98.java)

이건 사실 recursion 문제가 아닌가 싶다... 내가 정말 싫어하는 유형....^^....

이 문제도 예전에 풀었던 문제이다. [풀이](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.09/Programmers.md#%EA%B4%84%ED%98%B8-%EB%B3%80%ED%99%98)

다만 교재에 나와있는 [풀이 방법](https://github.com/hjyeon-n/python-for-coding-test/blob/master/13/4.java)도 좋아서 나중에 참고해서 다시 풀어보는 게 좋을 것 같다!

<br>

<hr>

#### #감시 피하기

[감시 피하기 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/DFS%2C%20BFS/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EA%B0%90%EC%8B%9C%20%ED%94%BC%ED%95%98%EA%B8%B0.java)

처음 풀었던 문제이고, 풀이는 [여기](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2021.05/BFS%2C%20DFS.md#%EA%B0%90%EC%8B%9C-%ED%94%BC%ED%95%98%EA%B8%B0)에 작성해 두었다.

<br>

<hr>

#### #특정 거리의 도시 찾기

[특정 거리의 도시 찾기 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/DFS%2C%20BFS/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%ED%8A%B9%EC%A0%95%20%EA%B1%B0%EB%A6%AC%EC%9D%98%20%EB%8F%84%EC%8B%9C%20%EC%B0%BE%EA%B8%B0.java)

예전에도 풀었는데 깃헙엔 없다... 뭐지...? 🙄

DFS/BFS 문제는 보통 인접 행렬로 푸는데 이 문제는 인접 리스트로 접근해서 풀었다. 문제가 어렵지 않은 만큼 풀이는 생략!

<br>

<hr>

#### #경쟁적 전염

[경쟁적 전염 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/DFS%2C%20BFS/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EA%B2%BD%EC%9F%81%EC%A0%81%20%EC%A0%84%EC%97%BC.java)

최근에 풀었던 문제이다. 이번에는 좀 다르게 풀었는데 어쩜 한달만에 생각하는 게 달라질 수 있지? 싶다. 다행히 긍정적인 의미로!

이번엔 Node 클래스에 바이러스를 의미하는 v 변수를 추가한 뒤 map을 입력할 때 바이러스의 번호와 위치를 리스트에 저장한 뒤 v를 기준으로 오름차순 정렬을 수행했다. 그리고 이 리스트를 큐에 담아 BFS 탐색을 수행했다.

<br>

<hr>

#### #연산자 끼워 넣기

[연산자 끼워 넣기 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/tree/master/DFS%2C%20BFS/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EC%97%B0%EC%82%B0%EC%9E%90%20%EB%81%BC%EC%9B%8C%20%EB%84%A3%EA%B8%B0)

새삼 문제를 많이 풀었구나 느끼는 게 이 문제도 풀었던 문제이다. [풀이](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.10/BFS%2C%20DFS.md#%EC%97%B0%EC%82%B0%EC%9E%90-%EB%81%BC%EC%9B%8C%EB%84%A3%EA%B8%B0)

예전에는 다른 사람 코드를 참고했던 것 같다. 코드를 보니 도저히 내가 풀었을 거라고 생각이 안 드는 깔끔한 코드였기에...😅

이번에는 나올 수 있는 연산자를 한 배열에 넣고 조합을 구하는 식으로 문제를 풀었다. 의도한 대로 답은 잘 나왔지만 시간 차이가 거의 10배 가까이 나왔다. 그리고 교재 풀이도 이전에 풀었던 방식과 흡사해서 전에 풀었던 방식을 더 참고해야겠다.

<br>

<hr>

#### #인구 이동

[인구 이동 소스 코드](https://github.com/hjyeon-n/java-for-coding-test/blob/master/DFS%2C%20BFS/hjyeon-n/%EA%B8%B0%EC%B6%9C%20%EB%AC%B8%EC%A0%9C/%EC%9D%B8%EA%B5%AC%20%EC%9D%B4%EB%8F%99.java)

예전에 풀었던 문제이다. [풀이](https://github.com/hjyeon-n/Algorithm_study/blob/master/Problem%20Solving/2020.09/BFS%2C%20DFS.md#%EC%9D%B8%EA%B5%AC-%EC%9D%B4%EB%8F%99)

저번보다는 깔끔하게 풀었지만 이해가 안 되는 부분은 예전 코드를 좀 참고했다. 그래서 그런지 좀 아쉬운 문제...😥