/**
 * Created by vengelmann on 12/28/15.
 */

public class LLStack<Item> {
    private Node first;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty(){ return first == null; }

    public int size() { return N; }

    public void push(Item item)
    { // Add item to top of stack.
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop()
    { // Remove item from top of stack

        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item lastIn(){
        return first.item;
    }

    public void printLL(){
        for (Node x = first; x != null; x = x.next)
        {
            System.out.print(x.item + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args)
    {
        LLStack<String> s = new LLStack<String>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " " );
        }
        StdOut.println("(" + s.size() + " left on stack)");

        s.printLL();
    }
}
