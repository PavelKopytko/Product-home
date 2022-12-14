package by.it_academy.jd2.mk_jd2_92_22.controllers;

import by.it_academy.jd2.mk_jd2_92_22.core.ProductCreateDTO;
import by.it_academy.jd2.mk_jd2_92_22.core.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.core.entity.ProductBuilder;
import by.it_academy.jd2.mk_jd2_92_22.services.ProductService;
import by.it_academy.jd2.mk_jd2_92_22.services.api.IProductService;
import by.it_academy.jd2.mk_jd2_92_22.services.api.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductAddServlet", urlPatterns = "/add")
public class ProductAddServlet extends HttpServlet {

    private IProductService service;

    public ProductAddServlet() {
        this.service = ServiceFactory.getInstance().getProductService();
    }

    // private IProductService productService = ProductService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        req.getRequestDispatcher("main_add.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String discount = req.getParameter("discount");
        String description = req.getParameter("description");


        PrintWriter writer = resp.getWriter();

        //ProductBuilder productBuilder = ProductBuilder.create();
        ProductCreateDTO createDTO = new ProductCreateDTO();

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("???????? ?????? ???? ??????????????????");
        }
        //productBuilder.setName(req.getParameter("name"));
        createDTO.setName(name);

        if (price.matches("[\\d]+")) {
            //productBuilder.setPrice(Integer.parseInt(price));

            createDTO.setPrice(Integer.parseInt(price));
        } else {
            throw new IllegalArgumentException("?? ???????? ???????? ?????????????? ???????????????????????? ????????????");
        }

        if (discount.matches("[\\d]+")) {
            //productBuilder.setDiscount(Integer.parseInt(discount));
            createDTO.setDiscount(Integer.parseInt(discount));
        } else {
            throw new IllegalArgumentException("?? ???????? ???????????? ?????????????? ???????????????????????? ????????????");
        }

        if (description != null || !description.isBlank()) {
            //productBuilder.setDescription(req.getParameter("description"));
            createDTO.setDescription(description);

        }

        //productBuilder.build();

        service.save(createDTO);

        resp.sendRedirect(req.getContextPath() + "/");


    }
}
