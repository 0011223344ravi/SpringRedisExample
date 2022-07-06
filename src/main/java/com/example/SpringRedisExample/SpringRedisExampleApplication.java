package com.example.SpringRedisExample;

import com.example.SpringRedisExample.entity.Product;
import com.example.SpringRedisExample.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringRedisExampleApplication {

	@Autowired
	private ProductDao dao;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return dao.findProductById(id);
	}
	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id)   {
		return dao.deleteProduct(id);
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringRedisExampleApplication.class, args);
	}

}
