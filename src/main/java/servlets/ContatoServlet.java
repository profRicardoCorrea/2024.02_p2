package servlets;
import javax.servlet.*;
import javax.servlet.http.*;

import entidades.Contato;
import repositorios.ContatoRepositorio;

import java.io.IOException;

public class ContatoServlet extends HttpServlet {
    private ContatoRepositorio contatoRep = new ContatoRepositorio();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String mensagem = request.getParameter("mensagem");
        int idade = Integer.parseInt( request.getParameter("idade"));

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setMensagem(mensagem);

        contatoRep.salvar(contato);

        response.sendRedirect("contatoSucesso.jsp");
    }
}

