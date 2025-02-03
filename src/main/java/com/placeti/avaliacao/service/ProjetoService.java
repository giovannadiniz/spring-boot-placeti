package com.placeti.avaliacao.service;

import com.placeti.avaliacao.dto.CidadeDTO;
import com.placeti.avaliacao.model.Cidade;
import com.placeti.avaliacao.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//------------------------------------------------------------------
/** Service usado para acessar os repositórios da aplicação */
//------------------------------------------------------------------
@Service
public class ProjetoService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Optional<Cidade> buscarCidadePorId(Long id) {
        return cidadeRepository.findById(id);
    }

    public List<CidadeDTO> pesquisarCidades() {
        List<Cidade> cidades = cidadeRepository.findAll();
        return cidades.stream().map(CidadeDTO::new)
            .collect(Collectors.toList());
    }


	public void incluirCidade(CidadeDTO dto) {
        Cidade cidade = new Cidade();

        cidade.setNome(dto.getNome());
        cidade.setUf(dto.getUf());
        cidade.setCapital(dto.isCapital());

        cidadeRepository.save(cidade);
	}

	public Cidade alterarCidade(CidadeDTO dto) {
        Cidade cidade = cidadeRepository.findById(dto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade nao encontrada."));

        cidade.setNome(dto.getNome());
        cidade.setUf(dto.getUf());
        cidade.setCapital(dto.isCapital());

        return cidadeRepository.save(cidade);
    }


	public void excluirCidade(Long idCidade)
    {
        cidadeRepository.deleteById(idCidade);
	}
}
