/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class Application_Status extends HttpServlet {

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
       String action = request.getParameter("action");
       Connection con = new Connection();
          HttpSession session=request.getSession();
          String url=null;
          if (action.equals("status"))
          {
              int Userid =(int) session.getAttribute("UserId");
              ArrayList<Application_Bean> app = new ArrayList<Application_Bean>();
              app = con.getApplicationStatus(Userid);
              session.setAttribute("view", app);
              int a=app.size();
                 if(a==0)
           {
            int temp1=0;
            session.setAttribute("temp2", temp1);
                                 
           }
           else
          {
           int temp1=1;
          session.setAttribute("temp2", temp1);
          }
          request.getRequestDispatcher("/View_Status.jsp").forward(request,response);    
          
          
          }
          if (action.equals("update"))
          {
              int Userid =(int) session.getAttribute("UserId");
              Personal_details d=new Personal_details();
              d=con.UserInfo(Userid);
              session.setAttribute("updateinfo", d);
              
              request.getRequestDispatcher("/Update_Profile.jsp").forward(request,response); 
          }
          
         if (action.equals( "UpdateValue"))
         {
             final JPanel panel = new JPanel();
             int Userid =(int) session.getAttribute("UserId");
             
             String line1=request.getParameter("address");
             String line2=request.getParameter("address1");
             String city=request.getParameter("city");
             String state=request.getParameter("state");
             String pin=request.getParameter("zip");
             String email=request.getParameter("email");
             String phone=request.getParameter("phone");
             int a=con.update(Userid,line1,line2,city,state,pin,email,phone);
             if(a==1)
             {
                JOptionPane.showMessageDialog(panel, "Values Updated", "Information",
                JOptionPane.INFORMATION_MESSAGE);
                request.getRequestDispatcher("/UserHome.jsp").forward(request, response);
             }
             else
             {
                 JOptionPane.showMessageDialog(panel, "Values were not updated. Please re-try later", "Warning",
                JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("/UserHome.jsp").forward(request, response); 
             }
             
              
             
                     
         }
         if (action.equals( "Back"))
         {
             request.getRequestDispatcher("/UserHome.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
