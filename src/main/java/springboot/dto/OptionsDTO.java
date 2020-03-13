package springboot.dto;

public class OptionsDTO extends AbstractDTO<OptionsDTO> {

	private String name; 
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	} 
	
	
	
}
