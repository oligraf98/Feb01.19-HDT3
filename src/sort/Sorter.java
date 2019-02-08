package sort;

import java.util.Collection;

/**
 * Esta interfaz es la interfaz común a todos los mecanismos de ordenamiento <i>Sorters</i>. Contiene el contrato básico
 * que deben cumplir todos los que implementen dicha interfaz. Esta interfaz utiliza genéricos.
 * <p>
 * En lugar de utilizar un Sorter agnóstico de del tipo (utilizando solo la interfaz Collection), he
 * (yo, NoTengoBattery) decidido utilizar un genérico E que extiende de Comparable para forzar el uso de objetos que
 * implementen Comparable (y por ende se puedan ordenar de forma determinística).
 */
public interface Sorter<E extends Comparable> {
    /**
     * Este método ordena una {@link Collection} de forma ascendente de acuerdo a las reglas y mecanismos definidos en
     * el propio objeto al implementar la interfaz {@link Comparable}. Este método devuelve una nueva {@link Collection}
     * ordenada sin modificar la original, utilizando el mecanismo <i>deep copy</i> de Java.
     *
     * @param collection la colección a ordenar
     * @return una colección nueva ordenada
     */
    Collection<E> forwardSort(Collection<E> collection);

    /**
     * Este método ordena una {@link Collection} de forma descendente de acuerdo a las reglas y mecanismos definidos en
     * el propio objeto al implementar la interfaz {@link Comparable}. Este método devuelve una nueva {@link Collection}
     * ordenada sin modificar la original, utilizando el mecanismo <i>deep copy</i> de Java.
     *
     * @param collection la colección a ordenar
     * @return una colección nueva ordenada
     */
    Collection<E> backwardSort(Collection<E> collection);

    /**
     * Este método ordena una {@link Collection} de forma ascendente de acuerdo a las reglas y mecanismos definidos en
     * el propio objeto al implementar la interfaz {@link Comparable}. Modifica la lista original en el sitio.
     *
     * @param collection la colección a ordenar
     */
    void forwardSortInPlace(Collection<E> collection);

    /**
     * Este método ordena una {@link Collection} de forma descendente de acuerdo a las reglas y mecanismos definidos en
     * el propio objeto al implementar la interfaz {@link Comparable}. Modifica la lista original en el sitio.
     *
     * @param collection la colección a ordenar
     */
    void backwardSortInPlace(Collection<E> collection);

    /**
     * Este método contiene código para copiar una colección a partir de la interfaz {@link Collection<E>} utilizando
     * reflexión. Genera una nueva colección a partir de la colección original. Es equivalente a crear una nueva
     * colección a partir del constructor que recibe una colección.
     *
     * @param collection la colección a copiar
     * @return la copia de la colección
     */
    Collection<E> cloneCollection(Collection<E> collection);
}
