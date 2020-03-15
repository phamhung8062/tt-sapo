package springboot.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import annotation.Battery;
import annotation.Camera;
public class ProductDTO extends AbstractDTO<ProductDTO> {
	
	//@NotBlank(message = "Name Product may not be null")
	private String name;
	
	private Integer ram;
	
	//@NotBlank(message = "CPU may not be null")
	private String cpu;
	
	//@NotBlank(message = "GPU may not be null")
	private String gpu; 
	
	//@NotBlank(message = "IMAGE may not be null")
	private String image;
	
	//@NotBlank(message = "display may not be null")
	private String display;
	
	//@Camera
	private String camera;
	
	//@NotNull(message = "amount may not be null")
	private Integer amount; 
	
	//@NotNull(message = "status may not be null")
	private Integer status; 
	
	//@Battery
	private String battery; 

	private	List<VersionDTO> version;

	public List<VersionDTO> getVersion() {
		return version;
	}
	public void setVersion(List<VersionDTO> version) {
		this.version = version;
	}
	public String getName() {
		return name;
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
}
