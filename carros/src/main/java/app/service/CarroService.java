package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public String save(Carro carro) {
			
		this.carroRepository.save(carro);
		return carro.getNome()+ " salvo com sucesso";
	}
	
	public boolean verificarNomeCarro(String nome, int ano) {
		if(nome.equals("Jeep Compass") && ano < 2006)
			throw new RuntimeException();
		
		return true;
	}

	public String update(long id, Carro carro) {
		
		carro.setId(id);
		this.carroRepository.save(carro);
		return carro.getNome()+ " atualizado com sucesso";
	}

	public List<Carro> listAll(){
		return this.carroRepository.findAll();
	}

	public Carro findById(long idCarro) {

		Carro carro = this.carroRepository.findById(idCarro).get();
		return carro;

	}

	public String delete(long idCarro) {
		this.carroRepository.deleteById(idCarro);
		return "Carro deletado com sucesso!";

	}
	
	

}
