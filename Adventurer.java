import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

class Adventurer implements PriceBody {
    private final int id;
    private final String name;
    private double health;
    private double exp;
    private double money;
    
    public HashMap<Integer, PriceBody> getPriceBodyHashMap() {
        return priceBodyHashMap;
    }
    
    private final HashMap<Integer, PriceBody> priceBodyHashMap = new HashMap<>();
    
    @Override
    public BigInteger getPrice() {
        BigInteger sumPrice = BigInteger.valueOf(0);
        for (PriceBody equ : getPriceBodyHashMap().values()) {
            sumPrice = sumPrice.add(equ.getPrice());
        }
        return sumPrice;
    }
    
    @Override
    public void use(Adventurer user) {
        useAll(user);
    }
    
    @Override
    public String toString() {
        return "The adventurer's " +
                "id is " + id +
                ", name is " + name +
                ", health is " + health +
                ", exp is " + exp +
                ", money is " + money +
                '.';
    }
    
    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.health = 100.0;
        this.exp = 0.0;
        this.money = 0.0;
    }
    
    public void useAll(Adventurer user) {
        ArrayList<PriceBody> sorted = new ArrayList<>(priceBodyHashMap.values());
        sorted.sort(Comparator.reverseOrder());
        for (PriceBody priceBody : sorted) {
            try {
                priceBody.use(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getHealth() {
        return health;
    }
    
    public double getExp() {
        return exp;
    }
    
    public double getMoney() {
        return money;
    }
    
    public void setHealth(double health) {
        this.health = health;
    }
    
    public void setExp(double exp) {
        this.exp = exp;
    }
    
    public void setMoney(double money) {
        this.money = money;
    }
}
