import java.util.ArrayList;
import java.util.Scanner;

public class HW4  {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Integer> age = new ArrayList<Integer>();
        ArrayList<String> gen = new ArrayList<String>();
        ArrayList<Integer> index = new ArrayList<Integer>();

        menu(name, age, gen, index, input);

        input.close();
    }

    public static void menu(ArrayList<String> name, ArrayList<Integer> age, ArrayList<String> gen, ArrayList<Integer> index, Scanner input){
        System.out.println("1: Добавить контакт \n2: Показать список \n3: Отсортировать по возрасту и показать список \n4: Выход");
        
        for (int i = 0; i < name.size(); i++) index.add(i, i);
        switch (Integer.parseInt(input.nextLine())) {
            case 1:   
                addContact(name, age, gen, index, input);
                break;
        
            case 2:   
                printList(name, age, gen, index);
                break;
        
            case 3:
                printList(name, age, gen, ageSort(age, index));
                break;

            case 4:
                System.exit(0);

        }
    }

    public static void addContact(ArrayList<String> name, ArrayList<Integer> age, ArrayList<String> gen, ArrayList<Integer> index, Scanner input){
        System.out.println("Введите ФИО возраст и пол");

        while (true) {
            System.out.println("Введите ФИО");
            name.add(input.nextLine());

            System.out.println("Введите возраст");
            age.add(Integer.parseInt(input.nextLine()));

            System.out.println("Введите пол");
            gen.add(input.nextLine());

            System.out.println("Добавить еще контакт? пустая строка -> нет");
            if (input.nextLine().length() == 0){
                menu(name, age, gen, index, input);
                break;
            }
        }
    }

    public static ArrayList<Integer> ageSort(ArrayList<Integer> age, ArrayList<Integer> index) {
        ArrayList<Integer> agetmp = new ArrayList<Integer>(age);

        for (int j = index.size() - 1; j >= 1; j--){
            for (int i = 0; i < j; i++){
                if (agetmp.get(i) > agetmp.get(i + 1)){
                    int tmp = agetmp.get(i);      
                    agetmp.set(i, agetmp.get(i + 1));       
                    agetmp.set(i + 1, tmp); 

                    tmp = index.get(i);      
                    index.set(i, index.get(i + 1));       
                    index.set(i + 1, tmp); 
                }
            }
        }

        agetmp = null;

        return index;
    }

    public static void printList(ArrayList<String> name, ArrayList<Integer> age, ArrayList<String> gen, ArrayList<Integer> index){
        for (int i = 0; i < index.size(); i++){
            System.out.println(name.get(index.get(i)) + " " + age.get(index.get(i)) + " " + gen.get(index.get(i)) + "\n");
        }
    }
    
}