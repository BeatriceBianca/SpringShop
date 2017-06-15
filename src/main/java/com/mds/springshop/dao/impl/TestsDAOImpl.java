package com.mds.springshop.dao.impl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mds.springshop.dao.FavoriteDAO;
import com.mds.springshop.dao.ProductsDAO;
import com.mds.springshop.dao.TestsDAO;
import com.mds.springshop.dao.UsersDAO;
import com.mds.springshop.entity.Cos;
import com.mds.springshop.entity.Users;
import com.mds.springshop.model.CosInfo;
import com.mds.springshop.model.FavoritesInfo;
import com.mds.springshop.model.ProductInfo;
import com.mds.springshop.model.UsersInfo;

@Transactional
@Component
public class TestsDAOImpl implements TestsDAO{
	
	@Autowired
	private FavoriteDAO favDao;
	
	@Autowired
	private UsersDAO usersDao;
	
	@Autowired
	private ProductsDAO productDao;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void testAll(){
		this.testNewUser();
		this.testNewProduct();
		this.TestAcceptOffer();
		this.testAddToCart();
		this.testAddToFav();
	}
	
	public void testNewUser(){
		UsersInfo user = new UsersInfo("last_name", "first_name", "test@yahoo.com", "testPass", 1111111111, "testAddress", "BUYER");
		usersDao.save(user);
		
		Users testUser = usersDao.findUserByEmail("test@yahoo.com");
		if (testUser == null)
			System.out.println("-----------------------------------Eroare!!!!!!!-----------------------------------");
		else System.out.println("-----------------------------------Succes!!!!!!!-----------------------------------");
	}
	
	public void testNewProduct(){
		ProductInfo product = new ProductInfo("testName", 2, 10, 0, 6, 1, "testDescription");
		productDao.addProduct(product, usersDao.findUserByEmail("test@yahoo.com"));
		
		ProductInfo testProduct = productDao.getProductById(productDao.getAllProducts().get(productDao.getAllProducts().size()-1).getId());
		if (testProduct == null)
			System.out.println("-----------------------------------Eroare!!!!!!!-----------------------------------");
		else System.out.println("-----------------------------------Succes!!!!!!!-----------------------------------");
	}
	
	public void TestAcceptOffer() {
		productDao.acceptOffer(productDao.getAllProducts().get(productDao.getAllProducts().size()-1).getId());
		
		ProductInfo testProduct = productDao.getProductById(productDao.getAllProducts().get(productDao.getAllProducts().size()-1).getId());
		if (testProduct.getStatus() == 0)
			System.out.println("-----------------------------------Eroare!!!!!!!-----------------------------------");
		else System.out.println("-----------------------------------Succes!!!!!!!-----------------------------------");
	}
	
	public void testAddToCart(){
		
		Session session=this.sessionFactory.getCurrentSession();
		
		Cos cartProducts=new Cos();
		cartProducts.setIdProd(productDao.getAllProducts().get(productDao.getAllProducts().size()-1).getId());
		cartProducts.setDenumireProd("testName");
		cartProducts.setPretProd(10);
		cartProducts.setCantitate(1);
		cartProducts.setUserEmail("test@yahoo.com");
		session.save(cartProducts);
		session.flush();
		
		CosInfo testCart = productDao.findProductInCart(productDao.getAllProducts().get(productDao.getAllProducts().size()-1).getId(), "test@yahoo.com");
		if (testCart == null)
			System.out.println("-----------------------------------Eroare!!!!!!!-----------------------------------");
		else System.out.println("-----------------------------------Succes!!!!!!!-----------------------------------");
	}
	
	public void testAddToFav(){
		
		favDao.addFavorite(productDao.getAllProducts().get(productDao.getAllProducts().size()-1).getId(), usersDao.findUserByEmail("test@yahoo.com").getId());
		
		ArrayList<FavoritesInfo> getFavByUser = favDao.getFavoritesByUser(usersDao.findUserByEmail("test@yahoo.com").getId());
		
		for(int i = 0; i < getFavByUser.size(); i++){
			if (getFavByUser.get(i).productId == productDao.getAllProducts().get(productDao.getAllProducts().size()-1).getId()){
				System.out.println("-----------------------------------Succes!!!!!!!-----------------------------------");
				return;
			}
		}
		System.out.println("-----------------------------------Eroare!!!!!!!-----------------------------------");
	}
}
