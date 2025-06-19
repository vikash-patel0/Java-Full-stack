import java.util.HashMap;

public class StudentMarks {
    public static void main(String[] args){
        HashMap<String,Integer> book = new HashMap<>();
        book.put("vikash",100);
        book.put("alex",70);
        book.put("will",95);
        for(String i : book.keySet()){
            System.out.println(i+" = "+ book.get(i));
        }
        book.put("alex",80);
        System.out.println("\nalex new grade: "+book.get("alex"));
        System.out.println("\nvikash marks: "+book.get("vikash"));
        book.remove("will");
        System.out.println("\nnew book >>>");
        int sum=0;
        for(String i : book.keySet()) {
            System.out.println(i + " = " + book.get(i));
            sum+=book.get(i);
        }
        int avg=sum/book.size();
        System.out.println("\navg marks: "+avg);

    }


}
