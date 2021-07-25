package edu.pdx.cs410J.ramayan2;

import java.util.Stack;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Kata {


  public static void main(String[] args) {

    if (args.length == 0) {
      System.err.println("Missing command line arguments");
      System.exit(1);
    }

    Stack<Integer> myStack = new Stack<>();
    //String regex = "(\\d+(?:\\.\\d+)?)";
    int res = 0;
    for (String arg : args) {
      if (arg.matches("\\d+")) {
          myStack.push(Integer.parseInt(arg));
      } else {
        int num1 = myStack.pop();
        int num2 = myStack.pop();
        switch (arg) {
          case "+":
            res = num1 + num2;
            myStack.push(res);
            break;
          case "-":
            res = num2 - num1;
            myStack.push(res);
            break;

          case "*":
            res = num1 * num2;
            myStack.push(res);
            break;

          case "/":
            res = num2 / num1;
            myStack.push(res);
            break;

          case "SQRT":
            res = (int) Math.sqrt(myStack.pop());
            break;
          case  "default":
            break;
        }
      myStack.push(res);
      }
    }
    System.out.println(myStack.pop());

  }
}