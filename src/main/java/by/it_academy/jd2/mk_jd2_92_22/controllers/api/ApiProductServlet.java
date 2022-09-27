package by.it_academy.jd2.mk_jd2_92_22.controllers.api;

import by.it_academy.jd2.mk_jd2_92_22.core.ProductCreateDTO;
import by.it_academy.jd2.mk_jd2_92_22.core.entity.Product;
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

@WebServlet(name = "ApiProductServlet", urlPatterns = "/api/products")
public class ApiProductServlet extends HttpServlet {

    private IProductService service;

    public ApiProductServlet() {
        this.service = ServiceFactory.getInstance().getProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        List<Product> products= service.get();

        req.setAttribute("products", products);

        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String discount = req.getParameter("discount");
        String description = req.getParameter("description");

        /// proverka

        ProductCreateDTO createDTO = new ProductCreateDTO();

        createDTO.setName(name);
        createDTO.setPrice(Integer.parseInt(price));
        createDTO.setDiscount(Integer.parseInt(discount));
        createDTO.setDescription(description);

        this.service.save(createDTO);

        resp.setStatus(201);



    }
}
