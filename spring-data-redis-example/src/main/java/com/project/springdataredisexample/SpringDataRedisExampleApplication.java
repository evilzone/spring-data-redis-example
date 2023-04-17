package com.project.springdataredisexample;

import com.project.springdataredisexample.entity.Product;
import com.project.springdataredisexample.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController("/product")
public class SpringDataRedisExampleApplication {

	@Autowired
	private ProductDao productDao;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return productDao.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@GetMapping("{id}")
	public Product getProduct(@PathVariable(value = "id") int id) {
		return productDao.findById(id);
	}

	@DeleteMapping("{id}")
	public String deleteProduct(@PathVariable(value = "id") int id) {
		return productDao.deleteProduct(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisExampleApplication.class, args);
	}

}
