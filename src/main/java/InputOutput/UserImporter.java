package InputOutput;
import ListsAndIterators.ArrayUnorderedList;
import UserData.User;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class UserImporter {
    final String PATH;
    private User[] userList;
    JSONParser parser;
    FileReader fileReader;

    public UserImporter(String path){
        PATH = path;
        parser = new JSONParser();
        try {
            fileReader= new FileReader(PATH);
        } catch (FileNotFoundException e) {
            fileReader = null;
        }
    }

    public void getUsers(){
        if(fileReader==null){
            return;
        }
        int i = 0;
        for(Object user: userList){
            //Simple fields
            JSONObject jUser = (JSONObject) user;
            int id = (int)jUser.get("id");
            int age = (int)jUser.get("idade");
            String email = (String)jUser.get("email");
            String name = (String)jUser.get("nome");
            int views = (int)jUser.get("visualizacoes");
            userList[i] = new User(id, name, age, email, views);
            //More complex fields
            //Academic Experience
            ArrayUnorderedList<User.Pair<Integer,String>> formacaoAcademica = new ArrayUnorderedList<>();
            JSONArray academicFormation =(JSONArray) jUser.get("formacaoAcademica");
            Iterator<Object> iterAF = academicFormation.iterator();
            while (iterAF.hasNext()){
                JSONObject pairOfAF = ((JSONObject)iterAF.next());
                int ano = (int)pairOfAF.get("ano");
                String formacao = (String)pairOfAF.get("formacao");
                User.Pair<Integer, String> pair = new User.Pair<>(ano, formacao);
                formacaoAcademica.addToFront(pair);
            }
            //professional Experience
            ArrayUnorderedList<User.Triplet<Integer,String,String>> experienciaProfissional = new ArrayUnorderedList<>();
            JSONArray professionalExperience = (JSONArray) jUser.get("cargosProfissionais");
            Iterator<Object> iterPE = professionalExperience.iterator();
            while (iterPE.hasNext()){
                JSONObject tripletOfPE = ((JSONObject)iterPE.next());
                int ano = (int)tripletOfPE.get("ano");
                String cargo = (String)tripletOfPE.get("cargo");
                String empresa = (String)tripletOfPE.get("empresa");
                User.Triplet<Integer,String,String> triplet = new User.Triplet<>(ano,cargo,empresa);
                experienciaProfissional.addToFront(triplet);
            }
            ArrayUnorderedList<String> skills = new ArrayUnorderedList<>();

        }
    }
}

