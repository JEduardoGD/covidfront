package egd.covid.covidfront.service;

import java.util.List;

import egd.covid.covidfront.dto.BusquedaDto;
import egd.covid.covidfront.dto.PersonaDto;

public interface SearchService {

	List<PersonaDto> search(BusquedaDto busquedaDto);

}
