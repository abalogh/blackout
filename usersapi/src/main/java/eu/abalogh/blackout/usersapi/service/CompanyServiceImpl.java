package eu.abalogh.blackout.usersapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.abalogh.blackout.usersapi.model.Company;
import eu.abalogh.blackout.usersapi.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

}
