package Session_23;

import java.util.*;

public class IsValidTree {

    static class Graph{

        Map<Integer, List<Integer>> adjList;

        public Graph(){
            adjList = new HashMap<>();
        }

        private void addEdge(int u, int v, boolean biDir){
            List<Integer> uNeighbour = this.adjList.getOrDefault(u, new ArrayList<>());
            uNeighbour.add(v);
            this.adjList.put(u, uNeighbour);

            if (biDir) {
                List<Integer> vNeighbour = this.adjList.getOrDefault(v, new ArrayList<>());
                vNeighbour.add(u);
                this.adjList.put(v, vNeighbour);
            }
        }

        private void display(){
            for(var entry: adjList.entrySet()){
                int key = entry.getKey();
                List<Integer> list = entry.getValue();
                System.out.println(key+" => "+list);
            }
        }

        private boolean isValidTree(int numV){
            Queue<Integer> queue = new LinkedList<>();
            int[] parent = new int[numV];
            for(int i=0;i<numV;i++){
                parent[i] = i;
            }
            Set<Integer> vis = new HashSet<>();
            queue.add(0);
            vis.add(0);
            while(!queue.isEmpty()){
                int front = queue.poll();
                for(int neighbour: this.adjList.getOrDefault(front, new ArrayList<>())){
                    if(!vis.contains(neighbour)){
                        vis.add(neighbour);
                        queue.add(neighbour);
                        parent[neighbour] = front;
                    }else if(parent[front]!=neighbour){
                        return false;
                    }
                }
            }
            return vis.size() == numV;
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph();
        int[][] edgeList = {{0,1}, {0,2}, {0,3}, {1,4}};
        int numV = 5;
        for(int i=0;i<edgeList.length;i++){
            g.addEdge(edgeList[i][0], edgeList[i][1], true);
        }
        g.display();
        System.out.println(g.isValidTree(numV));

    }
}




