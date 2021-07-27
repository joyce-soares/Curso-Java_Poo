public class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double preco, int quantity) {
        this.name = name;
        this.price = preco;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreco() {
        return price;
    }

    public void setPreco(double preco) {
        this.price = preco;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double total(){
        return quantity * price;
    }
}
