package com.agencia.viagens.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.viagens.model.Viagem;
import com.agencia.viagens.repository.ViagemRepository;

@RestController
@RequestMapping(value="/api")
public class ViagemResource {
	
	@Autowired
	ViagemRepository viagemRepository;
	
	@GetMapping("/viagens")
	public List<Viagem> listaViagens(){
		return viagemRepository.findAll();
	}
	
	@GetMapping("/viagem/{id}")
	public Viagem listaViagemById(@PathVariable(value="id") long id){
		return viagemRepository.findById(id);
	}
	
	@PostMapping("/viagem")
	public Viagem salvarViagem(@RequestBody Viagem viagem) {
		return viagemRepository.save(viagem);
	}
	
	@DeleteMapping("/viagem/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable(value="id") long id) {

		Viagem viagem = viagemRepository.findById(id);
		viagemRepository.delete(viagem);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
    @PutMapping("/viagem/{id}")
    public ResponseEntity<Viagem> update(@PathVariable long id,@RequestBody Viagem viagemDetails) {
    	Viagem updateViagem = viagemRepository.findById(id);

    	updateViagem.setDestino(viagemDetails.getDestino());
    	updateViagem.setValor(viagemDetails.getValor());
    	updateViagem.setDataCadastro(viagemDetails.getDataCadastro());
    	
       viagemRepository.save(updateViagem);

        return ResponseEntity.ok(updateViagem);
    }
}
