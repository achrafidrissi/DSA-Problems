import java.util.ArrayList;
import java.util.List;

public class DynamicArray {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries){
        List<List<Integer>> list  = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();
        int lastAnswer = 0;

        for (int i = 0; i<n ; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<queries.size(); i++){
            int index = (queries.get(i).get(1) ^ lastAnswer) % n;
            if(queries.get(i).get(0) == 1){
                list.get(index).add(queries.get(i).get(2));
            }else if (queries.get(i).get(0) == 2){
                int temp = queries.get(i).get(2) % list.get(index).size();
                lastAnswer = list.get(index).get(temp);
                answers.add(lastAnswer);
            }
        }
    return answers;
    }
}
