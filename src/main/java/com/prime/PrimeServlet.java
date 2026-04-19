package com.prime;

/*
Program: Build a servlet program to check whether a given number 
is prime or not using HTML.
*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num = Integer.parseInt(request.getParameter("num"));
        boolean isPrime = true;

        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        out.println("<html><body>");

        if (isPrime) {
            out.println("<h2>" + num + " is a Prime Number</h2>");
        } else {
            out.println("<h2>" + num + " is NOT a Prime Number</h2>");
        }

        out.println("</body></html>");
    }
}
