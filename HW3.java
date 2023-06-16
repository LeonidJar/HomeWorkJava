import java.util.ArrayList;
import java.util.Random;

public class HW3 {

    public static void main(String[] args) {
        // Пусть дан произвольный список целых чисел.
        ArrayList<Integer> numList = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) numList.add(new Random().nextInt(20));

        System.out.println(numList);

        // Нужно удалить из него чётные числа
        System.out.println("Нужно удалить из него чётные числа");

        ArrayList<Integer> numList1 = numList;

        for (int i = 0; i < numList1.size(); i++){
            if (numList1.get(i) % 2 == 0){
                numList1.remove(i);
                i--;
            }
        }

        System.out.println(numList1);

        // Найти минимальное значение
        // Найти максимальное значениела
        System.out.println("Найти минимальное значение");

        int min = numList.get(0);
        int max = numList.get(0);

        for (int i = 1; i < numList.size(); i++){
            if (numList.get(i) < min) min = numList.get(i);
            if (numList.get(i) > max) max = numList.get(i);
        }

        System.out.println("min = " + min);
        System.out.println("Найти максимальное значение");
        System.out.println("max = " + max);

        // Найти среднее значение
        System.out.println("Найти среднее значение");
        int average = 0;

        for (int i = 0; i < numList.size(); i++) average += numList.get(i);

        System.out.println(average / numList.size());
    }
}
