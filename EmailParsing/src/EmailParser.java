import java.util.*;

public class EmailParser {
    public static void main(String[] args) {
        HashMap<String,TreeSet<String>> map = new HashMap<>();
        String emailsString="gaurav@gmail.com,gaurav1@gmail.com,shyama@outlook.com,ram@yahoo.com,karan@gmail.com,raj@gmail.com,ketan@yahoo.com,gaurav@skype.com,gaurav@hotmail.com,ram@gmail.com";
        List<String> emails=new LinkedList<>(List.of(emailsString.split(",")));
        for(var email:emails){
            String emailer=email.substring(email.lastIndexOf("@")+1,email.lastIndexOf('.'));
            TreeSet<String> set= map.get(emailer);
            if(set==null){
                set = new TreeSet<String>();
            }
            set.add(email);
            map.put(emailer,set);
        }

        for(var mailers:map.keySet()){
            System.out.println(mailers);
            System.out.println(map.get(mailers)+"\n");
        }
        }
}