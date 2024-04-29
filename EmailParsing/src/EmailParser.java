import java.util.*;

public class EmailParser {
    public static void main(String[] args) {
        HashMap<String,Stack<String>> map = new HashMap<>();
        String emailsString="gaurav@gmail.com,gaurav1@gmail.com,shyama@outlook.com,ram@yahoo.com,karan@gmail.com,raj@gmail.com,ketan@yahoo.com,gaurav@skype.com,gaurav@hotmail.com,ram@gmail.com";
        List<String> emails=new LinkedList<>(List.of(emailsString.split(",")));
        for(var email:emails){
            String emailer=email.substring(email.lastIndexOf("@")+1,email.lastIndexOf('.'));
            Stack<String> stack= map.get(emailer);
            if(stack==null){
                stack = new Stack<String>();
            }
            stack.push(email);
            map.put(emailer,stack);
        }
        List<Stack<String>> individual=new ArrayList<>();
        for(var mailers:map.keySet()){
            System.out.printf("%30s",mailers);
            individual.add(map.get(mailers));
        }
        System.out.println();
        Stack<String> k=new Stack<>();
        while(!k.isEmpty()){
            for (var mailers : map.keySet()) {
                k = map.get(mailers);
                System.out.printf("%30s", k.peek());
                k.pop();
            }
            System.out.println();
        }
        }
}