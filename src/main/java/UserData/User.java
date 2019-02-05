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
    }
    public static class Triplet<T, K , V> {
        T first;
        K second;
        V third;

        public Triplet(T first, K second, V third) {
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }

    private int id;
    private String name;
    private int age;
    private String email;
    private int views;

    private UnorderedListADT<Pair<Integer, String>> academicFormation;
    private UnorderedListADT<Triplet<Integer, String, String>> professionalExperience;
    private UnorderedListADT<String> skills;
    private UnorderedListADT<Integer> contacts;
    private UnorderedListADT<Integer> mentions;


    public User(int id, String name, int age, String email, int views,ArrayUnorderedList<Pair<Integer, String>> academicFormation, ArrayUnorderedList<Triplet<Integer, String, String>> professionalExperience, ArrayUnorderedList<String> skills, ArrayUnorderedList<Integer> contacts, ArrayUnorderedList<Integer> mentions) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.views = views;
        this.academicFormation = academicFormation;
        this.professionalExperience = professionalExperience;
        this.skills = skills;
        this.contacts = contacts;
        this.mentions = mentions;
    }

    public User(int id, String name, int age, String email, int views) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.views = views;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public UnorderedListADT<Integer> getContacts() {
        return contacts;
    }
    public void setContacts(UnorderedListADT<Integer> contacts) {
        this.contacts = contacts;
    }
    public UnorderedListADT<Integer> getMentions() {
        return mentions;
    }
    public void setMentions(UnorderedListADT<Integer> mentions) {
        this.mentions = mentions;
    }
    @Override
    public int compareTo(User user) {
        return  (this.getId() - user.getId());
    }

    @Override
    public String toString() {
        String string = "\n\n";
        string+="id:\t"+id+"\n";
        string+="age:\t"+age+"\n";
        string+="name:\t"+name+"\n";
        string+="email:\t"+email+"\n";
        string+="views:\t"+views+"\n";
        String skillsString = "";
        for (String s :
                skills) {
            skillsString+=s+",\t";
        }
        string+="skills:\t"+skillsString+"\n";
        String contactsString = "";
        for (Integer i :
                contacts) {
            contactsString+=i+",\t";
        }
        string+="contacts:\t"+contactsString+"\n";
        String mentionsString = "";
        for (Integer i :
                mentions) {
            mentionsString += i + ",\t";
        }
        string+="mentions:\t"+mentionsString+"\n";
        String professionalExperienceString = "";
        for (Triplet<Integer, String, String> t :
                professionalExperience) {
            professionalExperienceString += "\n\t{ano: " + t.first + "\tcargo: " + t.second + "\t" + "empresa: " + t.third + "}";
        }
        string+="professional experience:\t"+professionalExperienceString;
        String academicFormationString = "";
        for (Pair<Integer,String> p:
                academicFormation) {
            academicFormationString += "\n\t{ano: " +p.first + "\tformacao: "+ p.second + "}";
        }
        string+="\nacademic formation:\t"+academicFormationString;
        return string;
    }
}
