# Emmet?
	html문 사용자에게는 필수가 아닐까?
	미리 정해진 태그 이름이 없기 때문에 아무이름으로나 태그를 생성할 수 있다.

## 사용법[^1]

### 기본구조 생성!

-  html:5 을 입력후 tab 키를 입력하면 아래와 같이 html 기본 구문이생긴다.<br />
- :memo: 이하 구문에서 탭 키 입력은 [tab]\(으)로 표기 합니다. 

```html
    <!doctype html>
    <html lang="en" >
    <head >
      <meta charset="UTF-8" >
      <meta name="viewport" content="width=device-width, user-scalable=no,  
        initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" >
        <meta http-equiv="X-UA-Compatible" content="ie=edge" >
        <title >Document</title >
    </head >
    <body >

    </body >
    </html >
```

- hello world[tab]
```html
<helloworld></helloworld>
```
<br />

### \> 오른쪽부등호(Greater than; 그레이터 댄)

- 자식요소를 생성할 수 있습니다.
```
    div>ul>li[tab]
```
```html
<div>
    <ul>
        <li></li>
    </ul>
</div>
```
<br />

### \+ 더하기(plus sign; 플러스 사인)

- 형제요소(같은 단계에 위치한 요소)를 생성할 수 있습니다.
```
    div+p+bq[tab]
```
```html
<div></div>
<p></p>
<blockquote></blockquote>
```
<br />

### \^ 누승(circumflex; 서컴플랙스)

- 한 단계 위에 요소를 배치할 수 있습니다.<br />
- ^^^ 위로 이동하고 싶은 단계만큼 사용 가능합니다.<br />
```
    div+div>p>span+em^bq[tab]
```
```html
<div></div>
<div>
    <p>
        <span></span>
        <em></em>
    </p>
    <blockquote></blockquote>
</div>
```
<br />

### \* 별표(asterisk) 에스터리스크

- 요소의 출력 횟수를 입력합니다.
```
    ul>li*5[tab]
```
```html
<ul>
  <li></li>
  <li></li>
  <li></li>
  <li></li>
  <li></li>
</ul>
```
<br />

### \() 소괄호(left/right parenthesis; 퍼렌써시)

```
    div>(header>ul>li*2>a)+footer>p[tab]
```
```html
<div>
    <header>
        <ul>
            <li><a href=""></a></li>
            <li><a href=""></a></li>
        </ul>
    </header>
    <footer>
        <p></p>
    </footer>
</div>
```
<br />

### \# 샵(crosshatch; 크로스햇지),  . 마침표(period; 피리어드)

- id 또는 class에 속성을 입력합니다.
```
    div#header+div.page+div#footer.class1.class2.class3[tab]
```
```html
<div id="header"></div>
<div class="page"></div>
<div id="footer" class="class1 class2 class3"></div>
```
<br />

### [attr] 표기법

- 요소에 사용자 정의 속성 추가
```
td[title="Hello world!" colspan=3][tab]
td[colspan title]
```
```html
<td title="Hello world!" colspan="3"></td>
<td colspan="" title=""></td>
```
<br>

### $ 달러사인(dollar sign; 달러사인)

- 속성값 안에 연산자 갯수만큼 증가하는 숫자를 넣을 수 있습니다..
- $$$ 여러개를 쓰면 오른쪽정렬로 앞의 숫자는 0으로 처리됩니다.
- $@-로 쓰면 역순, 내림차순이 됩니다.
- $@2로 쓰면 숫자가 2부터 증가하도록 기준값이 변경됩니다.
- $@-3 으로 응용버전가능하겠죠?
```
ul>li.item$*5
ul>li.item$@-*5
ul>li.item$@2*4
ul>li.item$@-3*3
```
```html
<ul>
    <li class="item1"></li>
    <li class="item2"></li>
    <li class="item3"></li>
    <li class="item4"></li>
    <li class="item5"></li>
</ul>
<ul>
    <li class="item5"></li>
    <li class="item4"></li>
    <li class="item3"></li>
    <li class="item2"></li>
    <li class="item1"></li>
</ul>
<ul>
    <li class="item2"></li>
    <li class="item3"></li>
    <li class="item4"></li>
    <li class="item5"></li>
</ul>
<ul>
	<li class="item3"></li>
	<li class="item2"></li>
	<li class="item1"></li>
</ul>
```

### {} 중괄호 (left/right braces; 브레이스)

- 텍스트 를 추가합니다.
- 요소의 바로뒤에 사용하면 부모컨텍스트를 변경하지 않습니다.
```
a{Click me}[tab]
p>{Click}+a{here}+{to continue}
p{Click}+a{here}+{to continue}
```
```html
<a href=">Click me</a>

<p>Click<a href="">here</a>to continue</p>
<p>Click</p>

<a href="">here</a>to continue
```

<!--Footer-->
[^1]: [Emmet chect-sheet](https:/docs.emmet.io/cheat-sheet/)를 참고해보세요.
일부 기능만 참고해봤습니다. 재밌는 기능들을 훨씬 많이 볼 수 있어요~

