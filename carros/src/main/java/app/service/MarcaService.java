package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Marca;
import app.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	public String save(Marca marca) {
			
		this.marcaRepository.save(marca);
		return marca.getNome()+ " salvo com sucesso";
	}
	
	public boolean verificarNomeMarca(String nome, int ano) {
		if(nome.equals("Jeep Compass") && ano < 2006)
			throw new RuntimeException();
		
		return true;
	}

	public String update(long id, Marca marca) {
		
		marca.setId(id);
		this.marcaRepository.save(marca);
		return marca.getNome()+ " atualizado com sucesso";
	}

	public List<Marca> listAll(){
		return this.marcaRepository.findAll();
	}

	public Marca findById(long idMarca) {

		Marca marca = this.marcaRepository.findById(idMarca).get();
		return marca;

	}

	public String delete(long idMarca) {
		this.marcaRepository.deleteById(idMarca);
		return "Marca deletado com sucesso!";

	}
	
	

}
