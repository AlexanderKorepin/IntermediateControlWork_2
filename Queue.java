import java.util.List;
import java.util.PriorityQueue;

//класс позволяет из ранее полученного набора экземпляров игрушек
// сформировать очередь для упорядочиавания по весу
public class Queue {

    List<Toy> currentToyList;

    public Queue(List<Toy> currentToyList) {
        this.currentToyList = currentToyList;
    }

    public PriorityQueue<Toy> composePriorityQueue(List<Toy> currentToySet){

        PriorityQueue<Toy> queue = new PriorityQueue<>(new ToyComparator());
        queue.addAll(currentToySet);

        return queue;
    }



}
