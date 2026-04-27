package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.dao.HospitalDAO;
import com.model.Patient;

public class DisplayPatientsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            HospitalDAO dao = new HospitalDAO();
            List<Patient> list = dao.getAllPatients();

            req.setAttribute("data", list);

            HttpSession session = req.getSession(false); // better practice
            if (session != null) {
                String msg = (String) session.getAttribute("msg");
                req.setAttribute("msg", msg);
                session.removeAttribute("msg");
            }

            RequestDispatcher rd = req.getRequestDispatcher("patientdisplay.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error while fetching patient data!");
        }
    }
}