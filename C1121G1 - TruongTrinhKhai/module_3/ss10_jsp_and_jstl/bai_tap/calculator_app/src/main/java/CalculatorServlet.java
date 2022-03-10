import model.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        float firstOperand = Float.parseFloat(request.getParameter("first-operand"));
        String operator = request.getParameter("operator");
        float secondOperand = Float.parseFloat(request.getParameter("second-operand"));
        float result = 0;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("</head>");
        writer.println("<h1>RESULT:</h1>");
        try {
            result = Calculator.calculate(firstOperand, secondOperand, operator);
            writer.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
        } catch (Exception e) {
            writer.println("Error: " + e.getMessage());
        }
        writer.println("</html>");
    }
}
