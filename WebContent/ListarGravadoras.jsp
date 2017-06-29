<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

<div class="formCadastro">
	<form class="cadastro-form">

		<c:>
			List<String> lista = new ArrayList<String>("string1",
			"string2", "string3"); 
		</c:>
		<table>
  <c:forEach items="${list}" var="item">
    <tr>
      <td><c:out value="${item}" /></td>
    </tr>
  </c:forEach>
</table>
	</form>
</div>

</body>
</html>