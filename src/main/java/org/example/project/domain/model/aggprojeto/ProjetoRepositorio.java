package org.example.project.domain.model.aggprojeto;

import java.util.ArrayList;
import java.util.List;

public class ProjetoRepositorio {
    private List<Projeto> projetos = new ArrayList<>();

    /**
     * deve inserir um novo projeto no repositório caso ele não exista
     * ou atualizar um existente.
     * @param projeto :Projeto (projeto a ser inserido ou atualizado)
     * @return
     */
    public Projeto save(Projeto projeto) {
        Projeto projetoFound = this.get(projeto.getId());


        if (projetoFound != null && this.projetos.size() != 0) {
            this.update(projeto);
        }

        this.projetos.add(projeto);
        return projeto;
    }

    /**
     * retorna um projeto por id
     * @param id :Integer (id do projeto)
     * @return
     */
    public Projeto get(Integer id) {
        return this.projetos.stream()
                .filter(projeto -> projeto.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public void update(Projeto newProjeto) {
        Projeto projetoFound = this.get(newProjeto.getId());
        projetos.set(projetos.indexOf(projetoFound), newProjeto);
    }

    /**
     * recebe um objeto projeto e remove este objeto do repositório.
     * @param projeto :Projeto (projeto que será removido)
     */
    public void delete(Projeto projeto) {
        projetos.remove(projeto);
    }
}
