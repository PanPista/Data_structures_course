package weekOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketsInCodePrimitives {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        int length = text.length();
        int[] positions = new int[length];
        int top = 0;

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                positions[top] = i;
                top++;
            }
            if (c == ')' || c == ']' || c == '}') {
                if (top == 0) {
                    System.out.println(i + 1);
                    return;
                }
                top--;
                char opening = text.charAt(positions[top]);
                if ((opening == '(' && c != ')') || (opening == '[' && c != ']') || (opening == '{' && c != '}')) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }

        if (top == 0) {
            System.out.println("Success");
        } else {
            System.out.println(positions[0] + 1);
        }
    }
}
