package techciv.tarefas.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import techciv.tarefas.model.Tarefa;
import techciv.tarefas.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository;
	
	public List<Tarefa> listarTodas() {
		return repository.findAll();
	}

	public Tarefa salvar(Tarefa tarefa) {
		return repository.save(tarefa);
	}

	public Tarefa atualizar(Long id, Tarefa tarefa) {
		Optional<Tarefa> tarefaOptional = repository.findById(id);
		if (!tarefaOptional.isPresent())
			throw new EntityNotFoundException("Recurso não encontrado");
		
		Tarefa tarefaBanco = tarefaOptional.get();
		
		tarefa.setId(tarefaBanco.getId());
		
		return repository.save(tarefa);
	}

	public void excluirPorId(Long id) {
		repository.deleteById(id);
	}

}
