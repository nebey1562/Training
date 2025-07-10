package com.litmus7.retailproductcatalog.service;

import java.util.List;

import com.litmus7.retailproductcatalog.dao.ProductDAO;
import com.litmus7.retailproductcatalog.dao.ProductDAOImpl;
import com.litmus7.retailproductcatalog.dto.Product;
import com.litmus7.retailproductcatalog.exception.ProductDataAccessException;
import com.litmus7.retailproductcatalog.exception.RetailProductServiceException;

public class ProductService {
	private ProductDAO productDAO = new ProductDAOImpl();

	/**
	 * Adds a new product to the system after checking for duplicate IDs.
	 *
	 * @param product the product to add
	 * @return the added product
	 * @throws RetailProductServiceException if a product with the same ID exists or
	 *                                       if a data access error occurs
	 */
	public Product addProduct(Product product) throws RetailProductServiceException {
		try {
			if (productDAO.getProductById(product.getId()) != null) {
				throw new RetailProductServiceException("Product with the Id exists");
			}
			Product addedProduct = productDAO.addProduct(product);
			return addedProduct;
		} catch (ProductDataAccessException e) {
			throw new RetailProductServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param productId the ID of the product
	 * @return the product if found
	 * @throws RetailProductServiceException if the product does not exist or if a
	 *                                       data access error occurs
	 */
	public Product getProductById(int productId) throws RetailProductServiceException {
		try {
			Product product = productDAO.getProductById(productId);
			if (product == null) {
				throw new RetailProductServiceException("Product with the Id " + productId + " doesn't exist");
			}
			return product;
		} catch (ProductDataAccessException e) {
			throw new RetailProductServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Retrieves all products from the system.
	 *
	 * @return a list of all products
	 * @throws RetailProductServiceException if no products are available or if a
	 *                                       data access error occurs
	 */
	public List<Product> getAllProducts() throws RetailProductServiceException {
		try {
			List<Product> products = productDAO.getAllProducts();
			if (!products.isEmpty()) {
				return productDAO.getAllProducts();
			} else {
				throw new RetailProductServiceException("No products available in the database");
			}
		} catch (ProductDataAccessException e) {
			throw new RetailProductServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Updates the details of an existing product.
	 *
	 * @param product the product with updated details
	 * @return the updated product
	 * @throws RetailProductServiceException if a data access error occurs
	 */
	public Product updateProduct(Product product) throws RetailProductServiceException {
		try {
			return productDAO.updateProduct(product);
		} catch (ProductDataAccessException e) {
			throw new RetailProductServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param productId the ID of the product to delete
	 * @return the ID of the deleted product
	 * @throws RetailProductServiceException if the product doesn't exist or if a
	 *                                       data access error occurs
	 */
	public int deleteProductById(int productId) throws RetailProductServiceException {
		try {
			if (productDAO.getProductById(productId) == null) {
				throw new RetailProductServiceException("Product with the Id " + productId + " doesn't exist");
			}
			return productDAO.deleteProductById(productId);
		} catch (ProductDataAccessException e) {
			throw new RetailProductServiceException(e.getMessage(), e);
		}
	}
}
