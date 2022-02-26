import java.math.BigInteger;

interface PriceBody extends Comparable<PriceBody> {
    
    BigInteger getPrice();
    
    void use(Adventurer user) throws Exception;
    
    String toString();
    
    int getId();
    
    default int compareTo(PriceBody other) {
        if (this.getPrice().compareTo(other.getPrice()) < 0) {
            return -1;
        } else if (this.getPrice().compareTo(other.getPrice()) > 0) {
            return 1;
        }
        
        if (this.getId() < other.getId()) {
            return -1;
        } else if (this.getId() > other.getId()) {
            return 1;
        }
        
        return 0;
    }
}
