package org.example.tms_web_calculator_servlets;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/calc")
public class CalcFilters extends HttpFilter {
@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    String expression = request.getParameter("expression");
    Calculation calc = new Calculation();

    if(expression == null||expression.isEmpty()) {
        response.getWriter().println("No expression provided");
        return;
    }

    if(calc.getOperator(expression).equals("")) {
        response.getWriter().println("Invalid operator.Please enter a valid operator");
        return;
    }

    chain.doFilter(request, response);
}
}