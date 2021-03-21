package org.example.project.domain.model.aggprojeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private Integer id;
    private String titulo;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private Boolean ativo;
    private List<Participacao> participacoes;
    private static int countId = 1;

    public Projeto(String titulo, LocalDate dataInicio, LocalDate dataTermino, Boolean ativo) {
        this.id = countId++;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.setDataTermino(dataTermino);
        this.ativo = ativo;
        this.participacoes = new ArrayList<>();
    }

    public Boolean checkIfDateIsGreaterThanAnotherDate(
            LocalDate dataInicio, LocalDate dataTermino) {
        return dataInicio.isBefore(dataTermino);
    }

    public Boolean checkIfProjectContainsMoreThan10Participations() {
        return this.participacoes.size() > 9;
    }

    public Boolean checkEmployeeIsOnTheListById(Integer idFuncionario) {
        return this.participacoes
                .stream()
                .anyMatch(participacao -> participacao.getIdFuncionario().equals(idFuncionario));
    }

    public Boolean checkIfProjectIsActive(LocalDate dataInicio, LocalDate dataTermino) {
        Boolean check = (this.checkIfDateIsGreaterThanAnotherDate(LocalDate.now(), dataTermino) &&
                         this.checkIfDateIsGreaterThanAnotherDate(dataInicio, LocalDate.now()));
        return check;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        if (!this.checkIfDateIsGreaterThanAnotherDate(this.dataInicio, dataTermino))
            throw new IllegalArgumentException("\n\tErro ao criar projeto com data de fim menor que data de ínicio.");
        this.dataTermino = dataTermino;
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void addParticipacoes(Participacao participacao) {
        if (this.checkIfProjectContainsMoreThan10Participations())
            throw new IllegalArgumentException("\n\tNão é possível registrar mais de 10 participações por projeto.");

        if (this.checkEmployeeIsOnTheListById(participacao.getIdFuncionario()))
            throw new IllegalArgumentException("\n\tNão é possível participação com o mesmo id funcionário.");

        if (!(this.ativo))
            throw new IllegalArgumentException("\n\tNão é possivel registrar participações, projeto não está ativo.");

        this.participacoes.add(participacao);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "\n\tID: "+this.getId()+"" +
                "\n\tTitulo: "+this.getTitulo()+"" +
                "\n\tData Inicio: "+this.getDataInicio()+"" +
                "\n\tData Termino: "+this.getDataTermino()+"" +
                "\n\tATIVO: "+this.getAtivo()+"" +
                "\n\tParticipações: "+this.getParticipacoes()+"";
    }
}
