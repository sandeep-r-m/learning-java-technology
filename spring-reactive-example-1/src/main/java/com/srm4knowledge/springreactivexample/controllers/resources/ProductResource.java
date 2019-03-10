package com.srm4knowledge.springreactivexample.controllers.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResource {

	private Long id;

	private String name;

	private String desc;

	public static ProductResource newInstance(String name, String desc) {
		ProductResource pr = new ProductResource();
		pr.setName(name);
		pr.setDesc(desc);
		return pr;
	}

}
