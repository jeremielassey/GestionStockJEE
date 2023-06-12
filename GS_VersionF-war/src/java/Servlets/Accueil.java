/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jeremie
 */
public class Accueil extends HttpServlet {

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try{
            String state = (String) session.getAttribute("state");
            if(!state.equals("login")){  // il n'est pas connecté 
                response.sendRedirect("Login");
            }
            else{  // il est déja connecté
                RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/home.jsp");
                disp.forward(request, response);
            }
        }catch(Exception e){
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("state", "logout");
        response.sendRedirect("Login");
    }


}
