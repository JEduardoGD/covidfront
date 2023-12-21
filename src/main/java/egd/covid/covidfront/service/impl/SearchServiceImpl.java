package egd.covid.covidfront.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egd.covid.covidfront.dto.BusquedaDto;
import egd.covid.covidfront.dto.PersonaDto;
import egd.covid.covidfront.service.SearchService;
import egd.covid.covidfront.util.ConsultaUtil;
import egd.covid.persistence.component.PersonaEntityManager;
import egd.covid.persistence.entity.table.Persona;
import egd.covid.persistence.repository.PersonaRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	PersonaEntityManager personaEntityManager;

	@Override
	public List<PersonaDto> search(BusquedaDto busquedaDto) {

		List<Persona> personas = personaEntityManager.searchPersona(ConsultaUtil.getNombre(busquedaDto),
				ConsultaUtil.getPrimerApellido(busquedaDto), ConsultaUtil.getSegundoApellido(busquedaDto));

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.typeMap(Persona.class, PersonaDto.class).addMappings(mapper -> {
			mapper.map(src -> src.getId(), PersonaDto::setId);
			mapper.map(src -> src.getNombre(), PersonaDto::setNombre);
			mapper.map(src -> src.getPrimerApellido(), PersonaDto::setPrimerApellido);
			mapper.map(src -> src.getSegundoApellido(), PersonaDto::setSegundoApellido);
		});
		return personas.stream().map(p -> modelMapper.map(p, PersonaDto.class)).limit(100).collect(Collectors.toList());

	}
}
