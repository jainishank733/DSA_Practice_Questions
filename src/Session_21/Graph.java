package Session_21;

import java.util.*;

public class Graph {

    Map<Integer, List<Integer>> adjList;

    public Graph(){
        adjList = new HashMap<>();
    }

    private void addEdge(int u, int v, boolean biDir){
        List<Integer> uNeighbour = this.adjList.getOrDefault(u, new ArrayList<>());
        uNeighbour.add(v);
        adjList.put(u, uNeighbour);
        if(biDir){
            List<Integer> vNeighbour = this.adjList.getOrDefault(v, new ArrayList<>());
            uNeighbour.add(u);
            adjList.put(v, vNeighbour);
        }
    }

    private void display(){
        for(var entry: adjList.entrySet()){
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            System.out.println(key+" => "+list);
        }
    }

    private void bfs(int src){
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(src);
        Set<Integer> vis = new HashSet<>();
        vis.add(src);
        while(!bfs.isEmpty()){
            int front = bfs.poll();
            System.out.print(front+" ");
            List<Integer> uNeighbours = this.adjList.getOrDefault(front, new ArrayList<>());
            for(int neighbour: uNeighbours){
                if(!vis.contains(neighbour)){
                    bfs.add(neighbour);
                    vis.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    private void dfsHelper(int src, Set<Integer> vis){
        System.out.print(src+" ");
        vis.add(src);
        List<Integer> neighbourList = this.adjList.getOrDefault(src, new ArrayList<>());
        for(int neighbour: neighbourList){
            if(!vis.contains(neighbour)){
                dfsHelper(neighbour, vis);
            }
        }
    }

    private void dfs(int src){
        Set<Integer> vis = new HashSet<>();
        dfsHelper(src, vis);
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 4, true);
        g.addEdge(3, 4, true);

        g.addEdge(3, 5, true);
        g.addEdge(5, 6, true);

        g.display();

        g.bfs(2);

        g.dfs(2);

    }
}
