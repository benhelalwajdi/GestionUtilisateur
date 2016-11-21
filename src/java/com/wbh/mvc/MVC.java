/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wbh.mvc;

 
import java.io.IOException; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.wbh.dao.*;
import com.wbh.usr.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class MVC extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/utlisateur.jsp";
    private static final String LIST_USER = "/listner.jsp";
    private final  Dao dao;
 
    public MVC() 
    {
        super();
        dao = new Dao();
    }
 
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
 
        if (action.equalsIgnoreCase("delete")){
            try {
                String userId = request.getParameter("userId");
                dao.EffaceUtilisateur(userId);
                forward = LIST_USER;    
                request.setAttribute("users", dao.getAllUsers());
            } catch (SQLException ex) {
                Logger.getLogger(MVC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String userId = request.getParameter("userId");
            utilisateur user = dao.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            try {
                forward = LIST_USER;
                request.setAttribute("users", dao.getAllUsers());
            } catch (SQLException ex) {
                Logger.getLogger(MVC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            forward = INSERT_OR_EDIT;
        }
 
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            utilisateur user = new utilisateur();
            user.setUname(request.getParameter("uname"));
            user.setPassword(request.getParameter("pass"));
            user.setEmail(request.getParameter("email"));
            String userid = request.getParameter("uname");
//        if(userid == null || userid.isEmpty())
//        {
//            dao.addUser(user);
//        }
//        else
//        {
user.setUname(userid);
dao.VerifeUtilisateur(user);
//        }
RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
request.setAttribute("users", dao.getAllUsers());
view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MVC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

