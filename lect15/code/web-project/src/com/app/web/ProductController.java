package com.app.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.Product;
import com.app.repo.JDBCProductRepository;
import com.app.repo.ProductRepository;

@WebServlet(urlPatterns = { "/products" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductRepository productRepository;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ProductController :: init()");
		productRepository = new JDBCProductRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ProductController :: doGet()");
		List<Product> products = productRepository.getAll();
		
		System.out.println(products.size());
		
		req.setAttribute("products", products);
		req.getRequestDispatcher("/view_products.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("ProductController :: destroy()");
	}

	

}
