package edu.javial.cert.se.core.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

interface SetTheoreticContract<E> extends Set<E>{
    default boolean subsetOf(Set<E> candidate) {
        Set<E> set = (Set<E>) this;
        return set.containsAll(candidate);
    };
    default boolean union(Set<E> incoming)  {
        Set<E> set = (Set<E>) this;
        return set.addAll(incoming);
    };
    default boolean intercect(Set<E> incommon) {
        Set<E> set = (Set<E>) this;
        return set.retainAll(incommon);
    };
    default boolean minus(Set<E> filter) {
        Set<E> set = (Set<E>) this;
        return set.removeAll(filter);
    };
    default Set<E> symmetricDiff(Set<E> incoming) {
        SetTheoreticContract<E> symmetricDiff = (SetTheoreticContract<E>) new HashSet<E>((Collection<? extends E>) this);
        symmetricDiff.union(incoming);
        SetTheoreticContract<E> filter = (SetTheoreticContract<E>) new HashSet<E>(this);
        filter.intercect(incoming);
        symmetricDiff.minus(filter);
        return symmetricDiff ;
    };
}

