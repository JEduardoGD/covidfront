package egd.covid.covidfront.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egd.covid.covidfront.dto.BusquedaDto;
import egd.covid.covidfront.dto.DomicilioDto;
import egd.covid.covidfront.dto.PersonaDto;
import egd.covid.covidfront.mapper.DomicilioModelMapper;
import egd.covid.covidfront.mapper.PersonaModelMapper;
import egd.covid.covidfront.service.SearchService;
import egd.covid.covidfront.util.ConsultaUtil;
import egd.covid.persistence.component.PersonaEntityManager;
import egd.covid.persistence.entity.table.Domicilio;
import egd.covid.persistence.entity.table.Persona;
import egd.covid.persistence.repository.DomicilioRepository;
import egd.covid.persistence.repository.PersonaRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	DomicilioRepository domicilioRepository;

	@Autowired
	PersonaEntityManager personaEntityManager;

	@Override
	public List<PersonaDto> search(BusquedaDto busquedaDto) {

		List<Persona> personas = personaEntityManager.searchPersona(ConsultaUtil.getNombre(busquedaDto),
				ConsultaUtil.getPrimerApellido(busquedaDto), ConsultaUtil.getSegundoApellido(busquedaDto));

		return personas.stream().map(p -> PersonaModelMapper.getModelMapper().map(p, PersonaDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public PersonaDto searchByIdPersona(long idPersona) {
		Persona persona = personaRepository.findById(idPersona).orElse(null);
		if (persona == null) {
			return null;
		}

		PersonaDto personaDto = PersonaModelMapper.getModelMapper().map(persona, PersonaDto.class);

		if (persona.getDomicilio() != null) {
			Domicilio domicilio = domicilioRepository.findById(persona.getDomicilio().getId()).orElse(null);
			DomicilioDto domicilioDto = DomicilioModelMapper.getModelMapper().map(domicilio, DomicilioDto.class);
			personaDto.setDomicilioDto(domicilioDto);
		}
		return personaDto;
	}
}
