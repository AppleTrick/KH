/**
 * 
 */

$(function(){
    getJsonData();
})

function getJsonData(){
    $.getJSON("resources/json/bike.json",function(mydata){
        $.ajax({
            url:"bike.do",
            method : "post",
            data : {"command" : "getdata" , "mydata" : JSON.stringify(mydata) }, 
            //JSON.stringify : javascript 객체 (json 형태로 변환 할 수 있는 ) 를 json 형태의 문자열로 변환 object -> json String
            ////data :  값을 보낼때의 형식
			dataType : "json",
            success : function(msg){
	
				console.log(msg);
				var $tbody = $("tbody");
				
				var list = msg.result;
				for(var i = 0; i < list.length; i++){
					var $tr = $("<tr>");
					
					$tr.append($("<td>").append(list[i].name));
					$tr.append($("<td>").append(list[i].addr));
					$tr.append($("<td>").append(list[i].latitude));
					$tr.append($("<td>").append(list[i].longitude));
					$tr.append($("<td>").append(list[i].bike_count));
					
					$tbody.append($tr);
				}
            },
            error : function(){
                alert("통신 실패");
            }
        })
    })
}