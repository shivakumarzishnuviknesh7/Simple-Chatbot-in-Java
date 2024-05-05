import java.util.Scanner;

public class SimpleChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! I'm your chatbot. What's your name?");
        String name = scanner.nextLine();

        System.out.println("Nice to meet you, " + name + "! How can I assist you today?");

        while (true) {
            String userInput = scanner.nextLine();
            String response = getResponse(userInput);
            System.out.println(response);
        }
    }

    public static String getResponse(String userInput) {
        // Basic responses for demonstration purposes
        if (userInput.contains("hello") || userInput.contains("hi")) {
            return "Hi there!";
        } else if (userInput.contains("how are you")) {
            return "I'm just a bot, but thanks for asking!";
        } else if (userInput.contains("bye")) {
            return "Goodbye! Have a great day!";
        } else {
            return "I'm sorry, I didn't understand that.";
        }
    }
}
