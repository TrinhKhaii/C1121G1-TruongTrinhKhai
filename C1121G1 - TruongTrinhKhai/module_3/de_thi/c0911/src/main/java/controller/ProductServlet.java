package controller;
/*
    Created by Trinh Khai
    Date: 22/03/2022
    Time: 19:21
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

@WebServlet(name = "ProductServlet", value = "/product")
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

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<ProductDTO> productDTOList = productService.findAllProduct();
        request.setAttribute("productDTOList", productDTOList);
        List<Category> categoryList = productService.findAllCategory();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("search_by_name");
        String price = request.getParameter("search_by_price");
        String color = request.getParameter("search_by_color");
        String category = request.getParameter("search_by_category");
        List<ProductDTO> productDTOList = null;
        if (name != null && price != null & category != null & color != null) {
            System.out.println("hihi");
            productDTOList = productService.searchByAll(name, price, color, category);
        } else if (name != null && price == null & category == null & color == null) {
            productDTOList = productService.searchByName(name);
        } else if (name == null && price != null & category == null & color == null) {
            productDTOList = productService.searchByPrice(price);
        }
        if (productDTOList.isEmpty()) {
            request.setAttribute("messenger", "Not found");
        } else {
            request.setAttribute("productDTOList", productDTOList);
        }
        List<Category> categoryList = productService.findAllCategory();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
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
        Integer categooryId = Integer.valueOf(request.getParameter("category_id"));
        Product product = new Product(id, name, price, quantity, color, categooryId);
        productService.updateProduct(product);
        response.sendRedirect("product");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id_modal_delete"));
        productService.deleteEmployee(id);
        response.sendRedirect("product");
    }
}
