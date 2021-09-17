package com.lojadegames.lojadegames.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.lojadegames.model.produtoModel;
import com.lojadegames.lojadegames.repository.produtoRepository;

@RestController
@RequestMapping("/lojagame/produrto")

public class produtoControler {
	@Autowired
	private produtoRepository repository;

	public ResponseEntity<List<produtoModel>> getAll() {
		return ResponseEntity.ok().body(repository.findAll());
	}

	@GetMapping("/pegar_por_id/{id}")
	public ResponseEntity<produtoModel> getproduto(@PathVariable(value = "id") Long idproduto) {
		Optional<produtoModel> objetoproduto = repository.findById(idproduto);
		if (objetoproduto.isPresent()) {
			return ResponseEntity.status(200).body(objetoproduto.get());

		} else {

			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/buscar_por_descricao/{des}")
	public ResponseEntity<List<produtoModel>> findeBydescricao(@PathVariable(value = "des") String desc) {
		return ResponseEntity.status(200).body(repository.findAllByNomeProdutoContainingIgnoreCase(desc));
	}

	@PostMapping("salvar")
	public ResponseEntity<produtoModel> postarproduto(@Valid @RequestBody produtoModel atualizarproduto) {
		return ResponseEntity.status(201).body(repository.save(atualizarproduto));
	}

	@PutMapping("/atualizar_categoria")
	public ResponseEntity<produtoModel> atualizarproduto(@Valid @RequestBody produtoModel atualizarproduto) {
		return ResponseEntity.status(201).body(repository.save(atualizarproduto));
	}
	@DeleteMapping("deletar/{id}")
	public void deletarproduto(@PathVariable (value = "id") Long idproduto){
		repository.deleteById(idproduto);
	}

}
