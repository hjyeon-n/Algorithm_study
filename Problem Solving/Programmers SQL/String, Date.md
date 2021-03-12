# String, Date

| 문제 링크                                                    | 문제 이름                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [루시와 엘라 찾기](https://programmers.co.kr/learn/courses/30/lessons/59046) | [루시와 엘라 찾기](#루시와-엘라-찾기)                        |
| [이름에 el이 들어가는 동물 찾기](https://programmers.co.kr/learn/courses/30/lessons/59047) | [이름에 el이 들어가는 동물 찾기](#이름에-el이-들어가는-동물-찾기) |
| [중성화 여부 파악하기](https://programmers.co.kr/learn/courses/30/lessons/59409) | [중성화 여부 파악하기](#중성화-여부-파악하기)                |
| [오랜 기간 보호한 동물(2)](https://programmers.co.kr/learn/courses/30/lessons/59411) | [오랜 기간 보호한 동물(2)](#오랜-기간-보호한-동물(2))        |
| [DATETIME에서 DATE로 형 변환](https://programmers.co.kr/learn/courses/30/lessons/59414) | [DATETIME에서 DATE로 형 변환](#DATETIME에서-DATE로-형-변환)  |

<br>

<hr>

#### #루시와 엘라 찾기

``` sql
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME = 'Lucy' or NAME = 'Ella' or NAME = 'Pickle' or NAME = 'Rogan' 
OR NAME = 'Sabrina' OR NAME = 'Mitty';
```

<br>

#### #이름에 el이 들어가는 동물 찾기

``` sql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE UPPER(NAME) LIKE UPPER('%el%') AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME;
```

<br>

#### #중성화 여부 파악하기

``` sql
SELECT ANIMAL_ID, NAME, 
IF(SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%', 'O', 'X') AS 중성화
FROM ANIMAL_INS;
```

<br>

#### #오랜 기간 보호한 동물(2)

``` sql
SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
ORDER BY DATEDIFF(O.DATETIME, I.DATETIME) DESC
LIMIT 2;
```

<br>

#### #DATETIME에서 DATE로 형 변환

``` sql
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d')
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
```

