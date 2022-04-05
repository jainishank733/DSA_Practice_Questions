package Session_24;

import java.util.*;

public class CycleInDirectedGraph {

    static class Graph {

        Map<Integer, List<Integer>> adjList;

        int numV;

        public Graph(int numV) {
            this.numV = numV;
            adjList = new HashMap<>();
        }

        public Graph() {
            adjList = new HashMap<>();
        }

        private void addEdge(int u, int v, boolean biDir) {
            List<Integer> uNeighbour = this.adjList.getOrDefault(u, new ArrayList<>());
            uNeighbour.add(v);
            this.adjList.put(u, uNeighbour);

            if (biDir) {
                List<Integer> vNeighbour = this.adjList.getOrDefault(v, new ArrayList<>());
                vNeighbour.add(u);
                this.adjList.put(v, vNeighbour);
            }
        }

        private void display() {
            for (var entry : this.adjList.entrySet()) {
                int vertex = entry.getKey();
                List<Integer> neighbourList = entry.getValue();

                System.out.println(vertex + " -> " + neighbourList);
            }
        }

        public boolean helper(int src, List<Integer> path, Set<Integer> vis){
            vis.add(src);
            path.add(src);
            boolean hasCyc = false;
            for(int neighbour: this.adjList.getOrDefault(src,new ArrayList<>())){
                if(!vis.contains(neighbour)){
                    hasCyc = helper(neighbour, path, vis);
                }else if(path.contains(neighbour)){
                    return true;
                }
            }
            path.remove(path.size()-1);
            return  hasCyc;
        }

        public void hasCycle(){
            Set<Integer> vis = new HashSet<>();
            List<Integer> path = new ArrayList<>();
            System.out.println(helper(0,path,vis));
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, false);
        g.addEdge(1, 5, false);
        g.addEdge(5, 6, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);

        g.addEdge(4, 5, false);
        g.display();

        g.hasCycle();
    }
}
