package site.wils.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wils.model.ShoppingList;
import site.wils.service.ShoppingListService;

import java.io.IOException;
import java.util.List;

@RestController
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping(value = "/proposedItems")
    List<ShoppingList> getProposedItems() throws IOException {
        return shoppingListService.getProposedItems();
    }

}
