# Css 

## 태그 속성?

- 박스모델
    - margin > border > padding > content
    - top right bottom left
    - dotted    테두리 점선
    - dashed    테두리 파선
    - solid
    - double
    - groove    3차원 입체선
    - ridge     3차원 능선효과선?
    - outset    3차원 외지로 끼운선?
    - none      테두리 없음
    - hidden    테두리가 있으나 표현되지 않음.


- 테이블

```css
border: 2px solid orange;   테두리 설정.
border-spacing: 요소간 여백 설정.

```

- 배경 

```css
background-color
{ background-image: url("/dfsdf");}
{ background-repeat: repeat-x; }    배경이미지의 수평반복
                     repeat-y;                   수직반복
background-position: top left right bottom으로 조합가능.
background-attachment
```

<br>

- 텍스트

```css
color:              택스트색무
letter-spacing:     자간.
line-height         줄간격
word-spacing:       띄어쓰기 간격.
text-indent:        들여쓰기 유무.

vertical-align              수직정렬.
text-align:         left  텍스트 수평정렬.
                    right 
                    center;

text-decoration:    overline;
                    line-through;
                    underline;
                    none;       하이퍼텍스트 언더라인제거로 많이 씀.

text-transform      uppercase;      영문자 대소문자 전환.
                    lowercase;
                    capitalize;

direction:          텍스트 써지는 방향.
text-shadow         그림자 효과
white-space         여백설정.

```

<br>

- 위치속성

```css
div { z-index: 0; }     크기가 클수록 앞쪽에 위치.

div { position: static; }   정적 위치
                relative;   상대 위치
                fixed;      고정 위치; 화면스크롤시 움직이지않음
                absolute;   절대 위치
      top
      left
      right
      bottom

      clip          
      cursor        표시되는 마우스 커서모양 설정.
      
      overflow      내용(content)의 크기가 box를 넘어갈때 처리방법 결정.
      overflow-x    내용(content)의 크기가 좌우로 box를 넘어갈때 처리방법 결정.
      overflow-y    내용(content)의 크기가 로 box를 넘어갈때 처리방법 결정.


div { display: inline; }
                block;
                inline-block;
                none;           요소를 나타내지 않음.

div { visibility: hidden; }     요소를 나타내지는 않으나 레이아웃 존재
                    visible;


div { opacity: 0.0 ~ 1.0 }  0에 가까울수록 투명해짐.

div { float: }

div { width: 300px; margin: auto; } 요소를 감씨는 컨테이너기준으로 수평방향 가운데정렬. 따라서 width와 함께 사용
```