package egd.covid.covidfront.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import egd.covid.covidfront.dto.PersonaDto;
import egd.covid.persistence.entity.table.Persona;
import egd.covid.persistence.util.StaticValuesHelper;
import lombok.Getter;

public abstract class PersonaModelMapper extends StaticValuesHelper {

	@Getter
	static ModelMapper modelMapper;

	private static final DateFormat DF = new SimpleDateFormat(DDMMYYYY, new Locale("es", "MX"));

	static {
		modelMapper = new ModelMapper();
		TypeMap<Persona, PersonaDto> personaTypeMap = modelMapper.typeMap(Persona.class, PersonaDto.class);
		/*
		personaTypeMap.addMappings(mapper -> {
			mapper.map(src -> {
				Long edad = src.getEdad();
				if (edad == null) {
					return StaticValuesHelper.EMPTY_STRING;
				}
				return edad.toString();
			}, PersonaDto::setEdadDto);
		});
		*/
		Converter<Date, String> edadConverter = ctx -> ctx.getSource() == null ? EMPTY_STRING
				: (DF.format(ctx.getSource()));
		personaTypeMap.addMappings(m -> m.using(edadConverter).map(src -> src.getFechaNacimiento(), PersonaDto::setFechaNacimiento));

		Converter<Character, String> sexoConverter = ctx -> ctx.getSource() == null ? null
				: (ctx.getSource().charValue() == CHAR_M ? StaticValuesHelper.MASCULINO
						: (ctx.getSource().equals(CHAR_F) ? FEMENINO : EMPTY_STRING));
		personaTypeMap.addMappings(m -> m.using(sexoConverter).map(src -> src.getSexo(), PersonaDto::setSexoDto));
		Converter<Character, String> nacionalidadConverter = ctx -> ctx.getSource() == null ? null
				: (ctx.getSource().charValue() == CHAR_M ? StaticValuesHelper.MEXICANA
						: (ctx.getSource().equals(CHAR_E) ? EXTRANJERO : EMPTY_STRING));
		personaTypeMap.addMappings(
				m -> m.using(nacionalidadConverter).map(src -> src.getNacionalidad(), PersonaDto::setNacionalidadDto));
	}
}