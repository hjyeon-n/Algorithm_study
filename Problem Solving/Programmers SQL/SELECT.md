# SELECT

| 문제 링크                                                    | 문제 이름                                         |
| ------------------------------------------------------------ | ------------------------------------------------- |
| [모든 레코드 조회하기](https://programmers.co.kr/learn/courses/30/lessons/59034) | [모든 레코드 조회하기](#모든-레코드-조회하기)     |
| [역순 정렬하기](https://programmers.co.kr/learn/courses/30/lessons/59035) | [역순 정렬하기](#역순-정렬하기)                   |
| [아픈 동물 찾기](https://programmers.co.kr/learn/courses/30/lessons/59036) | [아픈 동물 찾기](#아픈-동물-찾기)                 |
| [어린 동물 찾기](https://programmers.co.kr/learn/courses/30/lessons/59037) | [어린 동물 찾기](#어린-동물-찾기)                 |
| [동물의 아이디와 이름](https://programmers.co.kr/learn/courses/30/lessons/59403) | [동물의 아이디와 이름](#동물의-아이디와-이름)     |
| [여러 기준으로 정렬하기](https://programmers.co.kr/learn/courses/30/lessons/59404) | [여러 기준으로 정렬하기](#여러-기준으로-정렬하기) |
| [상위 n개 레코드](https://programmers.co.kr/learn/courses/30/lessons/59405) | [상위 n개 레코드](#상위-n개-레코드)               |

<br>

<hr>
#### #모든 레코드 조회하기

`Oracle, MySQL`

```sql
SELECT *
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
```

<br>

#### #역순 정렬하기

`Oracle, MySQL`

```sql
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;
```

<br>

#### #아픈 동물 찾기

`Oracle, MySQL`

```SQL
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID;
```

<br>

#### #어린 동물 찾기

`MySQL`

```SQL
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID;
```

`Oracle`

```sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION <> 'Aged'
ORDER BY ANIMAL_ID
```

<br>

#### #동물의 아이디와 이름

`Oracle, MySQL`

``` SQL
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
```

<br>

#### #여러 기준으로 정렬하기

`Oracle, MySQL`

```sql
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC;
```

<br>

#### #상위 n개 레코드

`MySQL`

```sql
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1;
```

`Oracle`

```sql
SELECT *
FROM
    (SELECT NAME
    FROM ANIMAL_INS
    ORDER BY DATETIME)
WHERE ROWNUM <= 1
```

