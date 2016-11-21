<%-- 
    Document   : listner
    Created on : 21 nov. 2016, 10:31:48
    Author     : wajdi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css.css" />
<title>Show All Users</title>
</head>
<body>
    
            <fieldset>
            <legend> Gestion de Bibliotheque </legend>
    
    <table border=1 >
        
        <thead>
            <tr>
                <th>User Name</th>
                <th>Email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                
                    <td><c:out value="${user.uname}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    
                    <td><a href="MVC?action=edit&userId=<c:out value="${user.uname}"/>"
                            onClick="myFunction()" >modifier</a></td>
                    
                    <td><a href="MVC?action=delete&userId=<c:out value="${user.uname}"/>"
                           onClick="myFunction2()">Effacer</a></td>
                
                </tr>
            </c:forEach>
        </tbody>
        
    <p><a href="MVC?action=insert">Ajout</a></p>
    </table>
            </fieldset>

    
    
    
    //validation de Modifier ou bien de Supprimer
<script>
function myFunction() {
  var  r = confirm("Vous etes modifer se donner");
    if (r === true) {
        submit ;
} else {
    reset;
}
}

function myFunction2() {
  var  r = confirm("Vous etes supprime se donner");
    if (r === true) {
        submit ;
} else {
    return;
}
}
</script>



</body>
</html>
