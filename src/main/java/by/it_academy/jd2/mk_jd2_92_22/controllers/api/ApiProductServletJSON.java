package by.it_academy.jd2.mk_jd2_92_22.controllers.api;

import by.it_academy.jd2.mk_jd2_92_22.core.ProductCreateDTO;
import by.it_academy.jd2.mk_jd2_92_22.services.api.IProductService;
import by.it_academy.jd2.mk_jd2_92_22.services.api.ServiceFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;


@WebServlet(name = "ApiProductServletJSON", urlPatterns = "/api/productsjson")
public class ApiProductServletJSON extends HttpServlet {

    private IProductService service;

    public ApiProductServletJSON() {
        this.service = ServiceFactory.getInstance().getProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        BufferedReader reader = new BufferedReader(req.getReader());

       // String json;

        StringBuilder stringBuilder = new StringBuilder();
/*
        int c;

        while ((c = reader.read()) != -1) {
            stringBuilder.append((char) c);
            //json += (char) c;
        }
        json = stringBuilder.toString();*/

          //Don't work. WHY?
        String json="";
        String line;
        while ((line=reader.readLine()) != null) {
            json += line;
        }


        //String jsonString = req.getReader().lines().collect(Collectors.joining());

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        ProductCreateDTO createDTO;
        try {
            createDTO = gson.fromJson(json, ProductCreateDTO.class);
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException("Переданы некорректные параметры");
        }


        PrintWriter writer = resp.getWriter();
        writer.write(json);

        /// proverka


        /*
        if (createDTO == null ) {
            throw new IllegalArgumentException("Поле имя не заполнено");
        }
        */

        this.service.save(createDTO);

        resp.setStatus(201);

    }
}
