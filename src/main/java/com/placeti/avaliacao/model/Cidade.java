package com.placeti.avaliacao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//-------------------------------------------------
/** Entidade que guarda os dados de uma cidade */
//-------------------------------------------------
@Data
@NoArgsConstructor
@Entity
@Table(name = "Cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "UF", length = 100, nullable = false)
    private String uf;

    @Column(name = "capital", nullable = false)
    private Boolean capital;

//    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comercio> comercios;

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }
}
