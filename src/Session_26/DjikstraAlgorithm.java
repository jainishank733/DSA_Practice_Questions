package Session_26;

import Session_25.PrimsAlgorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DjikstraAlgorithm {

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
                        this.costMtrix[i][j] = 999999;
                    }else{
                        this.costMtrix[i][j] = conn[i][j];
                    }
                }
            }
            for(int i=0; i<numV; i++){
                for(int j=0; j<numV; j++){
                    if(this.costMtrix[i][j] == 999999){
                        System.out.print("X ");
                    }else{
                        System.out.print(this.costMtrix[i][j]+" ");
                    }
                }
                System.out.println();
            }
        }

        public void djikstras(int src){
            boolean[] vis = new boolean[this.numV];
            vis[src] = true;
            System.out.println("Node choosen is: "+src);
            int[] dis = new int[this.numV];
            for(int node=0; node<numV; node++){
                dis[node] = this.costMtrix[src][node];
            }
            System.out.println(Arrays.toString(dis));
            int nextChoosen;
            for(int count=1; count<numV; count++){
                for(nextChoosen=0;nextChoosen<numV; nextChoosen++){
                    if(!vis[nextChoosen]){
                        break;
                    }
                }
                for(int k = nextChoosen+1; k < numV; k++){
                    if(!vis[k] && dis[k]<dis[nextChoosen]){
                        nextChoosen = k;
                    }
                }
                vis[nextChoosen] = true;
                System.out.println("Node choosen is "+nextChoosen);
                for(int neigh = 0; neigh<this.numV;neigh++){
                    if(!vis[neigh] && dis[neigh]>dis[nextChoosen]+this.costMtrix[nextChoosen][neigh]){
                        dis[neigh] = dis[nextChoosen]+this.costMtrix[nextChoosen][neigh];
                    }
                }
            }
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
        g.djikstras(0);
    }
}
