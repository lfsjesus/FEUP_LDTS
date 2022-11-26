import com.lfsjesus.lab6.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlienClientTest {

    private StringRecipe getRecipe() {
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);
        StringRecipe recipe = new StringRecipe(transformers);
        return recipe;
    }

    @Test
    public void ferengiAlreadyOpened() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        Ferengi client = new Ferengi();
        stringBar.addObserver(client);
        stringBar.startHappyHour();
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }
    @Test
    public void ferengiStartClosed() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        Ferengi client = new Ferengi();
        stringBar.addObserver(client); // this is important!
        client.wants(drink, recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());
// Recipe is only ordered here
        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }
    @Test
    public void romulan() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        Romulan client = new Romulan();
// Recipe is ordered immediately
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }
}