package session_22;

import java.util.*;

public class Graph {

    Map<Integer, List<Integer>> adjList;
    int numV;

    public Graph(){
        adjList = new HashMap<>();
    }

    public Graph(int numV){
        this.numV = numV;
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

    public void connectedComponent(){
        Set<Integer> vis = new HashSet<>();
        int count = 1;
        for(int vertex: this.adjList.keySet()){
            if(!vis.contains(vertex)){
                System.out.print("Connected Component "+count+" => ");
                dfsHelper(vertex, vis);
                count++;
                System.out.println();
            }
        }
    }

    private void sSSP(int src) {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(src);

        Map<Integer, Integer> dis = new HashMap<>();
        for (int vertex : this.adjList.keySet()) {
            dis.put(vertex, Integer.MAX_VALUE);
        }
        dis.put(src, 0);

        while (!bfs.isEmpty()) {
            int frontV = bfs.poll();
            List<Integer> neighbourList = this.adjList.getOrDefault(frontV, new ArrayList<>());
            for (int neighbour : neighbourList) {
                if (dis.get(neighbour) == Integer.MAX_VALUE) {
                    int newDistance = dis.get(frontV) + 1;
                    dis.put(neighbour, newDistance);
                    System.out.println(neighbour + " is at a distance " + newDistance + " from source " + src);
                    bfs.add(neighbour);
                }
            }
        }
    }

    public int[] indegree(){
        int[] indegreeArr = new int[this.numV];
        for(List<Integer> neighbour: this.adjList.values()){
            for(int vertex: neighbour){
                indegreeArr[vertex]++;
            }
        }
        return indegreeArr;
    }

    public void topologicalSorting(){
        int[] indegree = this.indegree();
        Queue<Integer> bfs = new LinkedList<>();
        for(int i=0;i<numV;i++){
            if(indegree[i] == 0){
                bfs.add(i);
            }
        }
        while(!bfs.isEmpty()){
            int front = bfs.poll();
            System.out.print(front+" ");
            for(int neighbour: this.adjList.getOrDefault(front, new ArrayList<>())){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    bfs.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
//      g.addEdge(1, 2, true);
//		g.addEdge(1, 3, true);
//		g.addEdge(2, 4, true);
//		g.addEdge(3, 4, true);
//      g.addEdge(3, 5, true);
//		g.addEdge(5, 6, true);
//      g.addEdge(7, 8, true);
//		g.display();
//
//		g.connectedComponent();
//		g.sSSP(4);

        g.addEdge(0, 1, false);
		g.addEdge(0, 2, false);
		g.addEdge(2, 3, false);
		g.addEdge(2, 4, false);
		g.addEdge(3, 1, false);
		g.addEdge(4, 6, false);
		g.addEdge(5, 3, false);
		g.addEdge(5, 6, false);
		g.display();
		g.indegree();
		g.topologicalSorting();
		g.indegree();


    }
}
