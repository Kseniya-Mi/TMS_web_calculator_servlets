package org.example.tms_web_calculator_servlets;

import java.util.Objects;
import java.util.regex.Pattern;

    public class Calculation {
        private String expr;

        public String getOperator(String expr){

            String operator = "";
            if (expr.contains("+")) {
                operator = "+";
            } else if (expr.contains("-")) {
                operator = "-";
            } else if (expr.contains("*")) {
                operator = "*";
            } else if (expr.contains("/")) {
                operator = "/";
            }

            return operator;
        }

        public String getCalc(String expr){
            String result;
            String operator = getOperator(expr);
            String[] parts = expr.split(Pattern.quote(String.valueOf(operator)));

            if(Objects.equals(operator, "+"))
                result = String.valueOf(Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]));
            else if(Objects.equals(operator, "-"))
                result = String.valueOf(Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]));
            else if(Objects.equals(operator, "*"))
                result = String.valueOf(Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]));
            else if(Objects.equals(operator, "/")) {
                if(parts[1].equals("0"))
                    return "Division by zero";
                result = String.valueOf(Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]));
            }
            else
                result = "Error.Incorrect input...";

            return result;
        }
    }
