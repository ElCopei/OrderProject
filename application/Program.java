package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrdemItem;
import entities.Order;
import entities.OrderStatus;
import entities.Product;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

       System.out.println("Enter client date: ");
       System.out.println("Name: ");
       String name = sc.nextLine();
       System.out.println("Email: ");
       String email = sc.nextLine();
       System.out.println("Birth date: ");
       String date = sc.nextLine();
       LocalDate parsedDate = LocalDate.parse(date,formatter);
       Client c = new Client(name, email, parsedDate);
       System.out.println("Enter order data: ");
       System.out.println("Status: ");
       String status = sc.nextLine();
       System.out.println("How many itens to this order?");
       int n = sc.nextInt();
       LocalDateTime ldt= LocalDateTime.now();
       Order o = new Order(ldt, OrderStatus.valueOf(status), c);
       for(int i= 0; i<n;i++){
        sc.nextLine();
        System.out.println("Enter #"+(i+1)+"item data: ");
        System.out.println("Product name: ");
        String namep =sc.nextLine();
        System.out.println("Product price: ");
        Double price = sc.nextDouble();
        Product p = new Product(namep,price);
        System.out.println("Quantity: ");
        Integer qnt = sc.nextInt();
        OrdemItem oi = new OrdemItem(qnt, price, p);
        //oi.setPrice(oi.subTotal());
        o.addItens(oi);

       }
       System.out.println(o);
       System.out.println("Total: "+ o.total());

        sc.close();
    }
}
