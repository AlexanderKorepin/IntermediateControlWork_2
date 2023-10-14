import java.util.ArrayList;
import java.util.List;

// класс, позволяющий создать набор игрушек. Класс принимает список уникальных типов игрушек и учитывает их вес. 
public class ToySet{
    List<Toy> toyList;

    public ToySet(List<Toy> toyList) {
        this.toyList = toyList;
    }
    public  List<Toy> fillingOutToySet(List<Toy> toyList) {
        List <Toy> toySet = new ArrayList<>();
        for(Toy toy:toyList){
            for(int i = 0; i < toy.getWeight(); i++ ){
                toySet.add(toy);
            }
        }
        return toySet;
    }
}