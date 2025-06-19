import java.util.*;
public class hmapimp {
    public static void main(String[] args){
        HashMap<String,Integer> hmap = new HashMap<>();
        hmap.put("vikash",100);
        hmap.put("alex",99);
        System.out.println(hmap.get("vikash"));
        System.out.println(hmap.containsKey("vikash"));
        System.out.println(hmap.containsValue(100));
        for(String i : hmap.keySet()){
            System.out.println(i+" = "+ hmap.get(i));
        }

    }
}
