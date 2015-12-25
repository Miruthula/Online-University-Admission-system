/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Application;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RegisterController extends HttpServlet {

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
            out.println("<title>Servlet RegisterController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        processRequest(request, response);
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
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String action=request.getParameter("action");
         final JPanel panel = new JPanel();
         Connection conn =new Connection();
         int status;
     if(action.equals("Register"))
        {
        
         Personal_details c=new Personal_details();
         Connection Conn =new Connection();
           
            c.setFirst_Name(request.getParameter("firstname"));
            c.setLast_Name(request.getParameter("lastname"));
            c.setEmail(request.getParameter("email"));
            c.setUsername(request.getParameter("username"));
            c.setPassword(request.getParameter("password"));
            c.setSecurity_Question(request.getParameter("security"));
            c.setAnswer(request.getParameter("answer"));
            c.setDOB(request.getParameter("dob"));
           // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            c.setGender(request.getParameter("gender"));
            c.setAddress_Line1(request.getParameter("Addressline1"));
            c.setAddress_Line2(request.getParameter("Addressline2"));
            c.setPhone_Number(request.getParameter("phone"));
            c.setCity(request.getParameter("city"));
            c.setState(request.getParameter("state"));
            c.setPostal_Code(request.getParameter("Postalcode"));
            c.setCountry_Of_Citizenship(request.getParameter("countryofcitizenship"));
            c.setVisa_Status(request.getParameter("visastatus"));
            int check=conn.CheckUser(request.getParameter("username"));
            
         if (check==1)
                 {  
                JOptionPane.showMessageDialog(panel, "The Username already Exists.Please Enter a New Username", "Warning",
                JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
                               
            }
         else 
         {
          
               status = conn.adduser(c);
               if(status == 1)
               {
               JOptionPane.showMessageDialog(panel, "Registration Successful", "Congratulations",
                JOptionPane.INFORMATION_MESSAGE);
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
               }
               else if (status == 0)
               {
               
               JOptionPane.showMessageDialog(panel, "Registration Failure.Please fill the form again", "Congratulations",
                JOptionPane.INFORMATION_MESSAGE);
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
               }
              
                
            }
         }
        
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */



