<%@ page isELIgnored="false" %>

<HTML>
<head>
    <title>Triunghi AJAX</title>
</head>
<body>
    <h2>Triunghi AJAX</h2>

    <p id="errorMessage"></p>

    <input id="a" name="a" type="number" placeholder="Latura a"> </input>
    <input id="b" name="b" type="number" placeholder="Latura b"> </input>
    <input id="c" name="c" type="number" placeholder="Latura c"> </input>

    <button onclick="sendGet()">sendGet()</button>

    <script>

        function renderResponse(message) {
            document.getElementById("errorMessage").innerHTML = message;
        }

        async function sendGet(){
            var a = document.getElementById("a").value.trim();
            var b = document.getElementById("b").value.trim();
            var c = document.getElementById("c").value.trim();

            const qs = new URLSearchParams({a,b,c}).toString();

            const url = "triangle-ajax?" + qs;

            const r = await fetch(
                url,
                {
                    "method": 'GET',
                }
            );

            const data = await r.json();
            console.log(data);

            if(data){
                renderResponse(data.error);
            }
        }
    </script>
</body>
</HTML>