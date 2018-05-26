package edu.javial.cert.se.sx

/**
 * @author mak
 */
public enum SingletonExampleBloch {
    INSTANCE(-1);
    private int counter;

    SingletonExampleBloch(int cnt) {
        counter = cnt;
    }

    private SingletonExampleBloch() {
    }

    public final static synchronized int bumpCounter() {
        return ++(getInstance().counter);
    }

    public static SingletonExampleBloch getInstance() {
        return INSTANCE;
    }
    public final static synchronized int getCount() {
        return (getInstance().counter);
    }
}