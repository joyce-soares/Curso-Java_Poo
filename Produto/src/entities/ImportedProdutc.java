package entities;

public class ImportedProdutc extends Product{

    private Double customsFee;

    public ImportedProdutc() {
    }

    public ImportedProdutc(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public String priceTag(){
        return getName() + " $" + totalPrice() + " (Customs fee: $ " + getCustomsFee() + ")";
    }

    public Double totalPrice(){
        return getPrice() + getCustomsFee();
    }

}
