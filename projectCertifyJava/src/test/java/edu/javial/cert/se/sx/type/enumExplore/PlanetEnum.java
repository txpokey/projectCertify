package edu.javial.cert.se.sx.type.enumExplore;

public enum PlanetEnum {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    X  (new Double(1), 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final Double mass;   // in kilograms
    private final Double radius; // in meters
    PlanetEnum(Double mass, Double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private Double mass() { return mass; }
    private Double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final Double G = 6.67300E-11;

    Double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    Double surfaceWeight(Double otherMass) {
        return otherMass * surfaceGravity();
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        Double earthWeight = Double.parseDouble(args[0]);
        Double mass = earthWeight/EARTH.surfaceGravity();
        for (PlanetEnum p : PlanetEnum.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
    }
}