package rikkei.ra.controller;

import rikkei.ra.model.entity.Product;
import rikkei.ra.model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String action = req.getParameter("action");

        if (action == null) {
            showListStudent(req, resp);
            return;
        }

        int productId = Integer.parseInt(req.getParameter("id"));

        switch (action) {
            case "delete":
                productService.delete(productId);
                resp.sendRedirect("/");
                break;
            case "update":
                req.setAttribute("productId", productId);
                req.getRequestDispatcher("views/update.jsp").forward(req, resp);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String action = req.getParameter("action");
        String productName = req.getParameter("productName");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));

        if (action == null) {
            productService.save(new Product(productName, description, price));
            resp.sendRedirect("/");
        }
    }

    public void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
