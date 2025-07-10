package com.litmus7.retailproductcatalog.util;

public class AppConstants {
	public static final String PRODUCT_ID = "product_id";
	/**
	 * Column name for the product name.
	 */
	public static final String PRODUCT_NAME = "name";
	/**
	 * Column name for the product category.
	 */
	public static final String PRODUCT_CATEGORY = "category";
	/**
	 * Column name for the product price.
	 */
	public static final String PRODUCT_PRICE = "price";
	/**
	 * Column name for the stock quantity.
	 */
	public static final String STOCK_QUANTITY = "stock_quantity";
	/**
     * The name of the properties file that contains database configuration.
     */
	public static final String DB_PROPERTIES_FILE = "db.properties";
    /**
     * The key used to retrieve the database URL from the properties file.
     */
	public static final String DB_URL_KEY = "dburl";
    /**
     * The key used to retrieve the database username from the properties file.
     */
	public static final String DB_USERNAME_KEY = "username";
    /**
     * The key used to retrieve the database password from the properties file.
     */
	public static final String DB_PASSWORD_KEY = "password";
	/**
	 * Response code indicating a successful operation.
	 */
	public static final int SUCCESS_CODE = 200;
	/**
	 * Response code indicating an internal server error or general failure.
	 */
	public static final int ERROR_CODE = 400;
	
	/**
	 * SQL query to insert a new product into the database. Expects four parameters: name, category, price, and stock_quantity.
	 */
	public static final String INSERT_PRODUCT = "INSERT INTO products (product_id, name, category, price, stock_quantity) VALUES (?, ?, ?, ?, ?)";

	/**
	 * SQL query to retrieve a product from the database by id.
	 */
	public static final String GET_PRODUCT_BY_ID = "SELECT product_id, name, category, price, stock_quantity FROM products WHERE product_id = ?";
	
	/**
	 * SQL query to retrieve all products from the database.
	 */
	public static final String GET_ALL_PRODUCTS = "SELECT product_id, name, category, price, stock_quantity FROM products";
	
	/**
	 * SQL query to update product info in the database.
	 */
	public static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, category = ?, price = ?, stock_quantity = ? WHERE product_id = ?";
	
	/**
	 * SQL query to delete product data in the database.
	 */
	public static final String DELETE_PRODUCT_BY_ID = "DELETE FROM products WHERE product_id = ?";
}
