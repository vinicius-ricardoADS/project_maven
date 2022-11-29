package com.pw3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pw3.model.Pessoa;
import com.pw3.model.PessoaHashPassword;
import com.pw3.repository.PessoaDao;
import com.pw3.repository.SQLiteDaoPessoa;

@WebServlet(name = "servletCadastrar", value = "/cadastrar")
public class ServletCadastrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PessoaDao dao = new SQLiteDaoPessoa();

        Pessoa p = new Pessoa(req.getParameter("username"), req.getParameter("name"), req.getParameter("password"));
        PessoaHashPassword.create(p);
        dao.add(p);

        session.setAttribute("user", p);

        resp.sendRedirect(".");

    }

}
