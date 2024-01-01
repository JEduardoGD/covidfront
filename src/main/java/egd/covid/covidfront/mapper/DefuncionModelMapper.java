package egd.covid.covidfront.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import egd.covid.covidfront.dto.DefuncionDto;
import egd.covid.persistence.entity.table.Defuncion;
import egd.covid.persistence.util.StaticValuesHelper;
import lombok.Getter;

public abstract class DefuncionModelMapper extends StaticValuesHelper {

	@Getter
	static ModelMapper modelMapper;

	private static final DateFormat DF = new SimpleDateFormat(HR_DATE, new Locale("es", "MX"));

	static {
		modelMapper = new ModelMapper();
		TypeMap<Defuncion, DefuncionDto> defuncionTypeMap = modelMapper.typeMap(Defuncion.class, DefuncionDto.class);
		
		Converter<Date, String> fechaConverter = ctx -> ctx.getSource() == null ? EMPTY_STRING
				: (DF.format(ctx.getSource()));
		defuncionTypeMap.addMappings(m -> m.using(fechaConverter).map(src -> src.getFecha(), DefuncionDto::setFechaStr));
	}

}
