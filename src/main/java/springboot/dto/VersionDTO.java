package springboot.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import annotation.Price;

public class VersionDTO extends AbstractDTO<VersionDTO> {
	
	@Price
	private Integer price;
	
	@NotBlank(message = "VersionName1111 may not be null")
	private String name;
	
	private List<OptionsDTO> options;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<OptionsDTO> getOptions() {
		return options;
	}

	public void setOptions(List<OptionsDTO> options) {
		this.options = options;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
