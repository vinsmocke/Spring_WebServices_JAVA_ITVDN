package Spring.lesson4.Task2.persistence.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String position;

    public Employee(){

    }

    public Employee(int id, String name, String surname, String phone, String email, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }

    @Override
    public String toString() {
        return String.join(", ", new String[] {
                "Employee # " + id,
                name, position, phone
        });
    }
}
