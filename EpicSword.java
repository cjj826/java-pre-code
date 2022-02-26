import java.math.BigInteger;

class EpicSword extends Sword {
    public double getEvolveRatio() {
        return evolveRatio;
    }
    
    private final double evolveRatio;
    
    public EpicSword(int id, String name, BigInteger price, double sharpness, double evolveRatio) {
        super(id, name, price, sharpness);
        this.evolveRatio = evolveRatio;
    }
    
    public String toString() {
        return "The epicSword's " +
                "id is " + getId() +
                ", name is " + getName() +
                ", sharpness is " + getSharpness() +
                ", evolveRatio is " + evolveRatio + '.';
    }
    
    @Override
    public void use(Adventurer user) {
        super.use(user);
        setSharpness(getSharpness() * getEvolveRatio());
        System.out.println(getName() +
                "'s sharpness became " + getSharpness() +
                '.');
    }
}