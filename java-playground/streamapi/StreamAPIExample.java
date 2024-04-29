package streamapi;

import java.util.ArrayList;
import java.util.List;

public class StreamAPIExample {
    public static List<String> getShortNames(List<String> list){
        List<String> resList = new ArrayList<>();

        for(var name:list){
            StringBuilder s = new StringBuilder();
            for(var individualPart:name.split(" ")){
                s.append(individualPart.charAt(0));
            }
            resList.add(s.toString().toUpperCase());
        }
        return resList;
    }

    public static List<String> getvalidNames(List<String> list){
        List<String> resList = new ArrayList<>();

        for(var name:list){
            if(name.split(" ").length>1){
                resList.add(name);
            }
        }
        return resList;
    }

    public static String getAllName(List<String> list){
        StringBuilder s = new StringBuilder();

        for(int i=0;i<list.size();i++){
            s.append(list.get(i));
            if(i<list.size()-1){
                s.append(",");
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        List<String> names= List.of("Gaurav Mandal","Ram Kumar","Mohit Kumar","Shyam","jrnkefdngk");
        List<String> validNames=getvalidNames(names);
        List<String> shortNames=getShortNames(validNames);
        String allNames=getAllName(shortNames);
        System.out.println(validNames);
        System.out.println(shortNames);
        System.out.println(allNames);

    }
}
