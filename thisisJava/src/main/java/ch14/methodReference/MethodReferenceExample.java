package ch14.methodReference;

import java.util.function.IntBinaryOperator;

public class MethodReferenceExample {

  public static void main(String[] args) {
    IntBinaryOperator operator;

    //정적
    operator = (x, y) -> Calculator.staticMethod(x, y);
    System.out.println("결과1 " + operator.applyAsInt(1, 2));
    operator = Calculator::staticMethod;
    System.out.println("결과2 " + operator.applyAsInt(3, 4));

    //인스턴스 메서드
    Calculator calculator = new Calculator();
    operator = (x, y) -> calculator.instanceMethod(x, y);
    System.out.println("결과3 " + operator.applyAsInt(10, 11));

    operator = calculator::instanceMethod;
    System.out.println("결과4 " + operator.applyAsInt(12, 13));
  }

}
