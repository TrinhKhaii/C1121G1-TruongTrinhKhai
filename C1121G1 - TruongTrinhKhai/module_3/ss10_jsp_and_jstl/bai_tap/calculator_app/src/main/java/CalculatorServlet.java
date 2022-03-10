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
        float firstOperant = Float.parseFloat(request.getParameter("first-operand"));
        String operator = request.getParameter("operator");
        float secondOperant = Float.parseFloat(request.getParameter("second-operand"));
        float result = 0;
        switch (operator) {
            case "+":
                result = firstOperant + secondOperant;
                break;
            case "-":
                result = firstOperant - secondOperant;
                break;
            case "*":
                result = firstOperant * secondOperant;
                break;
            case "/":
                result = firstOperant / secondOperant;
                break;
        }

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("</head>");
        writer.println("<h1>RESULT:</h1>");
        writer.println(firstOperant + " " + operator + " " + secondOperant + " = " + result);
        writer.println("</html>");
    }
}
