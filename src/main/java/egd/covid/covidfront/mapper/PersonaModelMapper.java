package egd.covid.covidfront.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.modelmapper.ModelMapper;

import egd.covid.covidfront.dto.PersonaDto;
import egd.covid.persistence.entity.table.Persona;
import egd.covid.persistence.util.StaticValuesHelper;
import lombok.Getter;

public abstract class PersonaModelMapper extends StaticValuesHelper {

	@Getter
	static ModelMapper modelMapper;

	private static final DateFormat DF = new SimpleDateFormat("d-MMMM-yyyy", new Locale("es", "MX"));

	static {
		modelMapper = new ModelMapper();
		modelMapper.typeMap(Persona.class, PersonaDto.class).addMappings(mapper -> {
			mapper.map(src -> {
				Character sexo = src.getSexo();
				if (sexo == null) {
					return StaticValuesHelper.EMPTY_STRING;
				}
				return sexo.equals(StaticValuesHelper.CHAR_M) ? StaticValuesHelper.MASCULINO
						: (sexo.equals(StaticValuesHelper.CHAR_F) ? StaticValuesHelper.FEMENINO
								: StaticValuesHelper.EMPTY_STRING);
			}, PersonaDto::setSexoDto);
			mapper.map(src -> src.getCurp(), PersonaDto::setCurp);
			mapper.map(src -> {
				Date fechaNacimiento = src.getFechaNacimiento();
				if (fechaNacimiento == null) {
					return StaticValuesHelper.EMPTY_STRING;
				}
				return DF.format(src.getFechaNacimiento());
			}, PersonaDto::setFechaNacimiento);
			mapper.map(src -> {
				Long edad = src.getEdad();
				if (edad == null) {
					return StaticValuesHelper.EMPTY_STRING;
				}
				return edad.toString();
			}, PersonaDto::setEdadDto);
			mapper.map(src -> {
				Character nacionalidad = src.getNacionalidad();
				return nacionalidad.equals(Character.valueOf(StaticValuesHelper.CHAR_N)) ? StaticValuesHelper.MEXICANA
						: (nacionalidad.equals(Character.valueOf(StaticValuesHelper.CHAR_N))
								? StaticValuesHelper.EXTRANJERO
								: StaticValuesHelper.EMPTY_STRING);

			}, PersonaDto::setNacionalidadDto);
		});
	}
}
