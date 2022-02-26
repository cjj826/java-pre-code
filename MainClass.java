import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        ArrayList<Adventurer> adventurers = new ArrayList<>();
        int m = scanner.nextInt();
        for (int i = 1; i <= m; i++) {
            int option = scanner.nextInt();
            int advId = scanner.nextInt();
            
            switch (option) {
                case 1:
                    option1(adventurers, advId);
                    break;
                case 2:
                    option2(adventurers, advId);
                    break;
                case 3:
                    option3(adventurers, advId);
                    break;
                case 4:
                    option4(adventurers, advId);
                    break;
                case 5:
                    option5(adventurers, advId);
                    break;
                case 6:
                    option6(adventurers, advId);
                    break;
                case 7:
                    option7(adventurers, advId);
                    break;
                case 8:
                    option8(adventurers, advId);
                    break;
                case 9:
                    option9(adventurers, advId);
                    break;
                case 10:
                    option10(adventurers, advId);
                    break;
                default:
                    break;
            }
        }
    }
    
    public static Equipment initial(int type, int euqId) {
        String name = scanner.next();
        long priceNum = scanner.nextLong();
        BigInteger price = BigInteger.valueOf(priceNum);
        if (type == 1) {
            double capacity = scanner.nextDouble();
            return new Bottle(euqId, name, price, capacity);
        } else if (type == 2) {
            double capacity = scanner.nextDouble();
            double efficiency = scanner.nextDouble();
            return new HealingPotion(euqId, name, price, capacity, efficiency);
        } else if (type == 3) {
            double capacity = scanner.nextDouble();
            double expRatio = scanner.nextDouble();
            return new ExpBottle(euqId, name, price, capacity, expRatio);
        } else if (type == 4) {
            double sharpness = scanner.nextDouble();
            return new Sword(euqId, name, price, sharpness);
        } else if (type == 5) {
            double sharpness = scanner.nextDouble();
            double extraExpBonus = scanner.nextDouble();
            return new RareSword(euqId, name, price, sharpness, extraExpBonus);
        } else if (type == 6) {
            double sharpness = scanner.nextDouble();
            double evolveRatio = scanner.nextDouble();
            return new EpicSword(euqId, name, price, sharpness, evolveRatio);
        }
        
        return null;
    }
    
    public static void option1(ArrayList<Adventurer> adventurers, int advId) {
        String advName = scanner.next();
        Adventurer adventurer = new Adventurer(advId, advName);
        adventurers.add(adventurer);
    }
    
    public static void option2(ArrayList<Adventurer> adventurers, int advId) {
        for (Adventurer item : adventurers) {
            if (advId == item.getId()) {
                //增加一件装备
                int type = scanner.nextInt();
                int equId = scanner.nextInt();
                Equipment equipment;
                equipment = initial(type, equId);
                item.getPriceBodyHashMap().put(equId, equipment);
                break;
            }
        }
    }
    
    public static void option3(ArrayList<Adventurer> adventurers, int advId) {
        int euqId = scanner.nextInt();
        for (Adventurer item : adventurers) {
            if (item.getId() == advId) {
                item.getPriceBodyHashMap().remove(euqId);
                break;
            }
        }
    }
    
    public static void option4(ArrayList<Adventurer> adventurers, int advId) {
        for (Adventurer item : adventurers) {
            if (item.getId() == advId) {
                System.out.println(item.getPrice());
                break;
            }
        }
    }
    
    public static void option5(ArrayList<Adventurer> adventurers, int advId) {
        for (Adventurer item : adventurers) {
            if (item.getId() == advId) {
                BigInteger maxPrice = BigInteger.valueOf(0);
                for (PriceBody equ : item.getPriceBodyHashMap().values()) {
                    if (equ.getPrice().compareTo(maxPrice) > 0) {
                        maxPrice = equ.getPrice();
                    }
                }
                System.out.println(maxPrice);
                break;
            }
        }
    }
    
    public static void option6(ArrayList<Adventurer> adventurers, int advId) {
        for (Adventurer item : adventurers) {
            if (item.getId() == advId) {
                System.out.println(item.getPriceBodyHashMap().size());
            }
        }
    }
    
    public static void option7(ArrayList<Adventurer> adventurers, int advId) {
        for (Adventurer item : adventurers) {
            if (item.getId() == advId) {
                int id = scanner.nextInt();
                PriceBody equ = item.getPriceBodyHashMap().get(id);
                if (equ instanceof HealingPotion) {
                    HealingPotion ref = (HealingPotion) equ;
                    System.out.println(ref);
                } else if (equ instanceof ExpBottle) {
                    ExpBottle ref = (ExpBottle) equ;
                    System.out.println(ref);
                } else if (equ instanceof Bottle) {
                    Bottle ref = (Bottle) equ;
                    System.out.println(ref);
                } else if (equ instanceof RareSword) {
                    RareSword ref = (RareSword) equ;
                    System.out.println(ref);
                } else if (equ instanceof EpicSword) {
                    EpicSword ref = (EpicSword) equ;
                    System.out.println(ref);
                } else if (equ instanceof Sword) {
                    Sword ref = (Sword) equ;
                    System.out.println(ref);
                } else if (equ instanceof Adventurer) {
                    Adventurer ref = (Adventurer) equ;
                    System.out.println(ref);
                }
                break;
            }
        }
    }
    
    public static void option8(ArrayList<Adventurer> adventurers, int advId) {
        for (Adventurer item : adventurers) {
            if (item.getId() == advId) {
                item.useAll(item);
                break;
            }
        }
    }
    
    public static void option9(ArrayList<Adventurer> adventurers, int advId) {
        for (Adventurer item : adventurers) {
            if (item.getId() == advId) {
                System.out.println(item);
                break;
            }
        }
    }
    
    public static void option10(ArrayList<Adventurer> adventurers, int advId) {
        for (Adventurer item : adventurers) {
            if (item.getId() == advId) {
                int advId2 = scanner.nextInt();
                for (Adventurer item2 : adventurers) {
                    if (item2.getId() == advId2) {
                        item.getPriceBodyHashMap().put(advId2, item2);
                        break;
                    }
                }
                break;
            }
        }
    }
}


