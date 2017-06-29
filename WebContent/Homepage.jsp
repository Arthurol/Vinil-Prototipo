<%@include file="header.jsp"%>
<br><br>

<div id="msgWelcome">	
<c:if test="${not empty welcome}">
		<div style="font-size:16px; color: #30c984;">
			<c:out value="${welcome}">
			</c:out>
			<%
				request.setAttribute("welcome", null);
			%>
			<br><br>
		</div>
	</c:if>
</div>
<div id="protoV">
<h1 style="text-align:center; color:#30c984; font-size:40px; position: relative; z-index: 1">Protótipo Vinil!</h1>
</div>
<!-- 
<img src="media_imagens/vinyl.png" style="vertical-align: middle; horizontal-align: auto; position:relative; z-index: 1;">
 -->
 
</body>
</html>