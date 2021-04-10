package techciv.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import techciv.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	
	
}
