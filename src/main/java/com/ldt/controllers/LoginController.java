package com.ldt.controllers;

import com.ldt.models.UserModel;
import com.ldt.services.IUserService;
import com.ldt.services.impl.UserService;
import com.ldt.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       chuyển sang trang home nếu đã đăng nhập
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("account") != null) {
            UserModel u = (UserModel) session.getAttribute("account");
            req.setAttribute("username", u.getUsername());
            if (u.getRoleid() == 2) {
                resp.sendRedirect(req.getContextPath() + "/admin/home");
                return;
            } else if (u.getRoleid() == 3) {
                resp.sendRedirect(req.getContextPath() + "/manager/home");
                return;
            } else {
                resp.sendRedirect(req.getContextPath() + "/home");
                return;
            }
        }
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("uname");
        String password = req.getParameter("psw");
        String remember = req.getParameter("remember");
        boolean isRemember = false;
        if ("on".equals(remember)) {
            isRemember = true;
        }
        String alertMsg = "";
        if (username.isEmpty() || password.isEmpty()) {
            alertMsg = "Username or password is empty!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }
        UserModel user = userService.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            if (isRemember) {
                saveRememberMe(resp, username);
//                tao session
//                createSession(req, user);
            }else {
                deleteRememberMe(resp);
            }
            resp.sendRedirect(req.getContextPath() + "/waiting");
        }else {
            alertMsg = "Username or password is incorrect!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
    private void saveRememberMe(HttpServletResponse resp, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        resp.addCookie(cookie);

    }
    private void deleteRememberMe(HttpServletResponse resp) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }
//    private void createSession(HttpServletRequest req, UserModel user) {
//        HttpSession session = req.getSession(true);
//        session.setAttribute("account", user);
////        set age
//        session.setMaxInactiveInterval(60 * 60 * 24 * 30);
//    }
}
