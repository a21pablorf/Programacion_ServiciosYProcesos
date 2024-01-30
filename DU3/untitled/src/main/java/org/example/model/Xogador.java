package org.example.model;

import jakarta.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Xogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "dorsal", nullable = false)
    private int dorsal;

    public Xogador(String nome, int dorsal) {
        this.nome = nome;
        this.dorsal = dorsal;
    }
    @Id
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Xogador() {
    }
}
