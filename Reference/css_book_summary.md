# CSS3

- 선택자를 사용해 특정한 HTML 태그를 선택하면 해당 태그에 원하는 스타일, 기능을 적용 할 수 있습니다.
- 아래 코드를 CSS 블록이라 부릅니다.

```css
선택자 { 스타일속성: 스타일값;}
  h1   {   color   :   red; }
```  
  
## 스타일시트

- head tag내부 style tag 내부에 입력하여 사용하는 코드를 스타일시트라고 합니다.

```css 
<!DOCTYPE html>
<html>
<head>
<title>CSS3</title>
<style>
h1 {
color: red;
background-color: orange;
}
</style>
</head>
<body>
<h1></h1>
</body>
</html>
```  
  
## 선택자

- 형태가 여러가지가 있다고 나오는데 사실 잘 보면 6가지 밖에 없다.

  ```css
  *      { }  - 전체 선택자 
  tag    { }  - 태그 선택자
  #id    { }  - 아이디 선택자
  .class { }  - 클레스 선택자
  :속성   { }  - 가상 클레스 선택자
  ::속성  { }  - 가상 요소 선택자
  ```
  
- ### #id와 .class

  - id는 중복 사용하지 않는다. 중복 사용시 Javascript로 사용시 문제 발생.
  - class는 재사용하기 위해 사용한다. 다른 tag지만 속성이 같다면 적용가능.  
  
- ### box 속성

  - width, height
  - margin, padding  
  
- ### 위치(position)

  - 상대좌표를 주로 사용합니다.
    - static :  태그가 위에서 아래로 순서대로 배치.
    - relative :  초기위치 상태에서 상하좌우로 위치를 이동.
    - absolute :   절대 위치 좌표를 설정.
    - fixed : 화면을 기준으로 절대 위치 좌표를 설정.

  ```css
  .box { width: 100px; heigh: 100; position: absolute;}
  ```  

- ### z-index(z축 순서)

- ### 스마트폰 레이아웃

  - Naver 모바일  페이지 뷰포트 mate 태그
  ```html
  <meta name="viewport" content="width=device-width, initial-scale=1.0, 
  maximum-scale=1.0, minmum-scale=1.0, user-scalable=no, 
  target-densitydpi=medium-dpi" />
  ```
  
  - ### 반응형 웹
    - ipad Vertical 높이 768px 
    - Weppage Horizontal 넓이 960px
    ```html
    <!DOCTYPE html>
    <html>
    <head>
        <title>Media Query Basic</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <style>
            /* 화면 너비 0 픽셀 ~ 767 픽셀 */
            @media screen and (max-width: 767px) {
            }
            /* 화면 너비 768픽셀 ~ 959 픽셀 */
            @media screen and (min-width: 768px) and (max-width: 959px)
            /* 화면 너비 960 픽셀 ~ 무한 픽셀 */
            @media screen and (min-width: 960px) {
            }
        </style>
    </head>
    <body>
        <h1>Lorem ipsum</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        <p>Aenean luctus congue scelerisque. Maecenas aliquet ante.</p>
    </body>
    </html>
    ```