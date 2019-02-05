package InputOutput;
import ListsAndIterators.ArrayUnorderedList;
import UserData.User;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class UserImporter {
    final String PATH;
    private JSONParser parser;
    private FileReader fileReader;

    public UserImporter(String path){
        PATH = path;
        parser = new JSONParser();
        try {
            fileReader= new FileReader(PATH);
        } catch (FileNotFoundException e) {
            fileReader = null;
        }
    }

    public ArrayUnorderedList<User> getUsers(){
        if(fileReader==null){
            return null;
        }
        ArrayUnorderedList<User> finalUserList = new ArrayUnorderedList<>();
        int i = 0;
        JSONArray userArray = null;
        try {
            userArray = ((JSONArray)((JSONObject) parser.parse(fileReader)).get("grafoSocial"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(Object user: userArray){
            JSONObject jUser = (JSONObject) user;

            //Simple fields

            int id = ((Long)jUser.get("id")).intValue();
            int age = ((Long)jUser.get("idade")).intValue();
            String email = (String)jUser.get("email");
            String name = (String)jUser.get("nome");
            int views = ((Long)jUser.get("visualizacoes")).intValue();
            //More complex fields
            //Academic Experience
            ArrayUnorderedList<User.Pair<Integer,String>> academicFormation = new ArrayUnorderedList<>();
            JSONArray academicFormationArray =(JSONArray) jUser.get("formacaoAcademica");
            Iterator<Object> iterAF = academicFormationArray.iterator();
            while (iterAF.hasNext()){
                JSONObject pairOfAF = ((JSONObject)iterAF.next());
                int ano = ((Long)pairOfAF.get("ano")).intValue();
                String formacao = (String)pairOfAF.get("formacao");
                User.Pair<Integer, String> pair = new User.Pair<>(ano, formacao);
                academicFormation.addToRear(pair);
            }
            //professional Experience
            ArrayUnorderedList<User.Triplet<Integer,String,String>> professionalExperience = new ArrayUnorderedList<>();
            JSONArray professionalExperienceArray = (JSONArray) jUser.get("cargosProfissionais");
            Iterator<Object> iterPE = professionalExperienceArray.iterator();
            while (iterPE.hasNext()){
                JSONObject tripletOfPE = ((JSONObject)iterPE.next());
                int ano = ((Long)tripletOfPE.get("ano")).intValue();
                String cargo = (String)tripletOfPE.get("cargo");
                String empresa = (String)tripletOfPE.get("empresa");
                User.Triplet<Integer,String,String> triplet = new User.Triplet<>(ano,cargo,empresa);
                professionalExperience.addToRear(triplet);
            }
            //skills
            ArrayUnorderedList<String> skills = new ArrayUnorderedList<>();
            JSONArray skillsArray = (JSONArray) jUser.get("skills");
            for (Object o :
                    skillsArray) {
                skills.addToRear((String)o);
            }
            //mencoes
            ArrayUnorderedList<Integer> mentions = new ArrayUnorderedList<>();
            JSONArray mentionsArray = (JSONArray) jUser.get("mencoes");
            for (Object o :
                    mentionsArray) {
                mentions.addToRear( ((Long)((JSONObject)o).get("userid")).intValue());
            }
            ArrayUnorderedList<Integer> contacts = new ArrayUnorderedList<>();
            JSONArray contactsArray = (JSONArray) jUser.get("contacts");
            for (Object o :
                    contactsArray) {
                contacts.addToRear( ((Long)((JSONObject)o).get("userid")).intValue());
            }
            finalUserList.addToRear(new User(id, name, age, email, views,academicFormation, professionalExperience, skills, contacts, mentions));
        }
        return finalUserList;
    }
}

