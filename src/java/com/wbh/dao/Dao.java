/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wbh.dao;


import com.wbh.base.BD;
import java.sql.*;
import com.wbh.usr.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wajdi
 */
public class Dao {
    private Connection connection;

    public Dao() {
        this.connection = BD.getConnection();
    }
    
    
    
    //verife si le utilisateur existe ou nn 
    public void VerifeUtilisateur(utilisateur user)
    {
        try 
        {
            PreparedStatement ps = getConnection().prepareStatement("select uname from users where uname = ?");
            ps.setString(1, user.getUname());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // si il existe
            {
                ModifierUtilisateur(user);
                
            } else 
            {
                ajouterUtilisateur(user);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Erreur en VerifeUtilisateur() -->" + ex.getMessage());
        } 
    }

    //ajouter un utilisateur
    public void ajouterUtilisateur(utilisateur user) 
    {
        try 
        {
            PreparedStatement preparedStatement = getConnection().prepareStatement("insert into users(uname, password, email) values (?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());           
            preparedStatement.executeUpdate();
 
        } 
        catch (SQLException e) 
        {
            System.out.println("Erreur pendant l'ajout de utilisateur "+ e.getMessage());
        }
    }
    /**
     *
     * @param user
     */
    
    //modifier l'utilisateur 
    public void ModifierUtilisateur(utilisateur user) 
    {
        try 
        {
            PreparedStatement preparedStatement = getConnection().prepareStatement("update users set password=?, email=?"
                    + "where uname=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getUname());
            preparedStatement.executeUpdate();
 
        } 
        catch (SQLException e) 
        {
            System.out.println("Erreur pendant le modification de utilisateur "+ e.getMessage());
        }
    }
    
    //efface un utilisateur 
    public void EffaceUtilisateur(String userId) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement("delete from users where uname=?");
            // Parameters start with 1
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {     
            System.out.println("Erreur pendant l'efface de utilisateur "+ e.getMessage());
       
        }
    }
    
    
    
    //prendre tout les utilisateur
    public List<utilisateur> getAllUsers() throws SQLException {
        List<utilisateur> users = new ArrayList<>();
            
        if (getConnection() != null){
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                utilisateur user = new utilisateur();
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }}
        
 
        return users;
    }
    
    
    //prendre un utilisateur avec leur ID
    public utilisateur getUserById(String userId) 
    {
        utilisateur user = new utilisateur();
        try 
        {
            PreparedStatement preparedStatement = getConnection().prepareStatement("select * from users where uname=?");
            preparedStatement.setString(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) 
            {
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } 
        catch (SQLException e) 
        {
                 System.out.println("Erreur a getUserById() "+ e.getMessage());
        }
 
        return user;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
