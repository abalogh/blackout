package eu.abalogh.blackout.usersapi.bl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.abalogh.blackout.usersapi.dto.CompanyDto;
import eu.abalogh.blackout.usersapi.model.Company;
import eu.abalogh.blackout.usersapi.service.CompanyService;

@Component
public class CompanyBl {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CompanyService companyService;

	public List<CompanyDto> getAllCompanies() {
		List<Company> allCompanies = companyService.getAllCompanies();
		return allCompanies.stream().map(c -> convertToDto(c)).collect(Collectors.toList());
	}

	public CompanyDto convertToDto(Company c) {
		return modelMapper.map(c, CompanyDto.class);
	}
}
