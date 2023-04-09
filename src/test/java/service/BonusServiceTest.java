package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {
    @Test
    void calcularBonusSalarioMaiorQueMil() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("34000"))));
        
        // try{
        //     service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("34000")));
        // } catch(Exception e) {
        //     assertEquals("Funcionário com salário maior do que R$ 10000 não pode receber bõnus!",e.getMessage());
        // } 
    }

    @Test
    void calcularBonusSalarioDezPorcento() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void calcularBonusSalarioIgualMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}