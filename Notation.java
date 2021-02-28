/**
 * Class: CMSC204 
 * Instructor: Alexander
 * Description: This program checks passwords to see if they meet the listed parameters.
 * Due: 2/27/2021
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Andrew Cudd  
 * @author Andrew Cudd
*/
public class Notation {
	private static NotationStack<String> stack = new NotationStack<String>(10);

	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		return 0;
	}

	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		int size = postfix.length();
		NotationStack<String> answer = new NotationStack<String>(50);
		char ch;
		try {
			for (int i = 0; i < size; i++) {
				ch = postfix.charAt(i);
				while (ch == ' ') {
					i++;
					ch = postfix.charAt(i);
				}
				if (Character.isDigit(ch)) {
					answer.push(Character.toString(ch));
				} else {
					switch (ch) {
					case '+':
					case '-':
					case '*':
					case '/':
						if(answer.isEmpty()) {
							throw new InvalidNotationFormatException();
						}
						String one = answer.pop();
						if(answer.isEmpty()) {
							throw new InvalidNotationFormatException();
						}
						String two = answer.pop();
						String str = "(" + answer.top() + one + two + ")";
						answer.push(str);
					}
				}
			}
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		} catch (StackOverflowException e) {
			e.printStackTrace();
		}
		try {
			answer.pop();
			String check = answer.pop();
			throw new InvalidNotationFormatException();
		} catch (StackUnderflowException e) {

		}
		return answer.toString();
	}

	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		int size = infix.length();
		char ch;
		NotationQueue<String> postFix = new NotationQueue<String>(50);
		try {
			for (int i = 0; i < size; i++) {
				ch = infix.charAt(i);
				while (ch == ' ') {
					i++;
					ch = infix.charAt(i);
				}
				if (Character.isDigit(ch)) {
					postFix.enqueue(Character.toString(ch));
				} else {
					switch (ch) {
					case '+':
					case '-':
					case '*':
					case '/':
						while ((!stack.isEmpty() && (precedence(stack.top(), ch)))) {
							postFix.enqueue(stack.pop());
						}
						stack.push(Character.toString(ch));
						break;
					case '(':
						stack.push("(");
						break;
					case ')':
						if (!stack.isEmpty()) {
							while (!(stack.top().equals("("))) {
								postFix.enqueue(stack.pop());
							}
						}
						stack.pop();
						break;
					default:
						throw new InvalidNotationFormatException();
					}
				}
			}
			while (!stack.isEmpty()) {
				if (stack.top().equals("(")) {
					stack.pop();
				} else {
					postFix.enqueue(stack.top());
					stack.pop();
				}
			}
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		} catch (StackOverflowException e) {
			e.printStackTrace();
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
		return postFix.toString();
	}

	public static boolean precedence(String str, char ch) {
		boolean flag = false;
		char front = str.charAt(0);

		switch (front) {
		case '*':
		case '/':
			if (front == '+' || front == '-' || front == '*' || front == '/') {
				flag = true;
			}
			break;
		case '+':
		case '-':
			if (front == '+' || front == '-') {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
