package egd.covid.covidfront.dto;

import java.io.Serializable;

import egd.covid.persistence.util.StaticValuesHelper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DefuncionDto extends StaticValuesHelper implements Serializable {
	private static final long serialVersionUID = 5344341660000771205L;
	private String fechaStr;
	private Long semana;
	private String certificado;
	private String verificado;
}
