package edu.javial.cert.se.sx.type.enumExplore;

// TODO what can you do to couple the enum with some other object type, as representation of singleton pattern
class Bird {
    private String name = null;

    Bird(String _name) {
        name = _name;
    }
}

public enum StuffedBirds {
    STUFFED_DOVE(new Bird("Dove")),
    STUFFED_CHICKEN(new Bird("Chicken"));

    private Bird bird ;

    StuffedBirds(Bird _bird) {
        bird = _bird ;
    }
}
