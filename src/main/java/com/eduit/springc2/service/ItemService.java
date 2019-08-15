package com.eduit.springc2.service;

import com.eduit.springc2.model.Item;
import com.eduit.springc2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<Item> findItemById(Long id){
        Item item = itemRepository.findOne(id);
        return Optional.ofNullable(item);
    }

    public Item update(Item item){
        boolean exists = itemRepository.exists(item.getId());
        if(!exists){
            throw new IllegalArgumentException(" item id " + item.getId() + " not found");
        }
        Item updated = itemRepository.save(item);
        return updated;
    }


    public Item save(Item item){
        Item saved = itemRepository.save(item);
        return saved;
    }

    public void delete(Item item){
       itemRepository.delete(item);
    }

    public List<Item> getAll(){
        Iterable<Item> items = itemRepository.findAll();
        ArrayList<Item> itemsList = new ArrayList<>();
        items.forEach(item -> itemsList.add(item));
        return itemsList;
    }

    public List<Item> getFistTen(){
        Pageable pageable = new PageRequest(0, 10);
        Page<Item> page = itemRepository.findAll(pageable);
        ArrayList<Item> itemsList = new ArrayList<>();
        page.map(item ->itemsList.add(item));
        return itemsList;
    }









}
