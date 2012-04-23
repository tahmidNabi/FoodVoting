package net.therap.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


public class LoginController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);


     protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
         rd.forward(request, response);


     }

}
