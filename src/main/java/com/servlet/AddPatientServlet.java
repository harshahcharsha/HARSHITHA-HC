package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.HospitalDAO;
import com.model.Patient;

public class AddPatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String name = req.getParameter("name");
            if (!name.matches("[A-Za-z. ]+")) {
                req.setAttribute("error", "Invalid Name! Only letters allowed.");
                req.getRequestDispatcher("patientadd.jsp").forward(req, res);
                return;
            }

            int id = Integer.parseInt(req.getParameter("id"));
            int age = Integer.parseInt(req.getParameter("age"));

            if (id <= 0) {
                req.setAttribute("error", "Invalid ID!");
                req.getRequestDispatcher("patientadd.jsp").forward(req, res);
                return;
            }

            if (age <= 0) {
                req.setAttribute("error", "Invalid Age!");
                req.getRequestDispatcher("patientadd.jsp").forward(req, res);
                return;
            }

            HospitalDAO dao = new HospitalDAO();

            if (dao.isPatientIdExists(id)) {
                req.setAttribute("error", "Patient ID already exists!");
                req.getRequestDispatcher("patientadd.jsp").forward(req, res);
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

            dao.addPatient(p);

            HttpSession session = req.getSession();
            session.setAttribute("msg", p.getPatientName() + " added successfully");

            res.sendRedirect("DisplayPatientsServlet");

        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid number format!");
            req.getRequestDispatcher("patientadd.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error while adding patient!");
            req.getRequestDispatcher("patientadd.jsp").forward(req, res);
        }
    }
}