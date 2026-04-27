package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.dao.HospitalDAO;
import com.model.Patient;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            HospitalDAO dao = new HospitalDAO();
            List<Patient> list = new ArrayList<>();

            String doctor = req.getParameter("doctor");
            String ailment = req.getParameter("ailment");
            String from = req.getParameter("from");
            String to = req.getParameter("to");

            if (doctor != null && !doctor.isEmpty()) {
                list = dao.getPatientsByDoctor(doctor);
            } 
            else if (ailment != null && !ailment.isEmpty()) {
                list = dao.getPatientsByAilment(ailment);
            } 
            else if (from != null && to != null && !from.isEmpty() && !to.isEmpty()) {
                list = dao.getPatientsByDate(from, to);
            }

            req.setAttribute("data", list);
            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}