package com.ldt.controllers;

import com.ldt.models.UserModel;
import com.ldt.services.IUserService;
import com.ldt.services.impl.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        int role = Integer.parseInt(req.getParameter("role"));

        String alertMsg = "";
        if (username.isEmpty() || password.isEmpty()  || email.isEmpty()) {
            alertMsg = "Please fill all fields!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        // Check if username is existed
        UserModel user = userService.findByUsername(username);
        if (user != null) {
            alertMsg = "Username is existed!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }

        // Check if email is existed
        user = userService.findByEmail(email);
        if (user != null) {
            alertMsg = "Email is existed!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        // Register user
        user = userService.register(username, password, email,role);
        if (user != null) {
            req.setAttribute("alert", "success");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else {
            req.setAttribute("alert", "Register failed!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}
