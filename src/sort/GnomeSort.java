package sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GnomeSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    public void forwardSortInPlace(Collection<E> collection) {
        List<E> asList = new ArrayList<>(collection);
        collection.clear();
        // Implementación adaptada a partir de
        // https://www.w3resource.com/java-exercises/sorting/java-sorting-algorithm-exercise-13.php
        int i = 1;
        int j = 2;
        while (i < asList.size()) {
            if (asList.get(i - 1).compareTo(asList.get(i)) <= 0) {
                i = j;
                j++;
            } else {
                Collections.swap(asList, i, --i);
                i = (i == 0) ? j++ : i;
            }
        }
        collection.addAll(asList);
    }

    @Override
    public void backwardSortInPlace(Collection<E> collection) {
        List<E> asList = new ArrayList<>(collection);
        collection.clear();
        // Implementación adaptada a partir de
        // https://www.w3resource.com/java-exercises/sorting/java-sorting-algorithm-exercise-13.php
        int i = 1;
        int j = 2;
        while (i < asList.size()) {
            if (asList.get(i - 1).compareTo(asList.get(i)) >= 0) {
                i = j;
                j++;
            } else {
                Collections.swap(asList, i, --i);
                i = (i == 0) ? j++ : i;
            }
        }
        collection.addAll(asList);
    }
}
