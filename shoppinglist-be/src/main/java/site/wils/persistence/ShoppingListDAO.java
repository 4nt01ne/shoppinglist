package site.wils.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import site.wils.model.ShoppingList;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class ShoppingListDAO {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Value("${shoppinglist.resource.path}")
    private String resource;

    public List<ShoppingList> getProposedItems() throws IOException {
        ShoppingList[] shoppingLists = objectMapper.readValue(getClass().getResourceAsStream(resource), ShoppingList[].class);
        return Arrays.asList(shoppingLists);
    }
}
