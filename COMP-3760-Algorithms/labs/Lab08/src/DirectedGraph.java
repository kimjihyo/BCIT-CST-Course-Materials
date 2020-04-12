import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DirectedGraph {
    private Vertex[] vertices;

    public static class Vertex {
        private int index;
        private String label;
        private Set<Vertex> adjacentVertices;
        private int inDegree;

        public Vertex(int index, String label) {
            this.index = index;
            this.label = label;
            this.adjacentVertices = new HashSet<>();
            this.inDegree = 0;
        }

        public void addEdge(Vertex vertex) {
            this.adjacentVertices.add(vertex);
        }

        public int getIndex() {
            return this.index;
        }

        public String getLabel() {
            return this.label;
        }

        public Set<Vertex> getAdjacentVertices() {
            return this.adjacentVertices;
        }

        public int getInDegree() {
            return this.inDegree;
        }
    }

    public DirectedGraph(String filepath) {
        this.constructGraphFromFile(filepath);
    }

    public void printGraph() {
        System.out.print("Vertex labels: ");
        for (int i = 0; i < this.vertices.length; i++) {
            System.out.print(String.format("%d:%s ", i, this.vertices[i].getLabel()));
        }

        System.out.println("\nAdjacency matrix:");
        for (Vertex rv : this.vertices) {
            for (Vertex cv : this.vertices) {
                if (rv.getAdjacentVertices().contains(cv)) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.print("\n");
        }
    }

    public String[] topoSort() {
        String[] result = new String[this.vertices.length];
        List<Integer> indicesToStart = new ArrayList<>();

        for (int i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i].getInDegree() == 0) {
                indicesToStart.add(i);
            }
        }
        if (indicesToStart.isEmpty()) {
            return new String[]{};
        }

        boolean[] visited = new boolean[this.vertices.length];
        int counter = this.vertices.length - 1;

        for (int index : indicesToStart) {
            counter = topoSortDFS(index,visited, result, counter);
        }
        return result;
    }

    private int topoSortDFS(int vertexIndex, boolean[] visited, String[] labelsInOrder, int counter) {
        visited[vertexIndex] = true;
        for (Vertex v : this.vertices[vertexIndex].getAdjacentVertices()) {
            if (!visited[v.getIndex()]) {
                counter = topoSortDFS(v.getIndex(), visited, labelsInOrder, counter);
            }
        }
        labelsInOrder[counter] = this.vertices[vertexIndex].getLabel();
        return counter - 1;
    }

    private void constructGraphFromFile(String filepath) {
        try {
            Scanner reader = new Scanner(new File(filepath));
            if (!reader.hasNextLine()) {
                System.out.println("The file is empty.");
                return;
            }

            int numberOfVertices = Integer.parseInt(reader.nextLine());
            this.vertices = new Vertex[numberOfVertices];

            for (int i = 0; i < numberOfVertices; i++) {
                String label = reader.nextLine();
                this.vertices[i] = new Vertex(i, label);
            }

            int numberOfEdges = Integer.parseInt(reader.nextLine());

            for (int i = 0; i < numberOfEdges; i++) {
                String edgeInRawString = reader.nextLine();
                int vertexIndexFrom = edgeInRawString.charAt(0) - 48;
                int vertexIndexTo = edgeInRawString.charAt(2) - 48;
                this.vertices[vertexIndexFrom].addEdge(this.vertices[vertexIndexTo]);
                this.vertices[vertexIndexTo].inDegree++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DirectedGraph dg = new DirectedGraph("clothing_graph.txt");
        dg.printGraph();
        System.out.println("Topo Sort");
        for (String label : dg.topoSort()) {
            System.out.print(label + " ");
        }
        System.out.print("\n");
    }
}
