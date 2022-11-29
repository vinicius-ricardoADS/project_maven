package com.pw3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pw3.bcrypt.Hash;
import com.pw3.model.Pessoa;
import com.pw3.repository.PessoaDao;
import com.pw3.repository.SQLiteDaoPessoa;

import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet(name = "servletLogar", value = "/logar")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PessoaDao dao = new SQLiteDaoPessoa();
        Pessoa p = dao.findyByUsernameAndPassword(req.getParameter("username"));

        if (p == null) {
            resp.sendRedirect("cadastrar.jsp");
        }
        String hashPassword = p.getPassword();
        BCrypt.Result result = Hash.verify(hashPassword, req.getParameter("hashPassword"));
        if (result.verified) {
            session.setAttribute("user", p);
            resp.sendRedirect("servlet.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        HttpSession session = req.getSession();
        Pessoa p = (Pessoa) session.getAttribute("user");
        if (op != null) {
            if (op.equals("deslogar")) {
                if (p != null) {
                    session.invalidate();
                    resp.sendRedirect("index.jsp");
                }
            }
        }
        super.doGet(req, resp);
    }

}
