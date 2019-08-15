package com.eduit.springc2;


import com.eduit.springc2.model.Item;
import com.eduit.springc2.repository.ItemRepository;
import com.eduit.springc2.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;


@SpringBootApplication(scanBasePackages = "com.eduit.springc2")
public class Application implements CommandLineRunner {

    //@Autowired
    //private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

   /*
        Item item = new Item("caja",100.00F,1000);

        System.out.println( "save -> " );
        Item saved = itemRepository.save(item);

        saved.setPrice(2000.00F);

        System.out.println( "update -> " );
        itemRepository.save(saved);

        Item first = itemRepository.findOne(saved.getId());

        System.out.println( "findOne -> " +  first);

        Iterable<Item> items = itemRepository.findAll();

        System.out.println( "findAll -> " );

        items.forEach(System.out::println);

        System.out.println( "byName -> " );
        List<Item> byName = itemRepository.byName("caja");

        byName.forEach(System.out::println);


        System.out.println( "byPriceLesserThan -> " );
        List<Item> byPriceLesserThan = itemRepository.byPriceLesserThan(5F);

        byPriceLesserThan.forEach(System.out::println);

        System.out.println( "findByQuantityLessThan -> " );
        List<Item> byQuantityLessThan = itemRepository.findByQuantityLessThan(5);
        byQuantityLessThan.forEach(System.out::println);


        System.out.println( "delete -> " );
        itemRepository.delete(saved);*/


        Optional<Item> itemOptional = itemService.findItemById(1L);

        Item item = itemOptional.orElseThrow( ()-> new RuntimeException(" not found"));

        System.out.println(item);

        item.setPrice(500000F);

        Item updated = itemService.update(item);

        System.out.println(updated);


        List<Item> fistTen = itemService.getFistTen();

        fistTen.forEach(System.out::println);




    }

}