/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexis
 */
public class home extends HttpServlet {
    private static final String vue = "/WEB-INF/home.jsp";
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher(vue).forward(request,response);
    }
    
}