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
public class Applications extends HttpServlet {

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

        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String url = null;
        if (action.equals("CS")) {
            ArrayList<Application_Bean> bean2 = new ArrayList<Application_Bean>();
            Connection conn = new Connection();
            bean2 = conn.getApplication(action);
            // out.println(bean2.get(0).getFirst_Name());
            int a = bean2.size();
            if (a == 0) {
                int temp1 = 0;
                session.setAttribute("temp1", temp1);

            } else {
                int temp1 = 1;
                session.setAttribute("temp1", temp1);
            }
            session.setAttribute("bean2", bean2);
            url = "/Application_Display.jsp";

        }
        if (action.equals("IT")) {
            ArrayList<Application_Bean> bean2 = new ArrayList<Application_Bean>();
            Connection conn = new Connection();
            bean2 = conn.getApplication(action);
            // out.println(bean2.get(0).getFirst_Name());
            int a = bean2.size();
            if (a == 0) {
                int temp1 = 0;
                session.setAttribute("temp1", temp1);

            } else {
                int temp1 = 1;
                session.setAttribute("temp1", temp1);
            }
            session.setAttribute("bean2", bean2);
            url = "/Application_Display.jsp";
        }
        if (action.equals("EE")) {
            ArrayList<Application_Bean> bean2 = new ArrayList<Application_Bean>();
            Connection conn = new Connection();
            bean2 = conn.getApplication(action);
            // out.println(bean2.get(0).getFirst_Name());
            int a = bean2.size();
            if (a == 0) {
                int temp1 = 0;
                session.setAttribute("temp1", temp1);

            } else {
                int temp1 = 1;
                session.setAttribute("temp1", temp1);
            }
            session.setAttribute("bean2", bean2);
            url = "/Application_Display.jsp";
        }
        if (action.equals("CIVIL")) {
            ArrayList<Application_Bean> bean2 = new ArrayList<Application_Bean>();
            Connection conn = new Connection();
            bean2 = conn.getApplication(action);
            // out.println(bean2.get(0).getFirst_Name());
            int a = bean2.size();
            if (a == 0) {
                int temp1 = 0;
                session.setAttribute("temp1", temp1);

            } else {
                int temp1 = 1;
                session.setAttribute("temp1", temp1);
            }
            session.setAttribute("bean2", bean2);
            url = "/Application_Display.jsp";
        }
        if (action.equals("MECH")) {
            ArrayList<Application_Bean> bean2 = new ArrayList<Application_Bean>();
            Connection conn = new Connection();
            bean2 = conn.getApplication(action);
            // out.println(bean2.get(0).getFirst_Name());
            int a = bean2.size();
            if (a == 0) {
                int temp1 = 0;
                session.setAttribute("temp1", temp1);

            } else {
                int temp1 = 1;
                session.setAttribute("temp1", temp1);
            }
            session.setAttribute("bean2", bean2);
            url = "/Application_Display.jsp";
        }
        if (action.equals("MGMT")) {
            ArrayList<Application_Bean> bean2 = new ArrayList<Application_Bean>();
            Connection conn = new Connection();
            bean2 = conn.getApplication(action);
            // out.println(bean2.get(0).getFirst_Name());
            int a = bean2.size();
            if (a == 0) {
                int temp1 = 0;
                session.setAttribute("temp1", temp1);

            } else {
                int temp1 = 1;
                session.setAttribute("temp1", temp1);
            }
            session.setAttribute("bean2", bean2);
            url = "/Application_Display.jsp";
        }
        if (action.equals("FIN")) {
            ArrayList<Application_Bean> bean2 = new ArrayList<Application_Bean>();
            Connection conn = new Connection();
            bean2 = conn.getApplication(action);
            // out.println(bean2.get(0).getFirst_Name());
            int a = bean2.size();
            if (a == 0) {
                int temp1 = 0;
                session.setAttribute("temp1", temp1);

            } else {
                int temp1 = 1;
                session.setAttribute("temp1", temp1);
            }
            session.setAttribute("bean2", bean2);
            url = "/Application_Display.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);

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
        /* TODO output your page here. You may use following sample code. */
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        int appId = (int) session.getAttribute("AppId");
        final JPanel panel = new JPanel();
        String url = null;
        boolean admit = false;
        Connection con = new Connection();

        if (action.equals("Grant Admission")) {
            admit = true;
            int i = con.Admission(appId, admit);
            if (i == 1) {
                JOptionPane.showMessageDialog(panel, "The action was completed ", "Warning",
                        JOptionPane.WARNING_MESSAGE);
//                request.getRequestDispatcher("FacultyHome.jsp").forward(request, response);
                response.sendRedirect("/UMC/SendMail?admitStatus=admitted");
                
            } else {
                JOptionPane.showMessageDialog(panel, "The action was not completed! Please re-try ", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("FacultyHome.jsp").forward(request, response);
            }

        }
        if (action.equals("Deny Admission")) {
            int i = con.Admission(appId, admit);
            if (i == 1) {
                JOptionPane.showMessageDialog(panel, "The action was completed ", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                response.sendRedirect("/UMC/SendMail?admitStatus=denied");
//                request.getRequestDispatcher("FacultyHome.jsp").forward(request, response);
            } else {
                JOptionPane.showMessageDialog(panel, "The action was not completed! Please re-try ", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("FacultyHome.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
