# Python

## 문자열

- " ", ' ' 모두 사용가능 + '''여러줄 문자열
- \ 이스케이프 문자
- +결합, \*복제
- [] 문자 추출

  - [:] 전체
  - [start : end : step]

- srt() 문자열 타입으로 변환
- len() 문자열 길이 반환
- split() 문자열 나누기 `tasks.split(',')`
- join() 문자열 결합 `'\n'.join(lines)`
- replace() 문자열 대체 duck를 marmoset로  
   `foo.replace('duck', 'marmoset')`
- strip() 양쪽끝 공백 또는 개행 제거 lstrip, rstrip 가능.
- startwith() endwith()  
   `poem.startswith('All')` poem은 All로 시작하는가?  
   `poem.endwith('All')` poem은 All로 끝나는가?
- find() index() 문자열 찾기. 접두 r,l 가능.  
   `foo.find(word)` 길이를 반환. 없으면 -1  
   `foo.index(word)` 길이를 반환. 없으면 예외처리
- count() 특정 문자열 찾기. int 반환  
   `word = 'the'`  
   `foo.count(word)`
- isalnum() 모든 문자는 알파벳 또는 숫자로 이루어져 있는가?
- 대소문자 변환
  - capitalize() 첫 단어 대문자
  - title() 모든단어 첫글자 대문자
  - upper() 모든 글자 대문자
  - lower() 모든 글자 소문자
  - swapcase() 대소문자 변환

<br />

## 숫자 시퀀스 생성

- range(start, stop, step)
  - start 생략시 0부터 시작
  - stop는 필수 값
  - step 기본값 1, 역순 -1

```python
    # range범위 list에 담기
    list( range(0,3))
    [0, 1, 2]
```

<br />

## Tuple & List

- (tuple 튜플) 불변immutable <==> [list 리스트] 가변mutable

### 생성

    `empty_tuple = ()`
    `empty_list = []`

### 변환

- tuple() other object를 tuple로 만들어준다.
- list() other object를 list로 만들어준다.

```python
marx_list = ['Groucho', 'Chico', 'Harpo']
tuple(marx_list)
('Groucho', 'Chico', 'Harpo')

a_tuple = ('Groucho', 'Chico', 'Harpo')
list(a_tuple)
['Groucho', 'Chico', 'Harpo']
```

- append() list 끝에 항목추가
- insert() 지정위치에 항목추가
- extend() list 병합(merge) , +도 가능
- remove() offset value를 모를때 사용.
- pop() offset로 항목을 가져오면서 삭제.
- clear() 모든항목 삭제
