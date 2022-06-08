package controller;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 22:15
*/


import model.Category;
import model.Product;
import model.ProductDTO;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "search":
                    searchProduct(request, response);
                default:
                    listProduct(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
                    break;
                case "edit":
                    editProduct(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<ProductDTO> productDTOList = productService.findAllProductDTO();
        List<Category> categoryList = productService.findAllCategory();
        request.setAttribute("productDTOList", productDTOList);
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = (int) (Math.random() * 10000);
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        String color = request.getParameter("color");
        Integer categoryId = Integer.valueOf(request.getParameter("category_id"));
        Product product = new Product(id, name, price, quantity, color, categoryId);
        productService.insertProduct(product);
        response.sendRedirect("product");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id_modal_edit"));
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        String color = request.getParameter("color");
        Integer categoryId = Integer.valueOf(request.getParameter("category_id"));
        Product product = new Product(id, name, price, quantity, color, categoryId);
        productService.updateProduct(product);
        response.sendRedirect("product");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id_modal_delete"));
        productService.deleteProduct(id);
        response.sendRedirect("product");
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("search_by_name");
        List<ProductDTO> productDTOList = productService.seachProductByName(name);
        if (productDTOList.isEmpty()) {
            request.setAttribute("messenger", "Not found");
        } else {
            request.setAttribute("productDTOList", productDTOList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
}
