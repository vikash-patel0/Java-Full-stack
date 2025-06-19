import java.util.*;
public class UniqueWordCounter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashSet<String> hsetU = new HashSet<>();
        HashSet<String> hsetdup = new HashSet<>();
        String str=sc.nextLine();
        String[] strSet= str.trim().toLowerCase().split("\\W+");
        System.out.println(strSet.length);

        for(String i : strSet){
            if(!hsetU.contains(i)){
                hsetU.add(i);
            }else{
                hsetdup.add(i);
                System.out.print(i+" ");
            }
        }
    }
}
