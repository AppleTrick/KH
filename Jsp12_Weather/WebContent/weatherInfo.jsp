<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

	<c:catch var="err">
	<!--  value에 있는 사이트 -> 기상청...! 아마 기상청 API -->
		<c:set var="weatherURL" value="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${code}" />
		<!-- java의 임포트 같은 역할 -->
		<c:import var="weather" url="${weatherURL}" />
		<!-- source 속성 또는 body 대신 XML 컨텐츠로 바꿈 -->
		<x:parse var="wrss" xml="${weather}" />
		<!-- 스크립트 꺽세퍼센트는 역할 -->
		{"pubDate":"<x:out select="$wrss/rss/channel/pubDate" />",
			"temp":"<x:out	select="$wrss/rss/channel/item/description/body/data/temp" />",
			"reh":"<x:out select="$wrss/rss/channel/item/description/body/data/reh" />",
			"pop":"<x:out select="$wrss/rss/channel/item/description/body/data/pop" />",
			"x":"<x:out select="$wrss/rss/channel/item/description/header/x" />",
			"y":"<x:out select="$wrss/rss/channel/item/description/header/y" />",
			"wfKor":"<x:out select="$wrss/rss/channel/item/description/body/data/wfKor" />"}
	</c:catch>
	
	<c:if test="${err!=null}">
		${err}
	</c:if>
