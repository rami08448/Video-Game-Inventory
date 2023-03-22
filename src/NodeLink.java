public class NodeLink<X> {
    public X memory;
    public NodeLink<X> next;


    public NodeLink(X name) {
        memory = name;
        next = null;
    }
}

