package com.alvimlops.erp.model;

public enum TipoEmpresa {

	MEI("Microemprendedor Individual"), EIRELI("Empresa Individual de Responsavilidade Limitada"),
	LTDA("Sociedade Limitada"), SA("Sociedade Anonima");

	private String descricao;

	TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
