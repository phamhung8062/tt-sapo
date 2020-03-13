package springboot.dto;

public class VersionDTO extends AbstractDTO<VersionDTO> {

	private String name; 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
