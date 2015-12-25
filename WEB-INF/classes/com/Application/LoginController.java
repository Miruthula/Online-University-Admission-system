/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Application;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session=request.getSession();
        String action=request.getParameter("action");
        if(action.equals("logout"))
        {
            session.removeAttribute("UserId");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String Username= request.getParameter("username");
        String Password= request.getParameter("password");
        PrintWriter out=response.getWriter();
        String action=request.getParameter("action");
        HttpSession session=request.getSession();
        final JPanel panel = new JPanel();
        String url = null;
        if(action.equals("login"))
        {
           Personal_details b =new Personal_details();
           Connection con =new Connection();
           b= con.getUserDetails(Username);
           int type =b.getUserType();
           String a = b.getPassword();
           if (b.getUser_ID()!= 0)
           {
               
          if (Password.equals (a))
          {
            if (type == 1)
               {
                  session.setAttribute("userbean",b.getFirst_Name());
                   session.setAttribute("UserId", b.getUser_ID());
                   session.setAttribute("userName", Username);
                   url = "/UserHome.jsp";
                   
                
               }
            else if (type==2)
                    {
                        url = "/FacultyHome.jsp";
                       //request.getRequestDispatcher("/FacultyHome.jsp").forward(request, response); 
                    }}
            else 
                    {
                         JOptionPane.showMessageDialog(panel, "The Username/Password is not correct", "Warning",
                JOptionPane.WARNING_MESSAGE);
                         url = "/Login.jsp";
             //   request.getRequestDispatcher("/Login.jsp").forward(request, response);
                               
                    }
    }
      else 
                    {
                         JOptionPane.showMessageDialog(panel, "The Username/Password is not correct", "Warning",
                JOptionPane.WARNING_MESSAGE);
                         url = "/Login.jsp";
               
                               
                    }  
            request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    }    

}
