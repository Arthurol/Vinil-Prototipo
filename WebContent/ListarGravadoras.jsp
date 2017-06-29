<%@ page import="java.util.*"%>
<%@ page import="vinil.model.DAO.GravadoraDAO"%>
<%@ page import="vinil.model.Gravadora"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

<style>
table, th, td {
   border: 2px solid black;
   padding: 10px 0;
}
table {
	border-collapse: separate;
 	border-spacing: 10px 0;
 	 
}
th {
	font-size: 24px;
	color:red;
}
</style>

<div class="formCadastro">

        <div class="forceColor2"></div>
        <div class="topbar2">
            <div class="spanColor2"></div>
            
            <table>
            <tr> 
            	<th>ID</th> 
            	<th>Razão Social</th> 
            	<th>Cnpj</th> 
            	<th>Endereço</th> 
            	<th>Telefones</th> 
            </tr>
           
            <c:forEach items ="${listagravadoras}" var="gravadora">
                <tr>
            	
                	<td><c:out value="${gravadora.id}" /></td>
                	   	
               		<td><c:out value="${gravadora.nome}" /></td>
               		         
               		<td><c:out value="${gravadora.cnpj}" /></td>
               		
               		<td><c:out value="${gravadora.endereco}" /></td>
               		
               		<td><c:out value="${gravadora.telefones}" /></td>
               		
   				</tr>
            </c:forEach>
            
            </table>
		</div>
</div>

</body>
</html>