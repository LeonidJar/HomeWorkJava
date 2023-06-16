import java.util.LinkedHashMap;
import java.util.Map;

public class HW2 {

    public static void main(String[] args) {
// ана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// В итоге должно получится select * from students where name=Ivanov, country=Russia, city=Moscow
        StringBuilder task = new StringBuilder("select * from students where ");
        Map<String, String> wherePart = new LinkedHashMap<>();
        wherePart.put("name","Ivanov");
        wherePart.put("country","Russia");
        wherePart.put("city","Moscow");
        wherePart.put("age",null);

        System.out.println(wherePart);

        String[] s = wherePart.toString().replace("{", "")
                                        .replace("}", "")
                                        .split(", ");

        for (int i = 0; i < s.length; i++){
            if (s[i].indexOf("null") == -1){
                task.append(s[i] + ", ");
            }
        }

        task.delete(task.length() - 2, task.length() - 1);

        System.out.println(task);

// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
        Map<String, String> pupil1 = new LinkedHashMap<>();
        pupil1.put("фамилия","Иванов");
        pupil1.put("оценка","5");
        pupil1.put("предмет","Математика");

        Map<String, String> pupil2 = new LinkedHashMap<>();
        pupil2.put("фамилия","Петрова");
        pupil2.put("оценка","4");
        pupil2.put("предмет","Информатика");

        Map<String, String> pupil3 = new LinkedHashMap<>();
        pupil3.put("фамилия","Краснов");
        pupil3.put("оценка","5");
        pupil3.put("предмет","Физика");

        System.out.println(pupil1);
        System.out.println(pupil2);
        System.out.println(pupil3);

        String[] result = {"Студент", "получил", "по предмету"};
        StringBuilder marks = new StringBuilder(pupil1.toString());
        marks.append(pupil2.toString()).append(pupil3.toString());

        String[] marksString = marks.toString().replace("{", "").split("}");

        for(int i = 0; i < result.length; i++){
            System.out.println(result[0] + " " + marksString[i].substring(marksString[i].indexOf("=") + 1, marksString[i].indexOf(" ") - 1) + " "
                            + result[1] + " " + marksString[i].substring(marksString[i].indexOf("=", marksString[i].indexOf("=") + 1) + 1, marksString[i].indexOf(" ", marksString[i].indexOf(" ") + 1) - 1) + " "
                            + result[2] + " " + marksString[i].substring(marksString[i].lastIndexOf("=") + 1));
        }

    }
    
}
