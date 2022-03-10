import model.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PersonServlet", value = "/customer")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = new Person("Mai Văn Hoàng", "1983-08-20", "Hà Nội", "https://cuongtruyen.com/wp-content/uploads/2019/09/luffy-funny-face-1024x576.jpg");
        Person person2 = new Person("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://kodoani.com/uploads/images/2021/04/image_750x_60858080ca697.jpg");
        Person person3 = new Person("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://thanhluanit.files.wordpress.com/2011/09/op_516.jpg");
        Person person4 = new Person("Trần Đăng Khoa", "1983-08-23", "Hà Tây", "https://img.wattpad.com/5dcb19f59f0d8b9159da4ee7251837fe94eb18e4/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f6173474e547a74566f4e6b5545513d3d2d3639353236393435382e313538336464613833316535373038333634323030303235303734352e676966");
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        request.setAttribute("list", list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
//        response.sendRedirect();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
