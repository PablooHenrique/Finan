package br.com.fornow.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.fornow.model.Lancamento;

public class LancamentoRepository {
	
	public void salvarLancamento(Lancamento lancamento) {
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		session.persist(lancamento);
		transaction.commit();
		session.close();
	}

	public List<Lancamento> listar() {
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query<Lancamento> createQuery = session.createQuery("Select a from Lancamento a", Lancamento.class);
		List<Lancamento> resultList = createQuery.getResultList();
		session.close();
		return resultList;
	}

	public void atualizarLancamento(Lancamento lancamento) {
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(lancamento);
		transaction.commit();
		session.close();
	}

	public void deletar(long id) {
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Lancamento find = session.find(Lancamento.class, id);
		session.remove(find);
		transaction.commit();
		session.close();
	}

	public Lancamento pesquisarPorId(long id) {
		SessionFactory sessionFactory = Repository.getInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Lancamento find = session.find(Lancamento.class, id);
		session.close();
		return find;
	}
}
