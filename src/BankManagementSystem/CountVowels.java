package BankManagementSystem;

public class CountVowels {
    public static int countVowels(String s){
        s = s.toLowerCase();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                result++;
            }
        }
        return (result>0) ? result : -404;
    }
    public static void main(String[] args) {
        String s = "The Allah is the best Planner";
        int count = countVowels(s);
        System.out.println("The vowels present in "+ s + " is :: " + count);
    }
}
