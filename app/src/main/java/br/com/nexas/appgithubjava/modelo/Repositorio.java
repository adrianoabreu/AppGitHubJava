package br.com.nexas.appgithubjava.modelo;

import java.io.Serializable;

/**
 * Created by user on 02/11/2017.
 */

public class Repositorio implements Serializable {

    private String nomeRepositorio;
    private String descRepositorio;
    private String imagemRepositorio;
    private String username;
    private String nomeSobrenome;
    private int    numeroEstrelas;
    private int    numeroForks;


    public String getNomeRepositorio() {
        return nomeRepositorio;
    }

    public void setNomeRepositorio(String nomeRepositorio) {
        this.nomeRepositorio = nomeRepositorio;
    }

    public String getDescRepositorio() {
        return descRepositorio;
    }

    public void setDescRepositorio(String descRepositorio) {
        this.descRepositorio = descRepositorio;
    }

    public String getImagemRepositorio() {
        return imagemRepositorio;
    }

    public void setImagemRepositorio(String imagemRepositorio) {
        this.imagemRepositorio = imagemRepositorio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        this.nomeSobrenome = nomeSobrenome;
    }

    public int getNumeroEstrelas() {
        return numeroEstrelas;
    }

    public void setNumeroEstrelas(int numeroEstrelas) {
        this.numeroEstrelas = numeroEstrelas;
    }

    public int getNumeroForks() {
        return numeroForks;
    }

    public void setNumeroForks(int numeroForks) {
        this.numeroForks = numeroForks;
    }
}
