import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ErrorException {
        Scanner scanner = new Scanner(System.in);

        String inputText;
        inputText = scanner.nextLine();
        String[] dataArray = inputText.split(" ");

        FirstCheckerAndChoseFormat checker = new FirstCheckerAndChoseFormat(dataArray);
    }
}