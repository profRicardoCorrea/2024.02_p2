
package repositorios;
	import org.hibernate.Session;
	import org.hibernate.Transaction;

import entidades.Contato;
import util.HibernateUtil;

	public class ContatoRepositorio {
	    public void salvar(Contato contato) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(contato);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	}
