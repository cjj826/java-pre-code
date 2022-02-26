import java.math.BigInteger;

class ExpBottle extends Bottle {
    public double getExpRatio() {
        return expRatio;
    }
    
    private final double expRatio;
    
    public ExpBottle(int id, String name, BigInteger price, double capacity, double expRatio) {
        super(id, name, price, capacity);
        this.expRatio = expRatio;
    }
    
    public String toString() {
        return "The expBottle's id is " + getId() +
                ", name is " + getName() +
                ", capacity is " + getCapacity() +
                ", filled is " + isFilled() +
                ", expRatio is " + expRatio + '.';
    }
    
    @Override
    public void use(Adventurer user) throws Exception {
        if (isFilled()) {
            super.use(user);
            user.setExp(user.getExp() * getExpRatio());
            System.out.println(user.getName() +
                    "'s exp became " + user.getExp() +
                    '.');
        } else {
            super.use(user);
        }
    }
}
