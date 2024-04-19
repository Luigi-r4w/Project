package com.example.Server.services;

import com.example.Server.dao.UserDAO;
import com.example.Server.dto.User;

public class UserServ {
    UserDAO utente = new UserDAO();

    public Boolean authentication(String user, String pass) throws Exception {
        return utente.Authentication(user, pass);
    } 

    public void newUser(User user) throws Exception {
        utente.NewUser(user);
    }

    public void deleteUser(User user) throws Exception{
        utente.DeleteUser(user);
    }

}