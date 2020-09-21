package basico;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CicloVidaTest {
	
	@BeforeAll
	public static void inicializaTodos() {
		System.out.println("@BeforeAll");
	}
	
	@BeforeEach
	public void inicializa() {
		System.out.println("@BeforeEach");
	}
	
	@Test
	public void test1() {
		System.out.println("@test1");
	}
	
	@Test
	public void test2() {
		System.out.println("@test2");
	}
	
	@Test
	public void test3() {
		System.out.println("@test3");
	}
	
	@AfterEach
	public void finaliza() {
		System.out.println("@AfterEach");
	}		
	
	@AfterAll
	public static void finalizaTodos() {
		System.out.println("@AfterAll");
	}
	


}
