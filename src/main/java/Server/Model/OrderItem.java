package Server.Model;

public class OrderItem {
    private String item;
    private int num;

    public OrderItem(String item, int num) {
        this.item = item;
        this.num = num;
    }

    public String getItem() {
        return item;
    }

    public int getNum() {
        return num;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "item='" + item + '\'' +
                ", num=" + num +
                '}';
    }
}
