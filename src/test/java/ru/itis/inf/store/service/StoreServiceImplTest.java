//package ru.itis.inf.store.service;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.exceptions.verification.junit.ArgumentsAreDifferent;
//import org.mockito.runners.MockitoJUnitRunner;
//import ru.itis.inf.store.dao.ItemsDao;
//import ru.itis.inf.store.dao.models.Item;
//import static org.junit.Assert.*;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Mockito.*;
//
///**
// * Created by rumia on 15.02.16.
// */
//
//@RunWith(MockitoJUnitRunner.class)
//public class StoreServiceImplTest {
//
//    StoreServiceImpl testedStoreService;
//
//    @Mock
//    ItemsDao itemsDao;
//
//    @Before
//    public void setUp() throws Exception {
//
//        // Выброс исключения, если пришла какая-либо строка, которая не Something
//        doThrow(new IllegalArgumentException()).when(itemsDao).delete(anyString());
//
//        doThrow(new IllegalArgumentException()).when(itemsDao).select(anyString());
//
//        // Делаем stubbing на удаление товара с именем Something
//        doNothing().when(itemsDao).delete("Something");
//
//        doReturn(new Item("Something", 147)).when(itemsDao).select("Something");
//
////        testedStoreService = new StoreServiceImpl();
////        testedStoreService.setItemsDao(itemsDao);
//    }
//
//    // Проверяем, корректно ли прошло выполнение метода buy при входном значении Something
//    @Test
//    public void testBuy() throws Exception {
//        testedStoreService.buy("Something");
//        // Проверяем, был ли вызван метод delete
//        verify(itemsDao).delete("Something");
//    }
//
//    // Проверяем, была ли вызвана ошибка при других входных данных
//    @Test(expected = IllegalArgumentException.class)
//    public void testBuyOnIncorrectData() {
//        testedStoreService.buy("Not Something");
//    }
//
//    //
//    @Test
//    public void testIsExists()throws Exception{
//        assertTrue(testedStoreService.isExist("Something"));
//        verify(itemsDao).select("Something");
//    }
//
//    //
//    @Test(expected = IllegalArgumentException.class)
//    public void testIsExistOnIncorrect(){
//        testedStoreService.isExist("Not Something");
//    }
//}
//
