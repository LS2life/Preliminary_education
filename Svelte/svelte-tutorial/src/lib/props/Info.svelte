<script>
    export let name
    export let version
    export let speed
    export let website
</script>
<p>
    The <code>{name}</code> package is {speed} fast.
    Download version {version} from
    <a href="https//www.npmjs.com/package/{name}">
        npm
    </a>
    and <a href={website}>learn more here</a> 
</p>
<code>
    콘솔 글꼴처럼 나온다
</code>
<pre>
입력한 대로 자유롭게 
보여주는 태그
줄바꿈도 가능
</pre>