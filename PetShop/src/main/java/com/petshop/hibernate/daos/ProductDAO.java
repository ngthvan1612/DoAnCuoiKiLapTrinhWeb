package com.petshop.hibernate.daos;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.petshop.hibernate.HibernateUtils;
import com.petshop.hibernate.entities.Product;

public class ProductDAO {
	public ProductDAO() {
		
	}
	
	public Product createProduct(Product product) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    session.persist(product);
	    session.flush();
        
        session.getTransaction().commit();
		return product;
	}
	
	public Product updateProduct(Product product) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Product entity = (Product)session.get(Product.class, product.getId());
	    
	    entity.setProductName(product.getProductName());
	    entity.setPrice(product.getPrice());
	    entity.setProductCode(product.getProductCode());
	    
	    session.update(entity);
	    
	    session.flush();
        
        session.getTransaction().commit();
        
        return entity;
	}
	
	public long numberOfProducts() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select count(*) from " + Product.class.getName() + " p where p.deletedOn = null";
        Query query = session.createQuery(sql);
        
        long result = (long)query.uniqueResult();
        
        session.getTransaction().commit();
        return result;
	}
	
	public List<Product> listProducts(int page, int limit) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + Product.class.getName() + " p where p.deletedOn = null";
        Query<Product> query = session.createQuery(sql);
        
        if ((page - 1) * limit >= 0) {
        	query.setFirstResult((page - 1) * limit);
        	query.setMaxResults(limit);
        }
        
        List<Product> products = query.list();
        
        session.getTransaction().commit();
        return products;
	}
	
	public Product getProductById(int productId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    
        session.getTransaction().begin();
        
        String sql = "select p from " + Product.class.getName() + " p where id=:productId";
        Query<Product> query = session.createQuery(sql);
        query.setParameter("id", productId);
        
        List<Product> products = query.list();
        
        session.getTransaction().commit();
        
        if (products.size() == 0)
        	return null;
        
        return products.get(0);
	}
	
	public void deleteProductById(int productId) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
	    Session session = factory.getCurrentSession();
	    session.getTransaction().begin();
	    
	    Product product = (Product)session.get(Product.class, productId);
	    
	    product.setDeletedOn(new Date(System.currentTimeMillis()));
	    
	    session.update(product);
	    
	    session.flush();
        
        session.getTransaction().commit();
	}
}