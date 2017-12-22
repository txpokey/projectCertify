package edu.javial.cert.string;

/**
 * Created by mak on 3/10/15.
 */
public class StringExploring {

    public static final boolean isCapitalized( final String s ) {
        final String UPPERCASE_REGEX = "[A-Z]" ;
        return s.substring(0,1).matches(UPPERCASE_REGEX);
    }
}
