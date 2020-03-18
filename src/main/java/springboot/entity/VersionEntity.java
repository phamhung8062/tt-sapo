package springboot.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import annotation.Price;

@Entity
@Table(name = "versions")
public class VersionEntity extends BaseEntity {
	//@NotBlank(message = "VersionName may not be null")
	@Column(name = "version_name")
	private String  name;
	
	//@Price
	@Column(name = "version_price")
	private Integer price;
	
	@Column(name = "version_image")
	private String image;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity products;

	@OneToMany(
	        mappedBy = "version",
	        fetch = FetchType.LAZY
	    )
	private List<OptionEntity> Options = new ArrayList<>();
	
	public List<OptionEntity> getOptions() {
		return Options;
	}

	public void setOptions(List<OptionEntity> options) {
		Options = options;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ProductEntity getProducts() {
		return products;
	}

	public void setProducts(ProductEntity products) {
		this.products = products;
	}
	
	/*@OneToMany(
	        mappedBy = "versiontEntity",
	        fetch = FetchType.LAZY
	    )*/
	/*private List<OptionEntity> Options = new ArrayList<>();*/
	

	

	
	
}

	
