package structures;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/10/13
 * Time: 5:18 PM
  */
public class Stack {
    private int maxSize;
    private int[] dataArray;
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        dataArray = new int[maxSize];
    }

    public void push(int data){
        if (!isFull()){
            top++;
            dataArray[top] = data;
        } else {
            throw new IndexOutOfBoundsException("The stack is full");
        }
    }

    public int pop(){
        if (!isEmpty()){
            return dataArray[top--];
        } else {
            throw new IndexOutOfBoundsException("The stack is empty");
        }
    }

    public int peek(){
        return dataArray[top];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == - 1;
    }
}
