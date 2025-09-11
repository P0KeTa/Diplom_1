package praktikum;

import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseTest {

    Burger burger;
    Bun bun;
    Ingredient cutlet;
    Ingredient cheese;
    Ingredient mayonnaise;

    @Before
    public void createMockAndClass() {
        burger = new Burger();
        bun = mock(Bun.class);
        cutlet = mock(Ingredient.class);
        cheese = mock(Ingredient.class);
        mayonnaise = mock(Ingredient.class);

        //Назначение цены и название булки
        when(bun.getPrice()).thenReturn(100f);
        when(bun.getName()).thenReturn("Чёрная булка");

        //Назначение цены, названия и типа ингредиентов
        when(cutlet.getPrice()).thenReturn(50f);
        when(cutlet.getName()).thenReturn("Котлета");
        when(cutlet.getType()).thenReturn(IngredientType.FILLING);

        when(cheese.getPrice()).thenReturn(50f);
        when(cheese.getName()).thenReturn("Сыр");
        when(cheese.getType()).thenReturn(IngredientType.FILLING);

        when(mayonnaise.getPrice()).thenReturn(50f);
        when(mayonnaise.getName()).thenReturn("Майонез");
        when(mayonnaise.getType()).thenReturn(IngredientType.SAUCE);
    }
}
