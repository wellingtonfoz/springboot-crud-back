package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Acessorio;
import app.repository.AcessorioRepository;

@Service
public class AcessorioService {

	@Autowired
	private AcessorioRepository acessorioRepository;

	public String save(Acessorio acessorio) {
			
		this.acessorioRepository.save(acessorio);
		return acessorio.getNome()+ " salvo com sucesso";
	}
	
	public boolean verificarNomeAcessorio(String nome, int ano) {
		if(nome.equals("Jeep Compass") && ano < 2006)
			throw new RuntimeException();
		
		return true;
	}

	public String update(long id, Acessorio acessorio) {
		
		acessorio.setId(id);
		this.acessorioRepository.save(acessorio);
		return acessorio.getNome()+ " atualizado com sucesso";
	}

	public List<Acessorio> listAll(){
		return this.acessorioRepository.findAll();
	}

	public Acessorio findById(long idAcessorio) {

		Acessorio acessorio = this.acessorioRepository.findById(idAcessorio).get();
		return acessorio;

	}

	public String delete(long idAcessorio) {
		this.acessorioRepository.deleteById(idAcessorio);
		return "Acessorio deletado com sucesso!";

	}
	
	

}
