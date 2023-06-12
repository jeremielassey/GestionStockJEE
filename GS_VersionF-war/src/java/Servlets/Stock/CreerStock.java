/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Stock;

import Ejb.StockFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeremie
 */
public class CreerStock extends HttpServlet {

    @EJB
    private StockFacadeLocal stockFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomStock = (String) request.getParameter("nomStock");

            Boolean created = stockFacade.creerStock(nomStock);
        System.out.println(created+" est crée");
            if(created){
                response.sendRedirect("Stock");
            }else{
                request.setAttribute("erreur", "Ce Stock existe déja !");
                RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/stock.jsp");
                disp.forward(request, response);
            }

    }


}
