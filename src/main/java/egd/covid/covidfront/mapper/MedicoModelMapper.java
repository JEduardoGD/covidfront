package egd.covid.covidfront.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import egd.covid.covidfront.dto.MedicoDto;
import egd.covid.persistence.entity.catalogo.Medico;
import egd.covid.persistence.util.StaticValuesHelper;
import lombok.Getter;

public class MedicoModelMapper extends StaticValuesHelper {

	@Getter
	static ModelMapper modelMapper;

	static {
		modelMapper = new ModelMapper();
		TypeMap<Medico, MedicoDto> medicoTypeMap = modelMapper.typeMap(Medico.class, MedicoDto.class);
	}

}
