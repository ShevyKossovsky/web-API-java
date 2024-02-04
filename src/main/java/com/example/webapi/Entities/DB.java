package com.example.webapi.Entities;

import java.util.ArrayList;
import java.util.List;

public class DB {




        public static List<Product> productsList = new ArrayList<>();
        static{
            productsList.add(new Product(1, "bread",5.5));
            productsList.add(new Product(2, "milk",4.2));
            productsList.add(new Product(1, "cheese",6.0));

        }


}
