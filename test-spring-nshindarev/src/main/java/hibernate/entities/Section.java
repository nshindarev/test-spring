package hibernate.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( name = "child_section",
            joinColumns =  @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id"))
    private List<Child> children;

    public Section(String name) {
        this.name = name;
    }

    public void addChild(Child child){
        if (this.children == null){
            children = new LinkedList<>();
        }
        children.add(child);
    }
}
