package springboot.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "versions")
public class VersionEntity extends BaseEntity {
	
	@Column(name = "version_name")
	private String  name;
	
	@OneToMany(
	        mappedBy = "versions",
	        fetch = FetchType.LAZY
	    )
	private List<ProductEntity> Products = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductEntity> getProduct() {
		return Products;
	}

	public void setProduct(List<ProductEntity> products) {
		Products = products;
	}

	
}

	
