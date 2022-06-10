package ru.eshakin.deeplay;

public class Application {
    public static void main(String[] args) {
        int HumanResult = Solution.getResult("STWSWTPPTPTTPWPP", "Human");
        System.out.println(HumanResult);
        int SwamperResult = Solution.getResult("STWSWTPPTPTTPWPP", "Swamper");
        System.out.println(SwamperResult);
        int Woodman = Solution.getResult("STWSWTPPTPTTPWPP", "Woodman");
        System.out.print(Woodman);
    }
}
