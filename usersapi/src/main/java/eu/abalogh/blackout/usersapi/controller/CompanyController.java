package eu.abalogh.blackout.usersapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.abalogh.blackout.usersapi.bl.CompanyBl;
import eu.abalogh.blackout.usersapi.dto.CompanyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyBl companyBl;
	
	
	@PreAuthorize("hasRole('user')")
	@Operation(summary = "List all companies", security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List of companies", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDto.class))) })
	@GetMapping("/")
	public List<CompanyDto> listCompanies() {
		return companyBl.getAllCompanies();
	}
}
