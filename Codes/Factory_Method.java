
// allow greater freedom for the subclasses to choose the objects being created.

abstract class Cake {
    abstract void bake(); // represents a general concept of a cake
}

class ChocolateCake extends Cake {
    void bake() {
        System.out.println("Baking a chocolate cake...");
    }
}

class VanillaCake extends Cake {
    void bake() {
        System.out.println("Baking a vanilla cake...");
    }
}

class CakeFactory {
    static Cake getCake(String type) { // call without creating an instance of
        // CakeFactory
        if (type.equals("chocolate")) {
            return new ChocolateCake();
        } else if (type.equals("vanilla")) {
            return new VanillaCake();
        }
        return null;
    }
}

class DemoCake {
    public static void main(String[] args) {
        // Create a chocolate cake
        Cake chocolateCake = CakeFactory.getCake("chocolate");
        chocolateCake.bake();

        // Create a vanilla cake
        Cake vanillaCake = CakeFactory.getCake("vanilla");
        vanillaCake.bake();
    }
}

