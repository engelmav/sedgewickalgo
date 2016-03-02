
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;
    private int maxSize;

    public FixedCapacityStackOfStrings(int cap)
    {
        maxSize = cap;
        a = new String[cap];
    }

    public boolean isEmpty()    { return N == 0; }
    public boolean isFull()     { return N >= maxSize; }
    public int size()           { return N; }

    public void push(String item)
    {
        a[N++] = item;
        System.out.println("Pushed item " + item);
    }

    public String pop()
    { return a[--N]; }

    public static void main(String[] args){
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(3);
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + "");
            if (s.isFull()) StdOut.print("Full now");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}