package Spring.lesson3.Task1.dao;

import Spring.lesson3.Task1.models.Person;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void saveToFile(Person person) {
        try (Writer fileWriter = new FileWriter("C:\\Users\\Вова\\IdeaProjects\\Java_ITVDN\\JavaSpring\\src\\main\\resources\\data.txt", true)) {
            fileWriter.write(person.getId() +
                    " " + person.getName() +
                    " " + person.getSurname() +
                    " " + person.getEmail() +
                    " " + person.getPhone() + "\n");
            System.out.println("Successful");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> showFile() {
        String s = "";
        try (Reader fileReader = new FileReader("C:\\Users\\Вова\\IdeaProjects\\Java_ITVDN\\JavaSpring\\src\\main\\resources\\data.txt")) {
            int temp;
            for (; ; ) {
                temp = fileReader.read();
                if (temp == -1) break;
                s += (char) temp;
            }
            System.out.println("Text from FileWriter.txt:");
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Pattern p = Pattern.compile(".*@?.*", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(s);

        List<String> emailList = new ArrayList<>();
        while (m.find()) {
            String email = m.group();
            emailList.add(email);
        }
        return emailList;
    }

    public void update(int id, Person person) {
        Person personUpdate = show(id);
        personUpdate.setName(person.getName());
        personUpdate.setSurname(person.getSurname());
        personUpdate.setEmail(person.getEmail());
        personUpdate.setPhone(person.getPhone());
    }

    public void remove(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
