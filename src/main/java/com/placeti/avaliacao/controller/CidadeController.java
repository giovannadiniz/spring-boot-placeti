package com.placeti.avaliacao.controller;

import com.placeti.avaliacao.dto.CidadeDTO;
import com.placeti.avaliacao.model.Cidade;
import com.placeti.avaliacao.service.ProjetoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//--------------------------------------------------
/** Endpoint para consultar e manter cidades */
//--------------------------------------------------
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private ProjetoService projetoService;

    // TODO: Responde GET em http://localhost:8080/placeti/cidades/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cidade buscarCidadePorId(@PathVariable("id") Long id) {
        return projetoService.buscarCidadePorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada!"));
    }

    // TODO: Responde POST em http://localhost:8080/placeti/cidades
    @PostMapping
    public void incluirCidade(@RequestBody CidadeDTO cidadeDTO) {
        projetoService.incluirCidade(cidadeDTO);
    }

    // TODO: Responde GET em http://localhost:8080/placeti/cidades
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CidadeDTO> pesquisarCidades() {
        return projetoService.pesquisarCidades();
    }

    // TODO: Responde PUT em http://localhost:8080/placeti/cidades
    @PutMapping
    public void alterarCidade(@RequestBody CidadeDTO cidadeDto)  {
        projetoService.alterarCidade(cidadeDto);
    }

    // TODO: Responde PUT em http://localhost:8080/placeti/cidades/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCidade(@PathVariable("id") Long idCidade) {
        projetoService.buscarCidadePorId(idCidade)
                .map(cidade -> {
                    projetoService.excluirCidade(cidade.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade nao encontrada."));
    }
}