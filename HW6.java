import java.util.HashMap;
import java.util.Random;
import java.util.Iterator;

public class HW6 {
    public static void main(String[] args) {
        SetImitatiom setImitatiom = new SetImitatiom();

        System.out.println(setImitatiom.add(9));
        System.out.println(setImitatiom.delete(9));

        for (int i = 0; i < 10; i++) {
            setImitatiom.add(new Random().nextInt(1000));
        }

        Iterator<Integer> iterator = setImitatiom.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(setImitatiom.getElementByIndex(3));
        System.out.println(setImitatiom.toString());
    }
}

class SetImitatiom<E> {
    private HashMap<E, Object> list = new HashMap<>();

    private static final Object OBJECT = new Object();

    public boolean add(E num) {
        return list.put(num, OBJECT) == null;    
    }

    public boolean delete(E num) {
        return list.remove(num, OBJECT);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean conteins(Object num) {
        return list.containsKey(num);
    }

    public Iterator<E> iterator() {
        return list.keySet().iterator();
    }

    public E getElementByIndex(int index) {
        E[] array = (E[]) list.keySet().toArray();

        return array[index];
    }

    public String toString() {
        return list.keySet().toString();
    }
}
