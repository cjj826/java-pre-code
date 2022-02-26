import java.math.BigInteger;

class Bottle extends Equipment {
    private final double capacity;
    private boolean filled;
    
    public Bottle(int id, String name, BigInteger price, double capacity) {
        super(id, name, price);
        this.capacity = capacity;
        this.filled = true;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public boolean isFilled() {
        return filled;
    }
    
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    public String toString() {
        return "The bottle's id is " + getId() +
                ", name is " + getName() +
                ", capacity is " + capacity +
                ", filled is " + filled +
                '.';
    }
    
    @Override
    public void use(Adventurer user) throws Exception {
        if (!isFilled()) {
            throw new Exception("Failed to use " + getName() + " because it is empty.");
        }
        user.setHealth(user.getHealth() + capacity / 10);
        setFilled(false);
        setPrice(getPrice().divide(BigInteger.TEN));
        
        System.out.println(user.getName() +
                " drank " + getName() +
                " and recovered " + capacity / 10 +
                ".");
    }
}
