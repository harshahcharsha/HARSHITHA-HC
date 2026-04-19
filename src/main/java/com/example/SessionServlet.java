package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Date;

/*
Question:
Build a Session Management using Servlet program set with one minute session 
to show Session Tracking Information, Session ID, Session Creation Time, 
Last Access Time, Visit Count
*/

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get session (create if not exists)
        HttpSession session = request.getSession(true);

        // Set session timeout = 60 seconds
        session.setMaxInactiveInterval(60);

        String name = request.getParameter("username");

        // Visit count
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        session.setAttribute("visitCount", visitCount);

        // Output
        out.println("<html><body>");

        out.println("<h2>Welcome " + name + "</h2>");

        out.println("<h3>Session Tracking Information</h3>");

        out.println("<p><b>Session ID:</b> " + session.getId() + "</p>");
        out.println("<p><b>Creation Time:</b> " + new Date(session.getCreationTime()) + "</p>");
        out.println("<p><b>Last Access Time:</b> " + new Date(session.getLastAccessedTime()) + "</p>");
        out.println("<p><b>Visit Count:</b> " + visitCount + "</p>");

        out.println("<p><b>Note:</b> Session expires after 60 seconds of inactivity.</p>");
        out.println("<a href='index.html'>Go Back</a>");

        out.println("</body></html>");
    }
}
