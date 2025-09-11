package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

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

        SoftAssertions softly = new SoftAssertions();
        try {
            softly.assertThat(receipt).contains("Чёрная булка");
            softly.assertThat(receipt).contains("Котлета");
            softly.assertThat(receipt).contains("Сыр");
            softly.assertThat(receipt).contains("Майонез");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Тест корректности рецепта
    @Test
    public void checkCorrectReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(cutlet);
        burger.addIngredient(cheese);
        burger.addIngredient(mayonnaise);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format(
                "(==== Чёрная булка ====)\n" +
                        "= Котлета =\n" +
                        "= Сыр =\n" +
                        "= Майонез =\n" +
                        "(==== Чёрная булка ====)\n"+
                        "Price: %s", burger.getPrice());
        assertEquals("Некорректный текст рецепта", expectedReceipt, actualReceipt);
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


