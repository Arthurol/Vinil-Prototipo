<%@ page import="java.util.*"%>
<%@ page import="vinil.model.DAO.GravadoraDAO"%>
<%@ page import="vinil.model.Gravadora"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

<h1>Gravadoras</h1>

<div style="overflow-x:auto;" id="tableGravadoras">            
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

</body>
</html>