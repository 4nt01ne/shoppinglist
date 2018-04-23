package site.wils.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.wils.TestApp;
import site.wils.model.ShoppingList;
import site.wils.persistence.ShoppingListDAO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApp.class)
public class ShoppingListServiceTest {

    @InjectMocks
    private ShoppingListService target;

    @Mock
    private ShoppingListDAO shoppingListDAO;

    @Test
    public void servingProposedItems() throws IOException {
        List<ShoppingList> shoppingListMock = Arrays.asList(new ShoppingList(), new ShoppingList());
        when(shoppingListDAO.getProposedItems()).thenReturn(shoppingListMock);

        List<ShoppingList> proposedItems = target.getProposedItems();

        assertEquals(shoppingListMock, proposedItems);
    }
}