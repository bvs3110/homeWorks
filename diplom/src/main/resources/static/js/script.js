    function findByCode() {
        var mycode = document.getElementById("codes_code").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var codes = JSON.parse(this.responseText);
                var html = '<tr>\n' +
                    '        <th>ID</th>\n' +
                    '        <th>Код маркировки</th>\n' +
                    '        <th>Артикул</th>\n' +
                    '        <th>Размер</th>\n' +
                    '    </tr>';
                html = html + '<tr><td>' + codes.id + '</td>\n' +
                    '        <td>' + codes.code + '</td>\n' +
                    '        <td>' + codes.art + '</td>\n' +
                    '        <td>' + codes.size + '</td>' +
                    '    </tr>';
                document.getElementById("codesList").innerHTML = html;
            }
        };
        var formData = new FormData();
        formData.append("code",mycode);
        xhttp.open("POST", "http://localhost:8080/codes/findByCode", true);
        xhttp.send(formData);
    }
    function findByArt() {
        var myart = document.getElementById("codes_art").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var codes = JSON.parse(this.responseText);
                var html = '<tr>\n' +
                    '        <th>ID</th>\n' +
                    '        <th>Код маркировки</th>\n' +
                    '        <th>Артикул</th>\n' +
                    '        <th>Размер</th>\n' +
                    '    </tr>';
                for (var i = 0; i < codes.length; i++) {
                    var code = codes[i];
                    html = html + '<tr><td>' + code.id + '</td>\n' +
                        '        <td>' + code.code + '</td>\n' +
                        '        <td>' + code.art + '</td>\n' +
                        '        <td>' + code.size + '</td>' +
                        '    </tr>';

                }
                document.getElementById("codesList").innerHTML = html;
            }
        };
        xhttp.open("GET", "http://localhost:8080/codes/findByArt?art=" + myart, true);
        xhttp.send();
    }
    function findByArtSize() {
        var myarts = document.getElementById("codes_arts").value;
        var mysize = document.getElementById("codes_size").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var codes = JSON.parse(this.responseText);
                var html = '<tr>\n' +
                    '        <th>ID</th>\n' +
                    '        <th>Код маркировки</th>\n' +
                    '        <th>Артикул</th>\n' +
                    '        <th>Размер</th>\n' +
                    '    </tr>';
                for (var i = 0; i < codes.length; i++) {
                    var code = codes[i];
                    html = html + '<tr><td>' + code.id + '</td>\n' +
                        '        <td>' + code.code + '</td>\n' +
                        '        <td>' + code.art + '</td>\n' +
                        '        <td>' + code.size + '</td>' +
                        '    </tr>';

                }
                document.getElementById("codesList").innerHTML = html;
            }
        };
        xhttp.open("GET", "http://localhost:8080/codes/findByArtSize?art=" + myarts + "&size=" + mysize, true);
        xhttp.send();
    }