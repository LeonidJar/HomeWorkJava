/**
 * HW1
 */

import java.util.Random;

public class HW1 {

    public static void main(String[] args) {
        //1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        
        int i = new Random().nextInt(2000);
        System.out.println("Random num i =  " + i);
        

        //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        
        int n = Integer.toBinaryString(i).length();
        System.out.println("Highest one bit =  " + n);


        //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1

        int temp = 0;

        for (int j = 0; j <= Short.MAX_VALUE; j++){
            if (j % n == 0){
                temp++;
            }
        }

        int[] m1 = new int[temp];
        temp = 0;

        for (int j = 0; j <= Short.MAX_VALUE; j++){
            if (j % n == 0){
                m1[temp++] = j;
            }
        }
        

        //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

        temp = 0;

        for (int j = Short.MIN_VALUE; j <= i; j++){
            if (j % n != 0){
                temp++;
            }
        }

        int[] m2 = new int[temp];
        temp = 0;

        for (int j = Short.MIN_VALUE; j <= i; j++){
            if (j % n != 0){
                m2[temp++] = j;
            }
        }
    }
}