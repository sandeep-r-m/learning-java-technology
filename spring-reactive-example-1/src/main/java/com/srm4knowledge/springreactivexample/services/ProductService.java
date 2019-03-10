package com.srm4knowledge.springreactivexample.services;

import java.util.List;

import com.srm4knowledge.springreactivexample.controllers.resources.ProductResource;

public interface ProductService {

	public List<ProductResource> fetchAllProduct();

}
