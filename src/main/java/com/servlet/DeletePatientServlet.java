package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.HospitalDAO;

public class DeletePatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String idStr = req.getParameter("id");

            if (idStr == null || idStr.isEmpty()) {
                req.setAttribute("error", "ID cannot be empty!");
                req.getRequestDispatcher("patientdelete.jsp").forward(req, res);
                return;
            }

            int id = Integer.parseInt(idStr);

            if (id <= 0) {
                req.setAttribute("error", "Invalid ID! Must be greater than 0.");
                req.getRequestDispatcher("patientdelete.jsp").forward(req, res);
                return;
            }

            HospitalDAO dao = new HospitalDAO();
            dao.deletePatient(id);

            // ✅ SESSION MESSAGE (CORRECT WAY)
            HttpSession session = req.getSession();
            session.setAttribute("msg", "Patient deleted successfully");

            res.sendRedirect("DisplayPatientsServlet");

        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid ID format! Only numbers allowed.");
            req.getRequestDispatcher("patientdelete.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error while deleting patient!");
            req.getRequestDispatcher("patientdelete.jsp").forward(req, res);
        }
    }
}