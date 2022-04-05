package Session_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimsAlgorithm {

    static class Graph{

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
        int[][] costMtrix;
        int numV;

        public Graph(int[][] conn){
            this.numV = conn.length;
            this.costMtrix = new int[numV][numV];
            for(int i=0; i<numV; i++){
                for(int j=0; j<numV; j++){
                    if(conn[i][j]==0){
                        this.costMtrix[i][j] = Integer.MAX_VALUE;
                    }else{
                        this.costMtrix[i][j] = conn[i][j];
                    }
                }
            }
            for(int i=0; i<numV; i++){
                for(int j=0; j<numV; j++){
                    if(this.costMtrix[i][j] == Integer.MAX_VALUE){
                        System.out.print("X ");
                    }else{
                        System.out.print(this.costMtrix[i][j]+" ");
                    }
                }
                System.out.println();
            }
        }

        public List<Edge> primsAlgorithm(){
            List<Edge> edgeList = new ArrayList<>();
            boolean[] reached = new boolean[numV];
            reached[0] = true;
            int cost = 0;
            for(int vertex=1; vertex<numV; vertex++){
                int u=0, v=0;
                for(int i=0; i<numV; i++){
                    for(int j=0; j<numV; j++){
                        if(reached[i] && !reached[j] && costMtrix[i][j]<costMtrix[u][v]){
                            u=i;
                            v=j;
                        }
                    }
                }
                edgeList.add(new Edge(u, v));
                cost+=costMtrix[u][v];
                reached[v] = true;
            }
            return edgeList;
        }

    }

    public static void main(String[] args) {
        int[][] conn = {
                { 0, 3, 0, 2, 0, 0, 0, 0, 4 }, // 0 //9*9
                { 3, 0, 0, 0, 0, 0, 0, 4, 0 }, // 1
                { 0, 0, 0, 6, 0, 1, 0, 2, 0 }, // 2
                { 2, 0, 6, 0, 1, 0, 0, 0, 0 }, // 3
                { 0, 0, 0, 1, 0, 0, 0, 0, 8 }, // 4
                { 0, 0, 1, 0, 0, 0, 8, 0, 0 }, // 5
                { 0, 0, 0, 0, 0, 8, 0, 0, 0 }, // 6
                { 0, 4, 2, 0, 0, 0, 0, 0, 0 }, // 7
                { 4, 0, 0, 0, 8, 0, 0, 0, 0 }  // 8
        };
        Graph g = new Graph(conn);
        System.out.println(g.primsAlgorithm());
    }
}
