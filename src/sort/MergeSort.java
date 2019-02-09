package sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MergeSort<E extends Comparable<E>> extends Sort<E>  {
    private void merge(List<E> list2, List<E> list1,
                              int low, int middle, int high)
// pre: data[middle..high] are ascending
// temp[low..middle-1] are ascending
// post: data[low..high] contains all values in ascending order
    {
        int ri = low; // result index
        int ti = low; // temp index
        int di = middle; // destination index
// while two lists are not empty merge smaller value
        while (ti < middle && di <= high)
        {
            if (list2.get(di).compareTo(list1.get(ti)) < 0) {
                list2.set(ri++, list2.get(di++)); // smaller is in high data
            } else {
                list2.set(ri++, list1.get(ti++));// smaller is in temp
            }
        }
// possibly some values left in temp array
        while (ti < middle)
        {
            list2.set(ri++, list1.get(ti++));// smaller is in temp

        }
// ...or some values left (in correct place) in data array
    }


    @Override
    public void forwardSortInPlace(Collection<E> collection) {
        List<E> asList = new ArrayList<>(collection);
        collection.clear();
        //Codigo adaptado del pseudocodigo en https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm
        List<E> list1 = new ArrayList<>();
        List<E> list2 = new ArrayList<>();
        for (int i = 0; i<asList.size()/2; i++){
            list1.set(i, asList.get(i));
        }
        for (int i = asList.size()/2; i<asList.size(); i++){
            list2.set(i, asList.get(i));
        }

        int n = asList.size()-+1;
        int middle = n/2;
        int i;
        if (n < 2) return;
// move lower half of data into temporary storage
        for (i = 0; i < middle; i++)
        {
            list1.set(i,list2.get(i));
        }
// sort lower half of array
        forwardSortInPlace(list1);
// sort upper half of array
        forwardSortInPlace(list2);
// merge halves together
        merge(list2,list1,0,middle, asList.size());

    }

    @Override
    public void backwardSortInPlace(Collection<E> collection) {
        List<E> asList = new ArrayList<>(collection);
        collection.clear();
    }
}
