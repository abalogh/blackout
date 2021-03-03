package eu.abalogh.blackout.usersapi.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

	@Id
	public UUID id;

	@Column(name = "name", nullable = false, unique = false)
	private String name;
	
	@Column(name = "utility_type", nullable = false, unique = false)
	private Integer utilityType;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUtilityType() {
		return utilityType;
	}

	public void setUtilityType(Integer utilityType) {
		this.utilityType = utilityType;
	}
}
