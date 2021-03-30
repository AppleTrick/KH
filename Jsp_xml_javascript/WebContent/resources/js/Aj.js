/**
 * 
 */
function loadDoc(){
    var req = new XMLHttpRequest();
    req.onreadystatechange = function(){
        if(this.readyState == 4 && this.status==200){
            myFunction(this);
        }
    };

    req.open("GET","Data.xml",true);
    req.send();
}

function myFunction(xml){
    var i;
    var xmlDoc = xml.responseXML;

    var row = xmlDoc.getElementsByTagName("SIGUN_NM")[0];
    console.log(row);
    document.getElementById("content").innerHTML = row;
}