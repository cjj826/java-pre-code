import java.math.BigInteger;

class RareSword extends Sword {
    private final double extraExpBonus;
    
    public double getExtraExpBonus() {
        return extraExpBonus;
    }
    
    public RareSword(int id, String name, BigInteger price,
                     double sharpness, double extraExpBonus) {
        super(id, name, price, sharpness);
        this.extraExpBonus = extraExpBonus;
    }
    
    public String toString() {
        return "The rareSword's " +
                "id is " + getId() +
                ", name is " + getName() +
                ", sharpness is " + getSharpness() +
                ", extraExpBonus is " + extraExpBonus + '.';
    }
    
    @Override
    public void use(Adventurer user) {
        super.use(user);
        user.setExp(user.getExp() + getExtraExpBonus());
        System.out.println(user.getName() +
                " got extra exp " + getExtraExpBonus() +
                '.');
    }
}