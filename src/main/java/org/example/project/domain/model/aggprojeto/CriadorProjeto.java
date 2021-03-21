package org.example.project.domain.model.aggprojeto;

import java.time.LocalDate;

public class CriadorProjeto {
    private Projeto projeto;

    public CriadorProjeto para(String titulo, LocalDate dataInicio, LocalDate dataTermino, Boolean ativo) {
        this.projeto = new Projeto(titulo, dataInicio, dataTermino, ativo);
        return this;
    }

    public CriadorProjeto participacao(Integer idFuncionario, LocalDate dataInicio, LocalDate dataTermino) {
        this.projeto.addParticipacoes(new Participacao(idFuncionario, dataInicio, dataTermino));
        return this;
    }

    public Projeto cria() { return this.projeto; }

}
