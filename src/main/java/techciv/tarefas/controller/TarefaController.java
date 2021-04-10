package techciv.tarefas.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import techciv.tarefas.model.Tarefa;
import techciv.tarefas.service.TarefaService;

@RestController
@RequestMapping(path = "/api/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaService service;
	
	@GetMapping
	public List<Tarefa> listar() {
		return service.listarTodas();
	}
	
	@PostMapping
	public Tarefa salvar(@RequestBody Tarefa tarefa) {
		return service.salvar(tarefa);
	}
	
	@PutMapping("{id}")
	public Tarefa atualizar(@PathVariable long id, @RequestBody Tarefa tarefa) {
		return service.atualizar(id, tarefa);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		service.excluirPorId(id);
	}
	
	@ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<Object> EntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
	
}
