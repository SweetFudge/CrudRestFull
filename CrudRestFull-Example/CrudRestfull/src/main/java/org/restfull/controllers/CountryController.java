
package org.restfull.controllers;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.restfull.beans.Country;
import org.restfull.services.CountryService;

@Path("Countries")
public class CountryController {
	CountryService countryService = new CountryService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCountries(){
		return countryService.getCountries();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCountryByID")
	public Country getCountryById(@QueryParam("id") int id){
		Country country = countryService.getCountryById(id);
		return country;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country)
	{
		return countryService.addCountry(country);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country)
	{
		return countryService.updateCountry(country);

	}

	@DELETE
	@Path("/deleteCountryByID")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@QueryParam("id") int id)
	{
		countryService.deleteCountry(id);

	}
}
