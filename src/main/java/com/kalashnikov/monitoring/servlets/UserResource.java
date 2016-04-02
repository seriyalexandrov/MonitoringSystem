package com.kalashnikov.monitoring.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ян on 02.04.2016.
 */
@WebServlet(name = "UserResource", urlPatterns = {"/UserResource"})
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "user"}))
public class UserResource extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("userpage.jsp");
    }
}