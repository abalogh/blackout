package eu.abalogh.blackout.usersapi.model;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UtilityType {
	ELECTRICITY(1), GAS(2), WATER(3), WASTEWATER(4), INTERNET(5), WASTEMANAGEMENT(6),CABLETV(7);

	private final Integer code;

	private UtilityType(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
	
	public String getName() {
		return name();
	}

	public static UtilityType fromCode(Integer code) {
		return Stream.of(UtilityType.values()).filter(utEnum -> utEnum.getCode().equals(code)).findFirst().orElse(null);
	}
}
