
// act as a wrapper that converts one kind of interface into another existing kind
// of interface.

// helps classes work together when they are incompatible, allowing code to work
// together.

interface EuropeanPlug { // defines a contract that the PlugAdapter class must follow
    void giveElectricity();
}

class AmericanPlug {
    void provideElectricity() {
        System.out.println("Providing Electricity");
    }
}

class PlugAdapter implements EuropeanPlug { // adapts the AmericanPlug to match the
    // EuropeanPlug interface
    private AmericanPlug plug;

    public PlugAdapter(AmericanPlug plug) {
        this.plug = plug;
    }

    @Override
    public void giveElectricity() {
        plug.provideElectricity();
    }
}

class DemoPlug {
    public static void main(String[] args) {
        AmericanPlug americanPlug = new AmericanPlug();
        EuropeanPlug adapter = new PlugAdapter(americanPlug);
        adapter.giveElectricity();  // Outputs: "Providing Electricity"
    }
}

