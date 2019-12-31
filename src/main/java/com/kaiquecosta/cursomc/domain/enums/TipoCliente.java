package com.kaiquecosta.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;
	
	/*
	 * Construtores TipoCliente
	 */
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	/*
	 * Verifica há existencia do codigo TipoCliente
	 * @throws IllegalAccessException
	 */
	public static TipoCliente toEnum(Integer cod) throws IllegalAccessException {
		if(cod != null) {
			for(TipoCliente cliente : TipoCliente.values()) {
				if(cod.equals(cliente.cod)) {
					return cliente;
				}else 
					throw new IllegalAccessException("Id inválido: " + cod);
			}
		}
		
		return null;
	}
	
	/*
	 * Getters e Seters Cidade
	 */
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
}