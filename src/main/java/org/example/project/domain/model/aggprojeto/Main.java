package org.example.project.domain.model.aggprojeto;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Projeto pr0 = new CriadorProjeto()
                .para("Vendas do Produto X", LocalDate.of(2021,1,1), LocalDate.of(2021,2,1), true)
                .participacao(000, LocalDate.of(2021,1,1), LocalDate.of(2021,2,1))
                .participacao(111, LocalDate.of(2021,2,1), LocalDate.of(2021,3,1))
                .participacao(222, LocalDate.of(2021,3,1), LocalDate.of(2021,4,1))
                .participacao(333, LocalDate.of(2021,4,1), LocalDate.of(2021,5,1))
                .participacao(444, LocalDate.of(2021,5,1), LocalDate.of(2021,6,1))
                .participacao(555, LocalDate.of(2021,6,1), LocalDate.of(2021,7,1))
                .participacao(666, LocalDate.of(2021,7,1), LocalDate.of(2021,8,1))
                .participacao(777, LocalDate.of(2021,8,1), LocalDate.of(2021,9,1))
                .participacao(888, LocalDate.of(2021,9,1), LocalDate.of(2021,10,1))
                .participacao(999, LocalDate.of(2021,10,1), LocalDate.of(2021,11,1))
                .cria();

        //  não deve permitir mais que 10 participações por projeto
        try {
            Participacao pa11 = new Participacao(494, LocalDate.of(2021,10,1), LocalDate.of(2021,11,1));
            pr0.addParticipacoes(pa11);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // não deve permitir a criação do projeto com data de fim menor que data de inicio
        try {
            Projeto pr1 = new CriadorProjeto()
                    .para("Vendas do Produto X", LocalDate.of(2021,2,1), LocalDate.of(2021,1,1), true)
                    .cria();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // não deve permitir registrar participações com o mesmo idFuncionário
        Projeto pr2 = new CriadorProjeto()
                .para("Lançamento do Produto Y", LocalDate.of(2021,1,1), LocalDate.of(2021,2,1), true)
                .cria();
        try {
            pr2.addParticipacoes(new Participacao(123, LocalDate.of(2021,1,1), LocalDate.of(2021,2,1)));
            pr2.addParticipacoes(new Participacao(123, LocalDate.of(2021,2,1), LocalDate.of(2021,3,1)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // não deve permitir registrar participações se o projeto não está ativo.
        Projeto pr3 = new CriadorProjeto()
                .para("Lançamento do Produto Y", LocalDate.of(2021,1,1), LocalDate.of(2021,2,1), false)
                .cria();
        try {
            pr3.addParticipacoes(new Participacao(000, LocalDate.of(2021,1,1), LocalDate.of(2021,2,1)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // save
        ProjetoRepositorio projetoRepositorio = new ProjetoRepositorio();
        projetoRepositorio.save(pr0);
        projetoRepositorio.save(pr0);
        projetoRepositorio.save(pr2);

        // delete
        projetoRepositorio.delete(pr2);

        // get
        System.out.println(projetoRepositorio.get(pr0.getId()));

    }
}
