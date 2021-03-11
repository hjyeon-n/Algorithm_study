# IS NULL

| 문제 링크                                                    | 문제 이름                                               |
| ------------------------------------------------------------ | ------------------------------------------------------- |
| [이름이 없는 동물의 아이디](https://programmers.co.kr/learn/courses/30/lessons/59039) | [이름이 없는 동물의 아이디](#이름이-없는-동물의-아이디) |
| [이름이 있는 동물의 아이디](https://programmers.co.kr/learn/courses/30/lessons/59407) | [이름이 있는 동물의 아이디](#이름이-있는-동물의-아이디) |
| [NULL 처리하기](https://programmers.co.kr/learn/courses/30/lessons/59410) | [NULL 처리하기](#NULL-처리하기)                         |

<br>

<hr>

#### #이름이 없는 동물의 아이디

``` sql
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL;
```

<br>

#### #이름이 있는 동물의 아이디

```  sql
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID;
```

<br>

#### #NULL 처리하기

``` sql
SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name')AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS;
```

