import org.junit.Test;
import sort.GnomeSort;
import sort.Sorter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class TestSorters {

    // Oh dulce, hermoso y malvado C++ ;)
    private static List<Sorter<Integer>> integerSorters = new ArrayList<Sorter<Integer>>() {{
        add(new GnomeSort<>());
    }};

    @Test
    public void TestCollectionClone() {
        // Este método está en la clase padre Sort (que es Abstract) y ninguna otra clase lo implementa por su
        // propia cuenta. De esta forma, es posible usar cualquier sort para realizar este test
        Sorter<String> sorter = new GnomeSort<>();
        // Crear una nueva colección
        Collection<String> collection = new ArrayList<>();
        // Añadir unos objetos random
        collection.add("unos");
        collection.add("objetos");
        collection.add("random");
        // Realizar el clon
        Collection<String> clon = sorter.cloneCollection(collection);
        // Convertir amos a array
        String[] originalArray = collection.toArray(new String[0]);
        String[] clonArray = clon.toArray(new String[0]);
        // ! Ambos array deben ser iguales
        assertArrayEquals(originalArray, clonArray);
        // ! Los objetos clon y collection no deben ser los mismos
        assertNotSame(collection, clon);
    }

    @Test
    public void TestForwardSort() {
        for (Sorter<Integer> sorter : integerSorters) {
            Collection<Integer> collection = new ArrayList<>();
            // Agrega los números ordenados de tal forma que es imposible que un ordenamiento incompleto pase el test
            // La teoría es:
            // 1. Hay 2 números o menos, consecutivos, que son siempre mayor (o menor) a su anterior.
            // 1.1. La obvia implicación es que la lista no está ordenada ascendente o descendente
            // 2. No se repiten los números
            // 3. Entre cada dos números existe una separación de 2 o más
            collection.add(5);
            collection.add(9);
            collection.add(0);
            collection.add(8);
            collection.add(2);
            collection.add(6);
            collection.add(4);
            collection.add(7);
            collection.add(1);
            collection.add(3);
            // Agregar el 0 y el 9 como repetidos para obviar bugs respecto a sorts incompletos
            collection.add(0);
            collection.add(9);
            // Agregar 4 números repetidos a la lista para que ni el 0 ni el 9 queden en el borde
            collection.add(1);
            collection.add(8);
            collection.add(3);
            collection.add(6);
            // Clonar la colección para referencia
            Collection<Integer> reference = sorter.cloneCollection(collection);
            // Realizar el sort
            Collection<Integer> sorted = sorter.forwardSort(collection);
            // El resultado esperado es el siguiente
            Integer[] expected = {0, 0, 1, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 9, 9};
            // Conventir a array para comparar
            Integer[] produced = sorted.toArray(new Integer[0]);
            // ! El array debe estar ordenado
            assertArrayEquals("El sort \"" + sorter.getClass().getName() + "\" produjo resultados inesperados",
                    expected, produced);
            // ! La colección original debe ser igual a la referencia
            Integer[] collectionArray = collection.toArray(new Integer[0]);
            Integer[] referenceArray = reference.toArray(new Integer[0]);
            assertArrayEquals(referenceArray, collectionArray);
            // ! Ninguno de los dos anteriores debe ser igual al ordendado porque el array original está desordenado
            assertThat(expected, not(equalTo(referenceArray)));
        }
    }

    @Test
    public void TestBackwardSort() {
        for (Sorter<Integer> sorter : integerSorters) {
            Collection<Integer> collection = new ArrayList<>();
            // Agrega los números ordenados de tal forma que es imposible que un ordenamiento incompleto pase el test
            collection.add(5);
            collection.add(9);
            collection.add(0);
            collection.add(8);
            collection.add(2);
            collection.add(6);
            collection.add(4);
            collection.add(7);
            collection.add(1);
            collection.add(3);
            // Agregar el 0 y el 9 como repetidos para obviar bugs respecto a sorts incompletos
            collection.add(0);
            collection.add(9);
            // Agregar 4 números repetidos a la lista para que ni el 0 ni el 9 queden en el borde
            collection.add(1);
            collection.add(8);
            collection.add(3);
            collection.add(6);
            // Clonar la colección para referencia
            Collection<Integer> reference = sorter.cloneCollection(collection);
            // Realizar el sort
            Collection<Integer> sorted = sorter.backwardSort(collection);
            // El resultado esperado es el siguiente
            Integer[] expected = {9, 9, 8, 8, 7, 6, 6, 5, 4, 3, 3, 2, 1, 1, 0, 0};
            // Conventir a array para comparar
            Integer[] produced = sorted.toArray(new Integer[0]);
            // ! El array debe estar ordenado
            assertArrayEquals("El sort \"" + sorter.getClass().getName() + "\" produjo resultados inesperados",
                    expected, produced);
            // ! La colección original debe ser igual a la referencia
            Integer[] collectionArray = collection.toArray(new Integer[0]);
            Integer[] referenceArray = reference.toArray(new Integer[0]);
            assertArrayEquals(referenceArray, collectionArray);
            // ! Ninguno de los dos anteriores debe ser igual al ordendado porque el array original está desordenado
            assertThat(expected, not(equalTo(referenceArray)));
        }
    }

}
