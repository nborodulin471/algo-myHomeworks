package list;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printme();

        System.out.println("Добавим 0");
        stack.push(0);
        stack.printme();

        System.out.println("Добавим 1");
        stack.push(1);
        stack.printme();

        System.out.println("Добавим 2");
        stack.push(2);
        stack.printme();

        System.out.println("Добавим 3");
        stack.push(3);
        stack.printme();

        System.out.println("Добавим 4");
        stack.push(4);
        stack.printme();

        System.out.println("Добавим 5");
        stack.push(5);
        stack.printme();

        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();

        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();

        System.out.println("Ревёрс!");
        stack = stack.reverse();
        stack.printme();

        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();

        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();

        System.out.println("Ревёрс!");
        stack = stack.reverse();
        stack.printme();

        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();

        System.out.println("Снимем со стека");
        System.out.println(stack.pop());
        stack.printme();

    }
}
