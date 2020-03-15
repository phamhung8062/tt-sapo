package springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.ProductDTO;
import springboot.service.IProductService;

@CrossOrigin
@RestController

public class ProductAPI {
	@Autowired
	private IProductService productservice;
	
	
	@GetMapping(value="api/products")
	public List<ProductDTO> listProducts() {
		return  productservice.findAll();
	}
	
	@PostMapping(value="api/insert/product")
	public void save( @RequestBody ProductDTO dto) {
		 productservice.save(dto);
	}
	
	@PutMapping(value="api/update/product")
	public void update( @RequestBody ProductDTO dto) {
		 productservice.update(dto);
	}
	
	@DeleteMapping(value="api/delete/product")
	public void delete(@RequestParam Long id) {
		 productservice.delete(id);
	}
	
	@GetMapping(value="api/product")
	public ProductDTO Product(@RequestParam Long id) {
		return  productservice.findById(id);
	}


}
