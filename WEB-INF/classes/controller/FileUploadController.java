package controller;

import com.Application.Application_Bean;
import databasequeries.ApplicationDocumentUpdater;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.UserApplication;
import model.UserDetails;
import model.UserDocumentProofs;
import org.apache.commons.io.IOUtils;

@WebServlet(name = "FileUploads", urlPatterns = {"/FileUploads"})
@MultipartConfig
public class FileUploadController extends BaseController{
    
    ApplicationDocumentUpdater applnDocUpdater = new ApplicationDocumentUpdater();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String fileType = request.getParameter("fileType"); 
            boolean fromBean = Boolean.valueOf( request.getParameter("fromBean") ); 
            byte[] fileContents = null;
            
            if(!fromBean)
            {
                UserDetails usrDtls = (UserDetails) request.getSession().getAttribute("UserDetails");
                UserApplication currentAppln = usrDtls.getCurrentApplication();
                UserDocumentProofs docProofs = currentAppln.getDocProof();

                if("sop".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( docProofs.getSop() );
                } else if("resume".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( docProofs.getResume() );
                }
                else if("reco1".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( docProofs.getReco2() );
                }
                else if("reco2".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( docProofs.getReco1() );
                }
                else if("ug".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( docProofs.getUg_proof() );
                }
                else if("pg".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( docProofs.getPg_proof() );
                }
                else if("idproof".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( docProofs.getId_proof() );
                }
            }
            else
            {
                Application_Bean bean = (Application_Bean) request.getSession().getAttribute("bean");
                if("sop".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( bean.getSOP() );
                } else if("resume".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( bean.getResume() );
                }
                else if("reco1".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( bean.getRec1() );
                }
                else if("reco2".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( bean.getRec2() );
                }
                else if("ug".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( bean.getUg() );
                }
                else if("pg".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( bean.getPg() );
                }
                else if("idproof".equalsIgnoreCase(fileType))
                {
                    fileContents = IOUtils.toByteArray( bean.getIdProof() );
                }
            }
            
            response.getOutputStream().write(fileContents);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            
        } catch (Exception ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDetails usrDtls = (UserDetails) request.getSession().getAttribute("UserDetails");
            UserApplication currentAppln = usrDtls.getCurrentApplication();
            UserDocumentProofs docProofs = currentAppln.getDocProof();
            String fileType = request.getParameter("fileType");

            String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
            Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
            String fileName = getFileName(filePart);
            InputStream fileContent = filePart.getInputStream();

            String applnId = usrDtls.getCurrentApplication().getApplnId();
            if("sop".equalsIgnoreCase(fileType))
            {
                docProofs.setSop(fileContent);
                usrDtls.getCurrentApplication().getDocProof().setSop(fileContent);
                applnDocUpdater.updateSOPDocument(Integer.valueOf(applnId), fileContent);                
            } else if("resume".equalsIgnoreCase(fileType))
            {
                docProofs.setResume(fileContent);
                usrDtls.getCurrentApplication().getDocProof().setResume(fileContent);
                applnDocUpdater.updateResumeDocument(Integer.valueOf(applnId), fileContent);                
            }
            else if("reco1".equalsIgnoreCase(fileType))
            {
                docProofs.setReco1(fileContent);
                usrDtls.getCurrentApplication().getDocProof().setReco1(fileContent);
                applnDocUpdater.updateReco1Document(Integer.valueOf(applnId), fileContent);                
            }else if("reco2".equalsIgnoreCase(fileType))
            {
                docProofs.setReco2(fileContent);
                usrDtls.getCurrentApplication().getDocProof().setReco2(fileContent);
                applnDocUpdater.updateReco2Document(Integer.valueOf(applnId), fileContent);                
            }
            else if("ug".equalsIgnoreCase(fileType))
            {
                docProofs.setUg_proof(fileContent);
                usrDtls.getCurrentApplication().getDocProof().setUg_proof(fileContent);
                applnDocUpdater.updateUGDocument(Integer.valueOf(applnId), fileContent);                
            }else if("pg".equalsIgnoreCase(fileType))
            {
                docProofs.setPg_proof(fileContent);
                usrDtls.getCurrentApplication().getDocProof().setPg_proof(fileContent);
                applnDocUpdater.updatePGDocument(Integer.valueOf(applnId), fileContent);                
            }
            else if("idproof".equalsIgnoreCase(fileType))
            {
                docProofs.setId_proof(fileContent);
                usrDtls.getCurrentApplication().getDocProof().setId_proof(fileContent);
                applnDocUpdater.updateIDDocument(Integer.valueOf(applnId), fileContent);                
            }
            request.getSession().setAttribute("UserDetails", usrDtls);
        } catch (Exception ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
