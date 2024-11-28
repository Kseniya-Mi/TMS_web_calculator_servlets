package org.example.tms_web_calculator_servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calc")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String expression = req.getParameter("expression");
        String expr = expression.replace(" ","+");

        Calculation calc = new Calculation();

        String result = calc.getCalc(expr);

        PrintWriter writer = resp.getWriter();
        writer.println("Result: " + result);
    }
}