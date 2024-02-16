package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Autor;

@Repository
public class AutorDAOImpl implements AutorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Autor> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//LEGUAJE HQL
		//select * from autor as au; <- SQL
		//select au from Autor as; <- HQL
		List<Autor> autores = session.createQuery("SELECT au FROM Autor au", Autor.class).getResultList(); 
		return autores;
		
	}
	
	@Override
	@Transactional
	public Autor findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT au FROM Autor au WHERE idAutor =:keyIdAutor");
		query.setParameter("keyIdAutor", id);
		return (Autor) query.getSingleResult();
		
	}

	@Override
	@Transactional
	public void add(Autor autor) {
		// TODO Auto-generated method stub
     Session session=sessionFactory.getCurrentSession();
		
		//HQL INSERT TO VALUES no admite
		//INSERT INTO .... SELECT ... 
		
     session.saveOrUpdate(autor);
	}
   
	@Override
	@Transactional
	public void up(Autor autor) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		Query query =session.createQuery("UPDATE Autor set nombre=:nombre ,apellido=:apellido, pais=:pais, direccion=:direccion, telefono=:telefono, correo=:correo WHERE idAutor =:idAutor");
	    query.setParameter("nombre",autor.getNombre());
		query.setParameter("apellido",autor.getApellido());
		query.setParameter("pais",autor.getPais());
		query.setParameter("direccion",autor.getDireccion());
		query.setParameter("telefono",autor.getTelefono());
		query.setParameter("correo",autor.getCorreo());
		query.setParameter("idAutor",autor.getIdAutor());
		
		query.executeUpdate();

	}

	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query =session.createQuery("DELETE FROM Autor au WHERE au.idAutor=:idAutor ");
		query.setParameter("idAutor", id);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public List<Autor> findAll(String busqueda) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Autor> query = session.createQuery("SELECT au FROM Autor au WHERE "
				+ " au.nombre LIKE : busqueda"
				+ " au.apellido LIKE : busqueda"
				+ " au.pais LIEK : busqueda"
				+ " au.direccion LIKE : busqueda"
				+ " au.correo LIKE : busqueda"
				+ " au.telefono LIKE : busqueda",Autor.class);
		query.setParameter("busqueda", "%"+busqueda+"%");
		
		return query.getResultList();
	}

}
