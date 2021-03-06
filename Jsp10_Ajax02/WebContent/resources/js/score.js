function getParameterValues() {
    var name = "name=" + encodeURIComponent(document.getElementById("name").value);
    var kor = "kor=" + document.getElementById("kor").value;
    var eng = "eng=" + document.getElementById("eng").value;
    var math = "math=" + document.getElementById("math").value;

    return "?" + name + "&" + kor + "&"+ eng + "&"+ math;
}

function load(){
    var url = "score.do"+getParameterValues();

    httpRequest = new XMLHttpRequest();
    httpRequest.open("GET", url, true);
    httpRequest.onreadystatechange = callback;
    httpRequest.send();
}

function callback(){
    alert("readystate : " + httpRequest.readyState);
    if(httpRequest.readyState == 4 ){
        alert("status : " +httpRequest.status);
        if (httpRequest.status == 200) {
            var obj = JSON.parse(httpRequest.responseText);
            document.getElementById("result").innerHTML = decodeURIComponent(obj.name) + "의 총점 : " + obj.sum + "\n평균 : " + obj.avg;
        } else {
            alert("통신 실패");
        }
    }
}