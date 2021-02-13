package com.enigma.api.inventory.controller;

import com.enigma.api.inventory.controllers.ItemController;
import com.enigma.api.inventory.entities.Item;
import com.enigma.api.inventory.models.ItemRequest;
import com.enigma.api.inventory.models.ItemResponse;
import com.enigma.api.inventory.services.FileService;
import com.enigma.api.inventory.services.ItemService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ItemService itemService;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private FileService fileService;

    @Test
    public void allShouldReturnEmptyList() throws Exception {
        Page page = Page.empty();
        when(itemService.findAll(any(), anyInt(), anyInt(), any())).thenReturn(page);

        RequestBuilder request = get("/items");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.list", empty()));
    }

    @Test
    public void getEntityNotNUlLException() throws Exception{
        when(itemService.findById(any(Integer.class))).thenReturn(null);
        RequestBuilder request = get("/items/2");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.NOT_FOUND.value())));

    }
    @Test
    public void deleteEntityNotNUlLException() throws Exception{
        when(itemService.findById(any(Integer.class))).thenReturn(null);
        RequestBuilder request = delete("/items/2");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.NOT_FOUND.value())));

    }

    @Test
    public void putEntityNotNUlLException() throws Exception{
        when(itemService.findById(any(Integer.class))).thenReturn(null);
        RequestBuilder request = put("/items/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"\",\"price\": \"\",\"unitId\": \"\"}");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.BAD_REQUEST.value())));

    }

    @Test
    public void putNameEntityNotNUlLException() throws Exception{
        when(itemService.findById(any(Integer.class))).thenReturn(null);
        RequestBuilder request = put("/items/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"orlan\",\"price\": \"1000\",\"unitId\": \"1\"}");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.NOT_FOUND.value())));

    }

}

