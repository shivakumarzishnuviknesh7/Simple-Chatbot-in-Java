import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBotUI extends JFrame {
    private JTextField userInputField;
    private JTextArea chatArea;

    public ChatBotUI() {
        setTitle("Simple ChatBot");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        userInputField = new JTextField();
        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(userInputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    private void sendMessage() {
        String userInput = userInputField.getText();
        chatArea.append("You: " + userInput + "\n");
        String response = SimpleChatBot.getResponse(userInput);
        chatArea.append("ChatBot: " + response + "\n");
        userInputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChatBotUI chatBotUI = new ChatBotUI();
                chatBotUI.setVisible(true);
            }
        });
    }
}
