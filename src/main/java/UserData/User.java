package UserData;
import ListsAndIterators.ListADT;
import ListsAndIterators.*;
public class User implements Comparable<User>{

    public static class Pair<T, K>{
        T first;
        K second;

        public Pair(T first, K second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public K getSecond() {
            return second;
        }

        public void setSecond(K second) {
            this.second = second;
        }
    }
    public static class Triplet<T, K , V> {
        T first;
        K second;
        V third;

        public Triplet(T first, K second, V third) {

        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public K getSecond() {
            return second;
        }

        public void setSecond(K second) {
            this.second = second;
        }

        public V getThird() {
            return third;
        }

        public void setThird(V third) {
            this.third = third;
        }
    }

    private int id;
    private String name;
    private int age;
    private String email;
    private boolean isMale;
    private int views;

    private UnorderedListADT<Pair<Integer, String>> academicFormation;
    private UnorderedListADT<Triplet<Integer, String, String>> professionalExperience;
    private UnorderedListADT<String> skills;
    private UnorderedListADT<User> contacts;
    private UnorderedListADT<User> mentions;


    public User(int id, String name, int age, String email, int views) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.views = views;
        this.academicFormation = new ArrayUnorderedList<Pair<Integer, String>>();
        this.professionalExperience = new ArrayUnorderedList<Triplet<Integer, String, String>>();
        this.skills = new ArrayUnorderedList<String>();
        this.contacts = new ArrayUnorderedList<User>();
        this.mentions = new ArrayUnorderedList<User>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isMale() {
        return isMale;
    }
    public void setMale(boolean male) {
        isMale = male;
    }
    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }
    public UnorderedListADT<Pair<Integer, String>> getAcademicFormation() {
        return academicFormation;
    }
    public void setAcademicFormation(UnorderedListADT<Pair<Integer, String>> academicFormation) {
        this.academicFormation = academicFormation;
    }
    public UnorderedListADT<Triplet<Integer, String, String>> getProfessionalExperience() {
        return professionalExperience;
    }
    public void setProfessionalExperience(UnorderedListADT<Triplet<Integer, String, String>> professionalExperience) {
        this.professionalExperience = professionalExperience;
    }
    public UnorderedListADT<String> getSkills() {
        return skills;
    }
    public void setSkills(ListsAndIterators.UnorderedListADT<String> skills) {
        this.skills = skills;
    }
    public UnorderedListADT<User> getContacts() {
        return contacts;
    }
    public void setContacts(UnorderedListADT<User> contacts) {
        this.contacts = contacts;
    }
    public UnorderedListADT<User> getMentions() {
        return mentions;
    }
    public void setMentions(UnorderedListADT<User> mentions) {
        this.mentions = mentions;
    }
    @Override
    public int compareTo(User user) {
        return  (this.getId() - user.getId());
    }
}
