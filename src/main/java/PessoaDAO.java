

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PessoaDAO {

    private final SessionFactory sessionFactory;

    public PessoaDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Salvar uma nova pessoa.
     */
    public void salvar(Pessoa pessoa) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
             
            transaction = session.beginTransaction();
            session.save(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Buscar uma pessoa por ID.
     */
    public Pessoa buscarPorId(Long id) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            return session.get(Pessoa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Atualizar uma pessoa existente.
     */
    public void atualizar(Pessoa pessoa) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            transaction = session.beginTransaction();
            session.update(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Deletar uma pessoa pelo ID.
     */
    public void deletarPorId(Long id) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            transaction = session.beginTransaction();
            Pessoa pessoa = session.get(Pessoa.class, id);
            if (pessoa != null) {
                session.delete(pessoa);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Listar todas as pessoas.
     */
    public List<Pessoa> listarTodos() {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            return session.createQuery("FROM Pessoa", Pessoa.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Buscar pessoas por nome.
     */
    public List<Pessoa> buscarPorNome(String nome) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            return session.createQuery("FROM Pessoa WHERE nome = :nome", Pessoa.class)
                    .setParameter("nome", nome)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
