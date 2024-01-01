package egd.covid.covidfront.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import egd.covid.covidfront.dto.DomicilioDto;
import egd.covid.persistence.entity.table.Domicilio;
import egd.covid.persistence.util.StaticValuesHelper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class DomicilioModelMapper extends StaticValuesHelper {

	@Getter
	static ModelMapper modelMapper;
	static {
		modelMapper = new ModelMapper();
		TypeMap<Domicilio, DomicilioDto> domicilioTypeMap = modelMapper.typeMap(Domicilio.class, DomicilioDto.class);
	}
}
