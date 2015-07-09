package Person;

/**
 * Created by jeansmits on 9/07/15.
 */
public class Group {
    private String name;
    private Group parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return parent;
    }

    public void setGroup(Group group) {
        this.parent= group;
    }

    public Group(String name, Group parent) {
        this.name = name;
        this.parent = parent;
    }

    public Group() {
    }
}
