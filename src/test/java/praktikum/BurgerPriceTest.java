package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerPriceTest extends BaseTest {

    //Поля для параметризации
    private final float bunPrice;
    private final float ingredientPrice;
    private final float expectedPrice;

    public BurgerPriceTest(float bunPrice, float ingredientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void createMockAndClass() {
        burger = new Burger();
        bun = mock(Bun.class);
        cutlet = mock(Ingredient.class);
        cheese = mock(Ingredient.class);
        mayonnaise = mock(Ingredient.class);

        //Назначение цены булки и ингредиентов
        when(bun.getPrice()).thenReturn(bunPrice);
        when(cutlet.getPrice()).thenReturn(ingredientPrice);
        when(cheese.getPrice()).thenReturn(ingredientPrice);
        when(mayonnaise.getPrice()).thenReturn(ingredientPrice);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {100f, 50f, 350f},   // 2*100 + 50*3 = 350
                {200f, 0f, 400f},    // 200*2 + 0 = 400
        };
    }

    //Тест цены бургера
    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(cutlet);
        burger.addIngredient(cheese);
        burger.addIngredient(mayonnaise);
        assertEquals("Цена бургера неверная",expectedPrice, burger.getPrice(), 0.01);
    }


}
