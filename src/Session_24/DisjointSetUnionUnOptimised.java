package Session_24;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisjointSetUnionUnOptimised {

    static class EdgeList{

        class Edge{
            int u;
            int v;

            public Edge(int u, int v){
                this.u = u;
                this.v = v;
            }

            public String toString(){
                return "{" + this.u + ", " + this.v + "}";
            }

        }
        int numV;
        List<Edge> edgeList;

        public EdgeList(int numV){
            this.numV = numV;
            this.edgeList = new ArrayList<>();
        }

        public void addEdge(int u, int v){
            Edge edge = new Edge(u, v);
            this.edgeList.add(edge);
        }

        public int find(int[] parent, int u){
            if(parent[u]==-1){
                return u;
            }
            return find(parent, parent[u]);
        }

        public void union(int[] parent, int u, int v){
            int godFatherU = this.find(parent, u);
            int godFatherV = this.find(parent, v);
            if(godFatherU!=godFatherV){
                parent[godFatherU] = godFatherV;
            }
        }

        public void display(){
            System.out.println(this.edgeList);
        }

    }

    public static void main(String[] args) {
        EdgeList graph = new EdgeList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);

        int[] parent = new int[5];
        Arrays.fill(parent, -1);
        graph.display();
        System.out.println(graph.find(parent, 0));
        graph.union(parent, 0,1);
        graph.union(parent, 2,3);
        graph.union(parent, 0,2);
        System.out.println(graph.find(parent, 0));

    }

}
