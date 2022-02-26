import java.math.BigInteger;

class HealingPotion extends Bottle {
    private final double efficiency;
    
    public double getEfficiency() {
        return efficiency;
    }
    
    public HealingPotion(int id, String name, BigInteger price,
                         double capacity, double efficiency) {
        super(id, name, price, capacity);
        this.efficiency = efficiency;
    }
    
    public String toString() {
        return "The healingPotion's id is " + getId() +
                ", name is " + getName() +
                ", capacity is " + getCapacity() +
                ", filled is " + isFilled() +
                ", efficiency is " + efficiency + '.';
    }
    
    @Override
    public void use(Adventurer user) throws Exception {
        if (isFilled()) {
            super.use(user);
            user.setHealth(user.getHealth() + getCapacity() * getEfficiency());
            System.out.println(user.getName() +
                    " recovered extra " + getCapacity() * getEfficiency()
                    + '.');
        } else {
            super.use(user);
        }
    }
}
