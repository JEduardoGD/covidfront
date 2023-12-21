package egd.covid.covidfront.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusquedaDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7201086354195811524L;
	private String nombre;
	private int nombreMode;
	private String primerApellido;
	private int primerApellidoMode;
	private String segundoApellido;
	private int segundoApellidoMode;
}
