import java.math.BigInteger;

abstract class Equipment implements PriceBody {
    private final int id;
    private final String name;
    private BigInteger price;
    
    @Override
    public abstract void use(Adventurer user) throws Exception;
    
    @Override
    public abstract String toString();
    
    public Equipment(int id, String name, BigInteger price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public BigInteger getPrice() {
        return price;
    }
    
    public void setPrice(BigInteger price) {
        this.price = price;
    }
}
