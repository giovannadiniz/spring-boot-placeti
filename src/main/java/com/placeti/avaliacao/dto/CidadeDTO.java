package com.placeti.avaliacao.dto;

import com.placeti.avaliacao.model.Cidade;

import lombok.Data;
import lombok.NoArgsConstructor;

//-------------------------------------------------
/** DTO que guarda os dados de uma cidade */
//-------------------------------------------------
@Data
@NoArgsConstructor
public class CidadeDTO {

	//---------------------------------------
	// Atributos do DTO
	//---------------------------------------
    private Long id;
    private String nome;
    private String uf;
    private Boolean capital;
    
    
    //-----------------------------------------------
    /** Carrega o DTO com dados da entidade */
    //-----------------------------------------------
    public static CidadeDTO toDTO(Cidade cidade) {
    	return null;
    }
}
