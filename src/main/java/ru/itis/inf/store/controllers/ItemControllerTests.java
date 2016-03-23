package ru.itis.inf.store.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.asm.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.itis.inf.store.WebAppContext;
import ru.itis.inf.store.service.StoreService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by rumia on 22.03.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppContext.class})
@WebAppConfiguration
public class ItemControllerTests {

    private MockMvc mvc;

    @Autowired
    @Qualifier("storeServiceMock")
    StoreService storeService;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception{
        Mockito.reset(storeService);
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetItemByName()throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/items/{item-id}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testPostItem()throws Exception{
        mvc.perform(post("/items"))
                .andExpect(status().isOk())
                .andExpect(model().size(2))
                .andExpect(model().attributeExists("name"))
                .andExpect(model().attributeExists("price"));
    }
}
