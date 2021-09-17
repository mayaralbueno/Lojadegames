package com.lojadegames.lojadegames.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.lojadegames.model.categoriaModel;
import com.lojadegames.lojadegames.repository.categoriaRepository;

@RestController
@RequestMapping("/categoria")

public class CategoriaControler {
	
   @Autowired   categoriaRepository   Repository;
   
   public ResponseEntity<List<categoriaModel>> getAll()
   {  
	   return ResponseEntity.ok().body(Repository.findAll());
   }
   @GetMapping("/pegar_por_id/{id}")
    public ResponseEntity<categoriaModel> getById(@PathVariable(value = "id") Long idcategoria){
	   Optional<categoriaModel > objetocategoria = Repository.findById(idcategoria);
	   if(objetocategoria.isPresent()) {
		   return ResponseEntity.status(200).body(objetocategoria.get());
	   }else {
		   return ResponseEntity.status(204).build();
	   }
   }
    @GetMapping("/buscar_por_descricao/{desc}")
   public ResponseEntity<List<categoriaModel>> findeByDescricao (@PathVariable (value ="desc") String desc){
	   return ResponseEntity.status(200).body(Repository.findAllBydescricaoContainingIgnoreCase(desc));
	  
   }
     @PostMapping("salvar")
     public ResponseEntity<categoriaModel> postarCategoria (@Valid @RequestBody categoriaModel salvarCategoria){
    	 return ResponseEntity.status(201).body(Repository.save(salvarCategoria));	 
    }
      @PutMapping("/atualizar_categoria")
      public ResponseEntity<categoriaModel> atualizarCategoria(@Valid categoriaModel atualizarCategoria){
    	  return ResponseEntity.status(201).body(Repository.save(atualizarCategoria));
     }
       @DeleteMapping("/DELETAR/{id}")
       public void deletarCategoria(@PathVariable (value = "id") Long idCategoria){
    	   Repository.deleteById(idCategoria);
    	   
       }
}
