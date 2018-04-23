package site.wils.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import site.wils.TestApp;
import site.wils.model.ShoppingList;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApp.class)
@TestPropertySource(locations = "classpath:/test-application.properties")
public class ShoppingListDAOTest {

    @Autowired
    private ShoppingListDAO target;

    @Test
    public void proposingItems() throws IOException {
        List<ShoppingList> proposedItems = target.getProposedItems();

        InputStream shoopingListStream = getClass().getResourceAsStream("/test-shoppinglist.json");
        ShoppingList[] shoppingListArrays = new ObjectMapper().readValue(shoopingListStream, ShoppingList[].class);
        Assert.assertEquals(Arrays.asList(shoppingListArrays), proposedItems);
    }
}