package hibernate.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name = "child_section",
            joinColumns =  @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id"))
    private List<Section> sections;

    public Child addSection(Section section){
        if (this.sections == null){
            sections = new LinkedList<>();
        }
        sections.add(section);
        return this;
    }

    public Child() {

    }

    public Child(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


}
