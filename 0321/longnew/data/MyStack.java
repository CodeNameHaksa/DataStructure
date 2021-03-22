import java.util.LinkedList;

public class MyStack implements Stack{
    private LinkedList list = new LinkedList();

    @Override
    public void push(Object object) {
        // TODO Auto-generated method stub
        list.addLast(object);
    }

    @Override
    public Object peek() {
        // TODO Auto-generated method stub
        if (isEmpty()) throw new IllegalStateException("stack is empty");
        return list.getLast();
    }

    @Override
    public Object pop() {
        // TODO Auto-generated method stub
        if (isEmpty()) throw new IllegalStateException("stack is empty");
        Object ret = list.getLast();
        list.removeLast();
        return ret;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return list.isEmpty();
    }

}
