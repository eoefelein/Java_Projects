import java.util.NoSuchElementException;


public class Stack<T>

{

    private final List<T> stackList;


    // no-argument constructor

    public Stack()

    {

        stackList = new List<>("stack");

    }


    // add object to stack

    public void push(T object)

    {

        stackList.insertAtFront(object);

    }


    // remove object from stack

    public T pop() throws NoSuchElementException

    {

        return stackList.removeFromFront();

    }


    public T peek() throws NoSuchElementException

    {

        T temp = pop(); // remove from stack

        push(temp); // push back on to stack

        return temp; // return value

    }


    // determine if stack is empty

    public boolean isEmpty()

    {

        return stackList.isEmpty();

    }


    // output stack contents

    public void print()

    {

        stackList.print();

    }

}