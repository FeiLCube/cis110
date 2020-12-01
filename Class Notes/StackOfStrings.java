public class StackOfStrings {
    StringNode first; //head
    
    public StackOfStrings() {
        first = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(String value) {
        StringNode newNode = new StringNode(value);
        newNode.next = first;
        first = newNode;
    }
    
    public String pop() {
        String out = first.value;
        first = first.next;
        return out;
    }
    
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();
        System.out.println(sos.isEmpty());
    }
}