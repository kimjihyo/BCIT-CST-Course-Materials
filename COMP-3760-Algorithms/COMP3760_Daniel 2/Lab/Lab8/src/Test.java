public class Test {
    public static void main(String[] args) {
        System.out.println("------Generating a first graph-------");
        AdjGraph first = new AdjGraph(5);

        first.addEdge(0, 1);
        first.addEdge(0, 3);
        first.addEdge(0, 4);
        first.addEdge(1, 2);
        first.addEdge(1, 4);
        first.addEdge(2, 3);
        first.addEdge(3, 4);

        System.out.println(first.toString());
        System.out.println("degree of vertex3 is " + first.degree(0));
        System.out.println("degree of vertex2 is " + first.degree(2));


        System.out.println("------Generating a second graph-------");
        AdjGraph second = new AdjGraph(4);
        second.addEdge(0, 1);
        second.addEdge(1, 2);
        second.addEdge(2, 3);

        System.out.println(first.toString());
        System.out.println("degree of vertex0 is " + second.degree(0));
        System.out.println("degree of vertex2 is " + second.degree(2));


        System.out.println("------Generating a directed Graph-------");
        AdjGraph directed = new AdjGraph(5);
        directed.directed = true;
        boolean result = directed.isDirected();

        directed.addEdge(0, 0);
        directed.addEdge(0, 4);
        directed.addEdge(1, 2);
        directed.addEdge(1, 4);
        directed.addEdge(2, 0);
        directed.addEdge(2, 3);
        directed.addEdge(3, 1);
        directed.addEdge(3, 2);
        directed.addEdge(4, 3);

        System.out.println("directed = " + result + "\n");
        System.out.println(directed.toString());

        System.out.println("In degree of vertex0 is " + directed.inDegree(0));
        System.out.println("Out degree of vertex0 is " + directed.outDegree(0));
        System.out.println();
        System.out.println("In degree of vertex2 is " + directed.inDegree(2));
        System.out.println("Out degree of vertex2 is " + directed.outDegree(2));


        System.out.println("------Generating a Detail graph-------");
        AdjGraph detail = new AdjGraph(8);
        detail.addEdge( 0, 1 );
        detail.addEdge( 0, 2 );
        detail.addEdge( 0, 4 );
        detail.addEdge( 1, 3 );
        detail.addEdge( 1, 5 );
        detail.addEdge( 2, 3 );
        detail.addEdge( 2, 6 );
        detail.addEdge( 3, 7 );
        detail.addEdge( 4, 5 );
        detail.addEdge( 4, 6 );
        detail.addEdge( 5, 7 );
        detail.addEdge( 6, 7 );
        System.out.println( detail.toString() );
        System.out.println("DFS : ");
        detail.DFS();
        System.out.println("BFS : ");
        detail.BFS();

        System.out.println("First graph hasCycle : " + first.hasCycle());
        System.out.println("Second graph hasCycle : " + second.hasCycle());
        System.out.println("Directed graph hasCycle : " + directed.hasCycle());
        System.out.println("Detail graph hasCycle : " + detail.hasCycle());
    }
}
