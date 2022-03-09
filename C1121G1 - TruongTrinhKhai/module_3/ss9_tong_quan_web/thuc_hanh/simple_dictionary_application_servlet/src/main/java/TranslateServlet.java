import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary  = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String search = request.getParameter("input-value");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("</head>");
//        writer.println("<body>");
        String result = dictionary.get(search);
        if (result != null) {
            writer.println("Word: " + search);
            writer.println("</br>");
            writer.println("Result: " + result);
        } else {
            writer.println("Not found");
        }
//        writer.println("</body>");
        writer.println("</html>");
//        request.setAttribute("name", "Khải");
//        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
