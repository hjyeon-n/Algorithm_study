# SUM, MAX, MIN

| 문제 링크                                                    | 문제 이름                         |
| ------------------------------------------------------------ | --------------------------------- |
| [최댓값 구하기](https://programmers.co.kr/learn/courses/30/lessons/59415) | [최댓값 구하기](#최댓값-구하기)   |
| [최솟값 구하기](https://programmers.co.kr/learn/courses/30/lessons/59038) | [최솟값 구하기](#최솟값-구하기)   |
| [동물 수 구하기](https://programmers.co.kr/learn/courses/30/lessons/59406) | [동물 수 구하기](#동물-수-구하기) |
| [중복 제거하기](https://programmers.co.kr/learn/courses/30/lessons/59408) | [중복 제거하기](#중복-제거하기)   |

<br>

<hr>
#### #최댓값 구하기

`Oracle, MySQL`

```sql
SELECT MAX(DATETIME)
FROM ANIMAL_INS
```

<br>

#### #최솟값 구하기

`Oracle, MySQL`

```sql
SELECT MIN(DATETIME)
FROM ANIMAL_INS;
```

<br>

#### #동물 수 구하기

`Oracle, MySQL`

```sql
SELECT COUNT(*)
FROM ANIMAL_INS;
```

<br>

#### #중복 제거하기

`Oracle, MySQL`

```sql
SELECT COUNT(DISTINCT NAME)
FROM ANIMAL_INS
WHERE NAME IS NOT NULL;
```

