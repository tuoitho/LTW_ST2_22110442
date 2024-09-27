package com.ldt.controllers;

import com.ldt.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.removeAttribute("account");
//        session.invalidate();
//        resp.sendRedirect(req.getContextPath() + "/login");
//        delete cookie
        HttpSession session = req.getSession();
        session.removeAttribute("account");
//        session.invalidate();
//        deleteRememberMe(resp);
//        resp.sendRedirect(req.getContextPath() + "/login");
        resp.sendRedirect("home");

    }
    private void deleteRememberMe(HttpServletResponse resp) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }
}
