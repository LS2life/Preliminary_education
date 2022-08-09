
<!-- 
- ctrl +
- alt +
- ctrl + shift +
- ctrl + alt + shift + 
- alt + shift +
 -->

# Localhost Front(Svelte)+back(Spring)

- database is mysql
- software project management is maven
- runtime node.js

## vim

- Marking
    - ma    현재 커서위치에 a로 Marking 

- Move
    - ' 줄
    - ` 문자
    - [ 이전
    - ] 다음
    - 'a    marking 된 a의 줄로 커서를 이동.
    - `a    marking 된 a위치로 커서를 이동.

- Delete
    - :delmarks a    Mark a 삭제.
    - :delmarks a-d    Mark a, b, c, d 삭제
    - :delmarks adxy    Mark a, b, x, y 삭제
    - :delmarks aA    Mark a, A 삭제
    - :delmarks!    소문자 Mark 모두 삭제

- :marks    모든 marklist 확인.
- marks aA 지정한 Mark(a,A)의 정보를 보여줌.

- Find
    - (시작줄),(끝줄)s/찾을패턴/바꿀문자열/옵션
    - %s/score/num/g  : score를 num으로 물어보지말고 모두 변경.
    - 옵션 : 중복 옵션가능. 정규표현식 사용가능
        - g : 매칭되는 문자열을 물어보지 않고 변경
        - i : 대소문자를 구분하지 않고 변경
        - c : 매칭되는 문자열마다 승인요청.
## mysql for vscode

- name : esanfield
- group : Playground
- host : 127.0.0.1
- port : 3306
- username : fieldmaster
- password : masterorder
- database : eplayground

## vscode

- 파일 탐색기 ctrl + shift + e   
- 확장 익스텐션 ctrl + shift + x
- 자동 import alt + shift + o