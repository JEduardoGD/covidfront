package egd.covid.covidfront.enums;

import lombok.Getter;

public enum EnumTipoCoincidencia {
	EXACTA(0), CONTIENE(1), COMIENZA_CON(2), TERMINA_CON(3);

	@Getter
	private int entero;

	EnumTipoCoincidencia(int entero) {
		this.entero = entero;
	}

	public static EnumTipoCoincidencia parse(int entero) {
		switch (entero) {
		case 0:
			return EXACTA;
		case 1:
			return CONTIENE;
		case 2:
			return COMIENZA_CON;
		case 3:
			return TERMINA_CON;
		default:
			return null;
		}
	}

}
