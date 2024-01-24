package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Order {
  private LocalDateTime moment;
  private OrderStatus status;
    
    List <OrdemItem> itens = new ArrayList<>();
    private Client client;

    //
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //
    public Order() {
    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }
    //

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrdemItem> getItens() {
        return itens;
    }
    //
    public void addItens(OrdemItem item){
      itens.add(item);
    }
    public void removeItens(OrdemItem item){
        itens.remove(item);
      }
    public Double total(){
        Double total = 0.0;
      for(OrdemItem i: itens){
         total+= i.subTotal();
      }
      return total;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order Moment: ");
        sb.append(formatter.format(moment)+"\n");
        sb.append("Ordem status: ");
        sb.append(status+"\n");
        sb.append("Client: ");
        sb.append(client.getName()+" ");
        sb.append(formatter.format(client.getBirthDate()));
        sb.append(" "+client.getEmail()+"\n");
        sb.append("Order items:\n");
        for(OrdemItem c : itens){
            sb.append(c);
            sb.append("$"+c.subTotal()+"\n");
        }
        return sb.toString();
    }
}
