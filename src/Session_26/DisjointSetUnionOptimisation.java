package Session_26;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisjointSetUnionOptimisation {

    static class EdgeList{

        class Edge{
            int u;
            int v;

            public Edge(int u, int v){
                this.u = u;
                this.v = v;
            }

            public String toString() {

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
            return parent[u] = find(parent, parent[u]);
        }

        public void union(int[] parent, int u, int v, int[] rank){
            int godFatherU = this.find(parent, u);
            int godFatherV = this.find(parent, v);
            if(godFatherU!=godFatherV){
                if(rank[godFatherU]<rank[godFatherV]){
                    parent[godFatherU] = godFatherV;
                    rank[godFatherV] += rank[godFatherU];
                }else{
                    parent[godFatherV] = godFatherU;
                    rank[godFatherU] += rank[godFatherV];
                }
            }
        }

        public void display() {
            System.out.println(this.edgeList);
        }

        private boolean hasCycle(int[] parent, int[] rank) {
            for(Edge edge : this.edgeList) {
                int u = edge.u;
                int v = edge.v;

                int godfatherU = this.find(parent, u);
                int godfatherV = this.find(parent, v);

                if(godfatherU != godfatherV) {
                    this.union(parent, godfatherU, godfatherV, rank);
                } else { //cycle
                    return true;
                }
            }

            return false;
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
        int[] rank = new int[5];
        Arrays.fill(rank,1);
        System.out.println(graph.hasCycle(parent, rank));

    }

}
