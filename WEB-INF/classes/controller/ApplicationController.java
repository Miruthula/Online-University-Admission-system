package controller;

import helpers.ApplicationDetailsGetHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserDetails;

@WebServlet(name = "UserApplication", urlPatterns = {"/UserApplications"})
public class ApplicationController extends BaseController {
    private ApplicationDetailsGetHelper applnDtlsGetHelper = new ApplicationDetailsGetHelper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userName = (String) request.getSession().getAttribute("userName");
            String userId = String.valueOf(request.getSession().getAttribute("UserId"));
            UserDetails usrDtls = applnDtlsGetHelper.getApplications(userName);
            usrDtls.setUserid(userId);
            usrDtls.setUsername(userName);
            request.getSession().setAttribute("UserDetails", usrDtls);
            pageForward("/ApplicationStatus.jsp", request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userId = String.valueOf(request.getSession().getAttribute("UserId"));
            UserDetails usrDtls = applnDtlsGetHelper.getApplications(userId);            
            request.getSession().setAttribute("UserDetails", usrDtls);
            pageForward("/ApplicationStatus.jsp", request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
