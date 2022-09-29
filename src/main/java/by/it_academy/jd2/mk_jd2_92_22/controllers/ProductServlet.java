package by.it_academy.jd2.mk_jd2_92_22.controllers;

import by.it_academy.jd2.mk_jd2_92_22.core.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.services.ProductService;
import by.it_academy.jd2.mk_jd2_92_22.services.api.IProductService;
import by.it_academy.jd2.mk_jd2_92_22.services.api.IServiceFactory;
import by.it_academy.jd2.mk_jd2_92_22.services.api.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/")
public class ProductServlet extends HttpServlet {

    //private IProductService productService = ProductService.getInstance();
    private IProductService service;

    public ProductServlet() {
        this.service = ServiceFactory.getInstance().getProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        List<Product> products = service.get();

        req.setAttribute("products", products);
        req.getRequestDispatcher("main2.jsp").forward(req, resp);
    }
}
