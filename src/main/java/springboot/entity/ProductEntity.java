package springboot.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import annotation.Battery;
import annotation.Camera;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	
	//@NotBlank(message = "Name Product may not be null")
	@Column(name = "product_name")
	private String name;

	@Column(name = "product_ram")
	private Integer ram;
	
	//@NotBlank(message = "CPU may not be null")
	@Column(name = "product_cpu")
	private String cpu;
	
	//@NotBlank(message = "GPU may not be null")
	@Column(name = "product_gpu")
	private String gpu; 
	
	//@NotBlank(message = "IMAGE may not be null")
	@Column(name = "product_image")
	private String image;
	
	//@NotBlank(message = "display may not be null")
	@Column(name = "product_display")
	private String display;
	
	//@Camera
	@Column(name = "product_camera")
	private String camera;
	
	//@NotNull(message = "amount may not be null")
	@Column(name = "product_amount")
	private Integer amount; 
	
	//@NotNull(message = "status may not be null")
	@Column(name = "product_status")
	private Integer status; 
	
	//@Battery
	@Column(name = "product_battery")
	private String battery; 
	
	
	@OneToMany(
	        mappedBy = "products",
	        fetch = FetchType.LAZY
	    )
	private List<VersionEntity> versions = new ArrayList<>();
	

	public List<VersionEntity> getVersions() {
		return versions;
	}

	public void setVersions(List<VersionEntity> versions) {
		this.versions = versions;
	}

	public String getName() {
		return name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

}
