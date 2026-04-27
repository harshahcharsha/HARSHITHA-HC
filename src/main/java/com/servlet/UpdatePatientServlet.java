package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.HospitalDAO;
import com.model.Patient;

public class UpdatePatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String name = req.getParameter("name");

            if (!name.matches("[A-Za-z. ]+")) {
                req.setAttribute("error", "Invalid Name! Only letters allowed.");
                req.getRequestDispatcher("patientupdate.jsp").forward(req, res);
                return;
            }

            int id = Integer.parseInt(req.getParameter("id"));
            int age = Integer.parseInt(req.getParameter("age"));

            if (id <= 0) {
                req.setAttribute("error", "Invalid ID! Must be greater than 0.");
                req.getRequestDispatcher("patientupdate.jsp").forward(req, res);
                return;
            }

            if (age <= 0) {
                req.setAttribute("error", "Invalid Age! Must be greater than 0.");
                req.getRequestDispatcher("patientupdate.jsp").forward(req, res);
                return;
            }

            Patient p = new Patient();
            p.setPatientId(id);
            p.setPatientName(name);
            p.setAge(age);
            p.setGender(req.getParameter("gender"));
            p.setAdmissionDate(req.getParameter("date"));
            p.setAilment(req.getParameter("ailment"));
            p.setAssignedDoctor(req.getParameter("doctor"));

            HospitalDAO dao = new HospitalDAO();
            dao.updatePatient(p);

            // ✅ SESSION MESSAGE (FIX)
            HttpSession session = req.getSession();
            session.setAttribute("msg", "Patient updated successfully");

            res.sendRedirect("DisplayPatientsServlet");

        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid number format!");
            req.getRequestDispatcher("patientupdate.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error while updating patient!");
            req.getRequestDispatcher("patientupdate.jsp").forward(req, res);
        }
    }
}