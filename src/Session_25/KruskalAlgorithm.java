package Session_25;

import java.lang.reflect.Array;
import java.util.*;

public class KruskalAlgorithm {

    static class EdgeList{

        class Edge{
            int u;
            int v;
            int weight;

            public Edge(int u, int v, int weight){
                this.u = u;
                this.v = v;
                this.weight = weight;
            }

            public String toString(){
                return "{" + this.u + ", " + this.v +", " + this.weight + "}";
            }

        }
        int numV;
        List<Edge> edgeList;

        public EdgeList(int numV){
            this.numV = numV;
            this.edgeList = new ArrayList<>();
        }

        public void addEdge(int u, int v, int weight){
            Edge edge = new Edge(u, v, weight);
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

        public int kruskalAlgorithm(int[] parent){
            Collections.sort(this.edgeList, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.weight-o2.weight;
                }
            });
            int cost = 0;
            for(Edge edge: this.edgeList){
                int u = edge.u;
                int v = edge.v;
                int weight = edge.weight;
                int godFatherU = this.find(parent, u);
                int godFatherV = this.find(parent, v);
                if(godFatherU!=godFatherV){
                    cost+=weight;
                    this.union(parent, godFatherU, godFatherV);
                }
            }
            return cost;
        }

    }

    public static void main(String[] args) {
        EdgeList g = new EdgeList(4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 2);
        g.addEdge(2, 3, 3);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 4, 2);

        int[] parent = new int[5];
        Arrays.fill(parent,-1);
        System.out.println(g.kruskalAlgorithm(parent));

    }

}
