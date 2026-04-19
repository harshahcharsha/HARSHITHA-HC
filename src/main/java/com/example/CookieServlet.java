package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.net.URLEncoder;
import java.net.URLDecoder;

/*
Question:
Build a servlet program to create a cookie to get your name through text box 
and press submit button (through HTML) to display the message by greeting 
"Welcome back your name!", you have visited this page n times 
along with the list of cookies and its set values and demonstrate expiry.
*/

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        int visitCount = 1;

        Cookie[] cookies = request.getCookies();

        // Check existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue()) + 1;
                }

                // Use old name only if user didn't enter new one
                if ((name == null || name.equals("")) && c.getName().equals("username")) {
                    name = URLDecoder.decode(c.getValue(), "UTF-8");
                }
            }
        }

        // Encode name to avoid space error
        String encodedName = URLEncoder.encode(name, "UTF-8");

        // Create cookies
        Cookie nameCookie = new Cookie("username", encodedName);
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry (60 seconds)
        nameCookie.setMaxAge(60);
        visitCookie.setMaxAge(60);

        response.addCookie(nameCookie);
        response.addCookie(visitCookie);

        // Output
        out.println("<html><body>");

        out.println("<h2>Welcome back " + name + "! , you have visited this page " 
                + visitCount + " times</h2>");
        // Display all cookies with values
        out.println("<h3>List of Cookies and their Values:</h3>");

        out.println("<p>username : " + name + "</p>");
        out.println("<p>visitCount : " + visitCount + "</p>");

        out.println("<p><b>Note:</b> Cookies will expire in 60 seconds.</p>");
        out.println("<a href='index.html'>Go Back</a>");

        out.println("</body></html>");
    }
}
