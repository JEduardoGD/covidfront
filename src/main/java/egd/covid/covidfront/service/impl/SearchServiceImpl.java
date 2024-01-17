package egd.covid.covidfront.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egd.covid.covidfront.dto.BusquedaDto;
import egd.covid.covidfront.dto.DefuncionDto;
import egd.covid.covidfront.dto.DomicilioDto;
import egd.covid.covidfront.dto.MedicoDto;
import egd.covid.covidfront.dto.PersonaDto;
import egd.covid.covidfront.mapper.DefuncionModelMapper;
import egd.covid.covidfront.mapper.DomicilioModelMapper;
import egd.covid.covidfront.mapper.MedicoModelMapper;
import egd.covid.covidfront.mapper.PersonaModelMapper;
import egd.covid.covidfront.service.SearchService;
import egd.covid.covidfront.util.ConsultaUtil;
import egd.covid.persistence.component.PersonaEntityManager;
import egd.covid.persistence.entity.catalogo.Entidad;
import egd.covid.persistence.entity.catalogo.Localidad;
import egd.covid.persistence.entity.catalogo.Medico;
import egd.covid.persistence.entity.catalogo.Municipio;
import egd.covid.persistence.entity.table.Defuncion;
import egd.covid.persistence.entity.table.Domicilio;
import egd.covid.persistence.entity.table.Persona;
import egd.covid.persistence.repository.DefuncionRepository;
import egd.covid.persistence.repository.DomicilioRepository;
import egd.covid.persistence.repository.EntidadRepository;
import egd.covid.persistence.repository.LocalidadRepository;
import egd.covid.persistence.repository.MedicoRepository;
import egd.covid.persistence.repository.MunicipioRepository;
import egd.covid.persistence.repository.PersonaRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired PersonaRepository   personaRepository;
	@Autowired DomicilioRepository domicilioRepository;
	@Autowired DefuncionRepository defuncionRepository;
	@Autowired LocalidadRepository localidadRepository;
	@Autowired MunicipioRepository municipioRepository;
	@Autowired EntidadRepository   entidadRepository;
	@Autowired MedicoRepository    medicoRepository;

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

			if (domicilio.getLocalidad() != null) {
				Localidad localidad = localidadRepository.findById(domicilio.getLocalidad().getId()).orElse(null);
				domicilioDto.setLocalidad(localidad.getLocalidad());
			}

			if (domicilio.getMunicipioResidencia() != null) {
				Municipio municipio = municipioRepository.findById(domicilio.getMunicipioResidencia().getId())
						.orElse(null);
				domicilioDto.setMunicipio(municipio.getMunicipio());
			}

			if (domicilio.getEntidad() != null) {
				Entidad entidad = entidadRepository.findById(domicilio.getEntidad().getId()).orElse(null);
				domicilioDto.setEntidad(entidad.getDescripcion());
			}

			personaDto.setDomicilioDto(domicilioDto);
		}

		if (persona.getDefuncion() != null) {
			Defuncion defuncion = defuncionRepository.findById(persona.getDefuncion().getId()).orElse(null);
			DefuncionDto defunciondto = DefuncionModelMapper.getModelMapper().map(defuncion, DefuncionDto.class);
			personaDto.setDefuncionDto(defunciondto);
		}

		return personaDto;
	}

	@Override
	public MedicoDto searchMedicoByIdPersona(long idPersona) {
		Medico medico = medicoRepository.getMedicoByIdPersona(idPersona);
		if (medico == null) {
			return null;
		}
		return MedicoModelMapper.getModelMapper().map(medico, MedicoDto.class);
	}
}
