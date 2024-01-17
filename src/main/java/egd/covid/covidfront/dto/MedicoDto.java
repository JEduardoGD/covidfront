package egd.covid.covidfront.dto;

import java.io.Serializable;

import egd.covid.persistence.util.StaticValuesHelper;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedicoDto extends StaticValuesHelper implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 3961751865179126310L;

	private Integer embarazo;
	private Long mesesemb;
	private Integer fiebre;
	private Integer tos;
	private Integer odinogia;
	private Integer disnea;
	private Integer irritabi;
	private Integer diarrea;
	private Integer dotoraci;
	private Integer calosfrios;
	private Integer cefalea;
	private Integer mialgias;
	private Integer artral;
	private Integer ataedoge;
	private Integer rinorrea;
	private Integer polipnea;
	private Integer vomito;
	private Integer dolabdo;
	private Integer conjun;
	private Integer cianosis;
	private Integer inisubis;
	private Integer anosmia;
	private Integer disgeusia;
	private Integer asintomatico;
	private Integer diabetes;
	private Integer epoc;
	private Integer asma;
	private Integer inmunosuprimido;
	private Integer hipertension;
	private Integer vih_sida;
	private Integer otracondicion;
	private Integer enfermedadcardiaca;
	private Integer obesidad;
	private Integer insrencr;
	private Integer tabaquismo;
	private Integer rectrata;
	private Integer txcrobia;
	private Integer txantivi;
	private String antivir;
}
