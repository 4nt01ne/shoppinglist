package site.wils.service;

import site.wils.model.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.wils.persistence.ShoppingListDAO;

import java.io.IOException;
import java.util.List;

@Component
public class ShoppingListService {

    @Autowired
    private ShoppingListDAO shoppingListDAO;

    public List<ShoppingList> getProposedItems() throws IOException {
        return shoppingListDAO.getProposedItems();
    }
}
