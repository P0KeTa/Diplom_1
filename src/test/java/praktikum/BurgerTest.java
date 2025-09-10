package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class BurgerTest extends BaseTest {

    //Тест наличия ингредиентов в рецепте
    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(cutlet);
        burger.addIngredient(cheese);
        burger.addIngredient(mayonnaise);

        String receipt = burger.getReceipt();
        try {
            assertThat(receipt, containsString("Чёрная булка"));
            assertThat(receipt, containsString("Котлета"));
            assertThat(receipt, containsString("Сыр"));
            assertThat(receipt, containsString("Майонез"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Тест удаления ингредиента
    @Test
    public void addAndRemoveIngredientTest() {
        burger.setBuns(bun);
        burger.addIngredient(cutlet);
        burger.addIngredient(cheese);
        burger.addIngredient(mayonnaise);

        burger.removeIngredient(0);
        //Ингридиентов 3, а удалили 1
        assertEquals("Ингредиент не удалился",2, burger.ingredients.size());
    }

    //Тест перемещения ингредиентов
    @Test
    public void moveIngredientTest() {
        burger.setBuns(bun);
        burger.addIngredient(cutlet);
        burger.addIngredient(cheese);
        burger.addIngredient(mayonnaise);

        burger.moveIngredient(0, 1);
        assertEquals("Ингредиенты не поменялись местами","Сыр", burger.ingredients.get(1).getName());
    }

}


