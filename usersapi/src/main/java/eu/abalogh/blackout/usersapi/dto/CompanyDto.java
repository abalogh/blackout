package eu.abalogh.blackout.usersapi.dto;

import eu.abalogh.blackout.usersapi.model.UtilityType;

public class CompanyDto {
	private String id;
	private String name;
	private UtilityType utilityType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UtilityType getUtilityType() {
		return utilityType;
	}
	public void setUtilityType(UtilityType utilityType) {
		this.utilityType = utilityType;
	}
	
	
}
