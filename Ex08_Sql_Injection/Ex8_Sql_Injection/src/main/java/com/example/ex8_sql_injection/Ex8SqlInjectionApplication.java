package com.example.ex8_sql_injection;

import com.example.ex8_sql_injection.model.Kho;
import com.example.ex8_sql_injection.service.IKho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Scanner;

@SpringBootApplication
public class Ex8SqlInjectionApplication implements CommandLineRunner {

    private final IKho iKho;
    public Ex8SqlInjectionApplication(IKho iKho) {
        this.iKho = iKho;
    }

    Scanner sc = new Scanner(System.in);
    public String name;
    public int action;

    public static void main(String[] args) {
        SpringApplication.run(Ex8SqlInjectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        display("Tim kiem kho theo ten, vui long nhap ten:");
        name = sc.nextLine();
        display("1. Chua phong chong sql injection\n"+"" +
                           "2. Da phong chong sql injection\n"+
                           "0. Exit");


        do{
            display("");
            display("nhap lua chon:");
            action = sc.nextInt();
            switch (action)
            {
                case 1:
                    for (Kho item: iKho.getByNameDefault(name)) {
                        System.out.println(item.getId()+", "+item.getTen()+" "+item.getMaKho()+", "+item.getDiaDiem()+", "+item.getNgayTao()+", "+item.getNgaySua());
                    }
                    break;
                case 2:
                    for (Kho item: iKho.getByName(name)) {
                        System.out.println(item.getId()+", "+item.getTen()+" "+item.getMaKho()+", "+item.getDiaDiem()+", "+item.getNgayTao()+", "+item.getNgaySua());
                    }
                    break;
            }
        }while (action !=  0);
    }

    public void display(String msg)
    {
        System.out.println(msg);
    }
}
