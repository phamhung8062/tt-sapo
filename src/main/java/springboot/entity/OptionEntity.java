package springboot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "options")
public class OptionEntity extends BaseEntity {
	
	@Column(name = "option_name")
	private String  name;
	
	@Column(name = "option_value")
	private String value;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_id")
    private VersionEntity version;
	
	

	public VersionEntity getVersion() {
		return version;
	}

	public void setVersion(VersionEntity version) {
		this.version = version;
	}

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

	
