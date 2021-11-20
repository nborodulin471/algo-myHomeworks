package list;

public class Stack {

    Node head;

    private class Node {

        Object value;
        Stack.Node prev;

        Node(Object value, Stack.Node prev) {
            this.value = value;
            this.prev = prev;
        }

    }

    public void push(Object value) {

        if (head == null) {
            head = new Node(value, null);
        } else {
            Node node = new Node(value, head);
            head = node;
        }
    }

    public Object pop(){

        Object value;

        if (head == null) {
            return "нет элементов!";
        } else {
            value = head.value;
            head = head.prev;
        }

        return value;

    }

    public void printme() {

        StringBuilder builder = new StringBuilder();

        if (head == null) {
            builder.append("EMPTY");
        } else {
            Node node = head;
            while (node != null) {
                builder.append(node.value);
                if (node.prev != null) {
                    builder.append(" -> ");
                }
                node = node.prev;
            }
        }
        System.out.println(builder);
    }

    public Stack reverse() {

        if (head == null) {
            return new Stack();
        }

        Stack reversed_stack = new Stack();
        Node new_head = reversed_head(head)[0];
        reversed_stack.head = new_head;

        return reversed_stack;
    }

    private Node[] reversed_head(Node node) {

        Node new_node = new Node(node.value, null);

        if (node.prev == null) {

            return new Node[]{
                    new_node,
                    new_node};

        } else {

            Node[] nodesRevers = reversed_head(node.prev);
            head = nodesRevers[0];
            Node tail = nodesRevers[1];
            tail.prev = new_node;

            return new Node[]{
                    head,
                    new_node};

        }
    }
}
