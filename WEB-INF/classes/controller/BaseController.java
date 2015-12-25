package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController extends HttpServlet {
   public void pageForward(String pageName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher(pageName);
        rd.forward(request, response);
    }

    public void pageRedirects(String url, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String urlWithSessionID = response.encodeRedirectURL(url.toString());
        response.sendRedirect(urlWithSessionID);
    }    
}
