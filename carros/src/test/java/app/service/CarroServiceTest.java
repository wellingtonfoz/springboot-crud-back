package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarroServiceTest {
	
	@Autowired
	CarroService carroService;

	@Test
	void cenario01() {
		
		boolean retorno = this.carroService.verificarNomeCarro("Jeep Compass", 2006);
		
		assertEquals(true, retorno);
		
	}
	
	@Test
	void cenario02() {
		
		assertThrows(Exception.class, () -> {
			boolean retorno = this.carroService.verificarNomeCarro("Jeep Compass", 1995);
		});
		
	}
}
