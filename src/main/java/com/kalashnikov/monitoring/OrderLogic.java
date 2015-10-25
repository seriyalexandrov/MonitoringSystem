package com.kalashnikov.monitoring;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class OrderLogic {

    // ������������� ������ : �������� ����� ���� ����� ��������� �������
    //�� ������� �������. � ������ ������ ���������� �������� ������
    //��� ������ : ��� �� ����� ����� ������ ��� ��������� ������
    private static final Logger log = Logger.getLogger(OrderLogic.class);
    //private static final Logger log = Logger.getLogger("bacon");

    public void doOrder(){

        BasicConfigurator.configure();
        //debug message
        log.debug("This is a debug message");
        // �����-�� ������
        System.out.println("Order is done!");
        // �������� ����
        log.info("This is informative message!");
        addToCart();
    }

    private void addToCart() {
        // ���������� ������ � �������
        System.out.println("Item added to cart");

        // �������� ������
        //������ ������ : ��������
        //log.error("This is error message");
        //������ ������ : �������� ������ � ���������� ��
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            log.error("This is an exception", e);
        }
    }
}