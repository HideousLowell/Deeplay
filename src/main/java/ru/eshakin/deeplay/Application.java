package ru.eshakin.deeplay;

public class Application {
    public static void main(String[] args) {
        try {
            int result = Solution.getResult("STWSWTPPTPTTPWPP", "Human");
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
