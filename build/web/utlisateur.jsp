<%-- 
    Document   : user
    Created on : 21 nov. 2016, 10:40:55
    Author     : wajdi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
<link rel="stylesheet" href="css.css" type="text/css" />
    </head>
    <body>
        <form method="POST" action='MVC' name="frmAddUser">
            
    
            <fieldset>
            <legend> Ajout de personne </legend>
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            <% if (action.equalsIgnoreCase("edit")) {%>
            <title>modifier un user</title>
            User Name : <input type="text" name="uname"
                               value="<c:out value="${user.uname}" />" readonly="readonly"/> (tu ne peut pas chnager ça)<br /> 
            <%} else {%>
            <title>ajouter un user</title>
            User Name : <input type="text" name="uname"
                               value="<c:out value="${user.uname}" />" /> <br />
            <%}%>
            Password : <input
                type="password" name="pass"
                value="<c:out value="${user.password}" />" /> <br /> 
            Email : <input
                type="text" name="email"
                value="<c:out value="${user.email}" />" /> <br /> 
          
            <input  type="submit" value="Valide" />
            <a href="listner.jsp" >
          
            <input  type="submit" value="Annuler" /></a>
</fieldset>
        </form>
    </body>
</html>
