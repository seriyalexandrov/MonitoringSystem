package com.kalashnikov.monitoring;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class OrderLogic {

    // Инициализация логера : аргумент может быть любым названием которое
    //Мы захотим выбрать. В данном случае передается название класса
    //Это удобно : так мы легко можем понять где произошла ошибка
    private static final Logger log = Logger.getLogger(OrderLogic.class);
    //private static final Logger log = Logger.getLogger("bacon");

    public void doOrder(){

        BasicConfigurator.configure();
        //debug message
        log.debug("This is a debug message");
        // какая-то логика
        System.out.println("Order is done!");
        // логируем инфо
        log.info("This is informative message!");
        addToCart();
    }

    private void addToCart() {
        // добавление товара в корзину
        System.out.println("Item added to cart");

        // логируем ошибку
        //Первый способ : напрямую
        //log.error("This is error message");
        //Второй способ : создавая ошибку и отлавливая ее
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            log.error("This is an exception", e);
        }
    }
}