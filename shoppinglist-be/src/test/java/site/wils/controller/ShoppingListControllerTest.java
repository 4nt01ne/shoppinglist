package site.wils.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.wils.TestApp;
import site.wils.model.ShoppingList;
import site.wils.service.ShoppingListService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApp.class)
public class ShoppingListControllerTest {

    @InjectMocks
    private ShoppingListController target;

    @Mock
    private ShoppingListService shoppingListService;

    @Test
    public void proposedItemsServed() throws IOException {
        List<ShoppingList> shoppingListMock = Arrays.asList(new ShoppingList(), new ShoppingList());
        when(shoppingListService.getProposedItems()).thenReturn(shoppingListMock);

        List<ShoppingList> proposedItems = target.getProposedItems();
        assertEquals(shoppingListMock, proposedItems);
    }
}