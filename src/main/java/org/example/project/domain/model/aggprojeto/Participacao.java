package org.example.project.domain.model.aggprojeto;

import java.time.LocalDate;

public class Participacao {
    private Integer id;
    private Integer idFuncionario;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private static int countId = 1;

    public Participacao(Integer idFuncionario, LocalDate dataInicio, LocalDate dataTermino) {
        this.id = countId++;
        this.idFuncionario = idFuncionario;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public String toString() {
        return "\n\t\tID: "+this.getId()+"" +
                "\n\t\tID Funcionário: "+this.getIdFuncionario()+"" +
                "\n\t\tData Inicio: "+this.getDataInicio()+"" +
                "\n\t\tData Termino: "+this.getDataTermino()+"";
    }
}
