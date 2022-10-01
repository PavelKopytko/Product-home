package by.it_academy.jd2.mk_jd2_92_22.controllers.api;

import by.it_academy.jd2.mk_jd2_92_22.core.ProductCreateDTO;
import by.it_academy.jd2.mk_jd2_92_22.core.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.services.api.IProductService;
import by.it_academy.jd2.mk_jd2_92_22.services.api.ServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ApiProductServlet", urlPatterns = "/api/products")
public class ApiProductServlet extends HttpServlet {

    private IProductService service;
    private final ObjectMapper mapper;

    public ApiProductServlet() {
        this.service = ServiceFactory.getInstance().getProductService();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        List<Product> products = service.get();

        PrintWriter writer = resp.getWriter();
        writer.write(this.mapper.writeValueAsString(products));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        List<Product> products = service.get();

        ProductCreateDTO createDTO= this.mapper.readValue(req.getInputStream(), ProductCreateDTO.class);

        /// proverka

        this.service.save(createDTO);

        resp.setStatus(201);


    }
}
