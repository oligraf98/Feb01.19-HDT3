package sort;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public abstract class Sort<E extends Comparable<E>> implements Sorter<E> {
    @Override
    public Collection<E> forwardSort(Collection<E> collection) {
        Collection<E> copy = cloneCollection(collection);
        // Con la copia del objeto, llamar a forwardSortInPlace
        forwardSortInPlace(copy);
        return copy;
    }

    @Override
    public Collection<E> backwardSort(Collection<E> collection) {
        Collection<E> copy = cloneCollection(collection);
        // Con la copia del objeto, llamar a backwardSortInPlace
        backwardSortInPlace(copy);
        return copy;
    }

    @Override
    public Collection<E> cloneCollection(Collection<E> collection) {
        // Realizar la copia de este objeto utilizando reflexión puesto que utilizamos una interfaz genérica
        @SuppressWarnings("unchecked")
        Class<? extends Collection<E>> colClass = (Class<? extends Collection<E>>) collection.getClass();
        Collection<E> copy;
        try {
            copy = colClass.getDeclaredConstructor(Collection.class).newInstance(collection);
        } catch (IllegalAccessException
                | InstantiationException
                | NoSuchMethodException
                | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
        return copy;
    }
}
