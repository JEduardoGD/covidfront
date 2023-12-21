package egd.covid.covidfront.util;

import egd.covid.covidfront.dto.BusquedaDto;
import egd.covid.covidfront.enums.EnumTipoCoincidencia;

public abstract class ConsultaUtil {
	public static String getNombre(BusquedaDto busquedaDto) {
		EnumTipoCoincidencia tipoCoincidencia = EnumTipoCoincidencia.parse(busquedaDto.getNombreMode());
		return process(tipoCoincidencia, busquedaDto.getNombre());
	}

	public static String getPrimerApellido(BusquedaDto busquedaDto) {
		EnumTipoCoincidencia tipoCoincidencia = EnumTipoCoincidencia.parse(busquedaDto.getPrimerApellidoMode());
		return process(tipoCoincidencia, busquedaDto.getPrimerApellido());
	}

	public static String getSegundoApellido(BusquedaDto busquedaDto) {
		EnumTipoCoincidencia tipoCoincidencia = EnumTipoCoincidencia.parse(busquedaDto.getSegundoApellidoMode());
		return process(tipoCoincidencia, busquedaDto.getSegundoApellido());
	}

	private static String process(EnumTipoCoincidencia tipoCoincidencia, String s) {
		switch (tipoCoincidencia) {
		case EXACTA:
			return s;
		case CONTIENE:
			return "%".concat(s).concat("%");
		case COMIENZA_CON:
			return s.concat("%");
		case TERMINA_CON:
			return "%".concat(s);
		default:
			return null;
		}

	}
}
