package com.ldt.controllers;

import com.ldt.models.UserModel;
import com.ldt.services.IUserService;
import com.ldt.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = {"/forgetpassword"})
public class ForgetPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/forgetpassword.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String alertMsg = "";
        if (email.isEmpty()) {
            alertMsg = "Email is empty!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgetpassword.jsp").forward(req, resp);
            return;
        }
        if (userService.findByEmail(email) == null) {
            alertMsg = "Email is not exist!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgetpassword.jsp").forward(req, resp);
            return;
        }
        UserModel userModel=userService.updatePassword(email,password);
        if (userModel != null) {
            alertMsg = "Update password success! Please login!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else {
            alertMsg = "Update password fail!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgetpassword.jsp").forward(req, resp);
        }
    }
}
