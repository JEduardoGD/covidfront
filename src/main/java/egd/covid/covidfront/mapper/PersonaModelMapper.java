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
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class PersonaModelMapper extends StaticValuesHelper {

	@Getter
	static ModelMapper modelMapper;

	private static final DateFormat DF = new SimpleDateFormat("d-MMMM-yyyy", new Locale("es", "MX"));

	static {
		modelMapper = new ModelMapper();
		TypeMap<Persona, PersonaDto> typeMap = modelMapper.typeMap(Persona.class, PersonaDto.class);
		typeMap.addMappings(mapper -> {
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

		Converter<Character, String> sexoConverter = ctx -> ctx.getSource() == null ? null
				: (ctx.getSource().charValue() == CHAR_M ? StaticValuesHelper.MASCULINO
						: (ctx.getSource().equals(CHAR_F) ? FEMENINO : EMPTY_STRING));

		Converter<Character, String> nacionalidadConverter = ctx -> ctx.getSource() == null ? null
				: (ctx.getSource().charValue() == CHAR_M ? StaticValuesHelper.MEXICANA
						: (ctx.getSource().equals(CHAR_E) ? EXTRANJERO : EMPTY_STRING));

		typeMap.addMappings(m -> m.using(sexoConverter).map(src -> src.getSexo(), PersonaDto::setSexoDto));
		typeMap.addMappings(m -> m.using(nacionalidadConverter).map(src -> src.getNacionalidad(), PersonaDto::setNacionalidadDto));
	}
}
