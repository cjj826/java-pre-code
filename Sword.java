import java.math.BigInteger;

class Sword extends Equipment {
    private double sharpness;
    
    public double getSharpness() {
        return sharpness;
    }
    
    public void setSharpness(double sharpness) {
        this.sharpness = sharpness;
    }
    
    public Sword(int id, String name, BigInteger price, double sharpness) {
        super(id, name, price);
        this.sharpness = sharpness;
    }
    
    public String toString() {
        return "The sword's " +
                "id is " + getId() +
                ", name is " + getName() +
                ", sharpness is " + sharpness +
                '.';
    }
    
    @Override
    public void use(Adventurer user) {
        user.setHealth(user.getHealth() - 10.0);
        user.setExp(user.getExp() + 10.0);
        user.setMoney(user.getMoney() + getSharpness());
        System.out.println(user.getName() +
                " used " + getName() +
                " and earned " + getSharpness() +
                '.');
    }
}
