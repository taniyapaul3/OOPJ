import java.util.Scanner;

class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

class Father {
    public Father(int ageFather) throws WrongAge {
        if (ageFather < 0) {
            throw new WrongAge("Father's age should be greater than or equal to 0.");
        }
    }
}

class Son extends Father {
    public Son(int ageFather, int ageSon) throws WrongAge {
        super(ageFather);
        if (ageSon >= ageFather) {
            throw new WrongAge("Son's age should be less than the father's age.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter father's age: ");
        int ageFather = sc.nextInt();

        System.out.print("Enter son's age: ");
        int ageSon = sc.nextInt();

        try {
            new Son(ageFather, ageSon);
            System.out.println("Father's and Son's ages are valid.");
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
