


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import com.exemplo.entidades.Usuario;

public class UsuarioDAO {

    private SessionFactory sessionFactory;

    public UsuarioDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void salvar(Usuario usuario) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /**
     * Método para buscar um usuário pelo ID.
     */
    public Usuario buscarPorId(Long id) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            return session.get(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Método para atualizar um usuário existente.
     */
    public void atualizar(Usuario usuario) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try { 
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Método para deletar um usuário pelo ID.
     */
    public void deletarPorId(Long id) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                session.delete(usuario);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Método para listar todos os usuários.
     */
    public List<Usuario> listarTodos() {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            return session.createQuery("FROM Usuario", Usuario.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Método para buscar usuários por nome.
     */
    public List<Usuario> buscarPorNome(String nome) {
    	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            return session.createQuery("FROM Usuario WHERE nome = :nome", Usuario.class)
                    .setParameter("nome", nome)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
