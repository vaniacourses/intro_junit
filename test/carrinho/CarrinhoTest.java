package carrinho;

import org.junit.jupiter.api.*;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Classe para testee do Carrinho")
public class CarrinhoTest {

    private static Carrinho car;
    private static Produto produto;
    private static Produto produto2;

    @BeforeAll
    public static void printaInicio() {
        System.out.println("Inicia rodada de testes");
    }

    @AfterAll
    public static void printaFim() {
        System.out.println("Fim da rodada de testes");
    }

    @BeforeAll
    public static void inicializaProdutos() {
        produto = new Produto("produto", 3.00);
        produto2 = new Produto("produto", 4.00);
    }

    @BeforeEach
    public void inicializaCarrinho() {
        car = new Carrinho();
    }

    @DisplayName("Teste que adiciona um item no carrinho")
    @Test
    public void testeAdicionaUmItemNoCarrinho() {
        car.addItem(produto);
        Assertions.assertAll("car",
                () -> assertEquals(1, car.getQtdeItems()),
                () -> assertTrue(3.00 == car.getValorTotal())
        );
    }

    @DisplayName("Teste que verifica quantidade de itens no carrinho")
    @Test
    public void testeVerificaQtdItensCarrinho() {
        adicionaTresItens();
        assertEquals(3, car.getQtdeItems());
    }

    @DisplayName("Teste que verifica a soma dos preços dos produtos")
    @Test
    public void testeSomaPrecosItens() {
        adicionaTresItens();
        assertEquals(10, car.getValorTotal());
    }

    @DisplayName("Teste que remove um item do carrinho")
    @Test
    public void testeRemoveUmItem() throws ProdutoNaoEncontradoException {
        adicionaTresItens();
        car.removeItem(produto);
        assertEquals(2, car.getQtdeItems());
    }

    @DisplayName("Teste que esvazia o carrinho")
    @Test
    public void testeEsvaziaCarrinho() {
        car.esvazia();
        assertEquals(0, car.getQtdeItems());
    }

    private void adicionaTresItens() {
        car.addItem(produto);
        car.addItem(produto);
        car.addItem(produto2);
    }

}
