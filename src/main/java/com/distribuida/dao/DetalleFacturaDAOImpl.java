package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.DetalleFactura;

@Repository
public class DetalleFacturaDAOImpl implements DetalleFacturaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<DetalleFactura> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DetalleFactura", DetalleFactura.class).getResultList();
		
	}

	@Override
	@Transactional
	public DetalleFactura findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(DetalleFactura.class, id);
		
	}

	@Override
	@Transactional
	public void add(DetalleFactura detallefactura) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(detallefactura);

	}

	@Override
	@Transactional
	public void up(DetalleFactura detallefactura) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(detallefactura);

	}

	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));

	}

}
