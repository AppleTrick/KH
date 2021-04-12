<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text.html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
        <style type="text/css">
            body{
                font-family:Arial;
                font-size:.93em;
            }
            #content-box{
                background-color:#FAFAFA;
                border:2px solid #888;
                padding:4px;
            }
            #content-box p{
                border:1px solid #EEE;
                background-color:#F0F0F0;
                padding:3px;
            }
            #content-box p span{
                color:#00F;
                display:block;
                font:bold 21px Arial;
                float:left;
                margin-right:10px;
            }
        </style>
        <script type="text/javascript">
        onload = function(){
        
        	//var contentLoadTriggered = false;
        	console.log("안녕");
        	var infinityNumber = 1;
        	window.onscroll = function(){
        		if((window.innerHeight + window.scrollY) >= document.body.offsetHeight ){
        			//window.innerHeight 브라우저에서 실제로 표시되고 있는 영역의 높이 
        	        //window.scrolly 스크롤이 세로로 얼마나 이동했는지를 px로 나타냄 0부터 시작해서 스크롤 내릴수록 증가
        	        //offsetheight 요소의 실제 높이 = 보이는 높이 + 가려진 영역
        	        
        	        //contentLoadTriggered = true; && contentLoadTriggered == false
        	        request(infinityNumber);
        	        infinityNumber+=10;
        	        
        		}
        	}
        }
        	
       	async function request(infinityNumber){
       		var response = await fetch('infinitContent.do?infinityNumber='+infinityNumber,{method:'GET',});
       		var data = await response.text();       		
       		document.getElementById('content-wrapper').append(data);
			
       	}
        
        </script>
</head>
<body>
	<h1>Demo page: Infinite Scroll with Java and JQuery</h1>
        <p>This page is a demo for loading new content while scrolling.</p>
        <div id="content-box">
            <div id="content-wrapper">
                <p><span>1</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>2</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>3</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>4</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>5</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>1</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>2</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>3</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>4</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>5</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>1</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>2</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>3</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>4</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>5</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>1</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>2</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>3</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>4</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>5</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>1</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>2</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>3</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>4</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>5</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>1</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>2</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>3</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>4</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>5</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>1</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>2</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>3</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>4</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>5</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>1</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>2</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>3</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>4</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>5</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>1</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>2</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>3</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>4</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                <p><span>5</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ornare facilisis mollis. Etiam non sem massa, a gravida nunc. Mauris lectus augue, posuere at viverra sed, dignissim sed libero. </p>
                
            </div>
        </div>
</body>
</html>