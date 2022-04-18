import java.util.ArrayList;
import java.util.List;

public class BattleField {
   List<List<Character>> charactersList = null;
   public BattleField(){
       charactersList= new ArrayList<>();
       for (int i = 0; i<25; i++){
           charactersList.add(new ArrayList<>());
       }
   }
}
