package com.pw3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name = "servletmain", value = "/servlet-main")
public class Servlet extends HttpServlet{

    private String message;
    private Integer numberContext = 0;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        message = "Welcome";
        numberContext++;
        context.setAttribute("numberContext", numberContext);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNumberContext() {
        return numberContext;
    }

    public void setNumberContext(Integer numberContext) {
        this.numberContext = numberContext;
    }
    
}
