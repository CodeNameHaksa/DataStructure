public class App {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push("1st");
        stack.push("2nd");
        stack.push("3rd");

        System.out.println("stack size: " + stack.size());
        System.out.println("stack pop: " + stack.pop());
        System.out.println("stack pop: " + stack.pop());
        System.out.println("stack size: " + stack.size());
    }
}
