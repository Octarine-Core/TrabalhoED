package UserData;

import ListsAndIterators.ArrayUnorderedList;

public class SystemInterface {
    /*
   *
    • Editar as ligações e visualizações no grafo após ser carregado do ficheiro;
    • Criar funções para testar se o grafo é completo (os utilizadores estão todos ligados entre si);
    • Verificar se dois utilizadores se encontram ligados entre si e apresentar o caminho mais curto
    entre eles usando as métricas descritas;
    • Verificar quais os utilizadores que são alcançáveis a partir de um determinado utilizador;
    • Listar utilizadores que não são possíveis de contactar, a partir de um determinado utilizador;
    • Verificar a partir de um dado utilizador qual a lista de utilizadores que fazem parte dos
    contactos da lista de contactos que têm determinados skills / trabalharam em determinada
    empresa. Em resumo todas as pessoas que o utilizador pode contactar via 1 único intermediário.
    • Apresentar uma lista de utilizadores de uma empresa passada como parâmetro que estão
    relacionados com um utilizador também passado como parâmetro;
    • Verificar que os utilizadores que ocupam um cargo numa empresa (ex: empresa A) não estão
    relacionados com a utilizadores com cargos noutra empresa passada como parâmetro (empresa
    B);
    • Apresentar uma lista de utilizadores que contém um determinado skill no seu perfil ordenado
    pelo menor custo de ligação. O método deverá ter como parâmetro o utilizador inicial.
     */

    ArrayUnorderedList<User> userList;

    User findUserFromEmail(String email){
        for (User u :
                userList) {
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    ArrayUnorderedList<User> findUsersEmployedAt(String company){
        ArrayUnorderedList<User> UsersEmployedAt = new ArrayUnorderedList<>();
        for (User u :
                userList) {
            for (User.Triplet<Integer,String,String> t:
                 u.getProfessionalExperience()) {
                if(t.third.equals(company)){
                    UsersEmployedAt.addToRear(u);
                }
            }
        }
        return UsersEmployedAt;
    }

}
