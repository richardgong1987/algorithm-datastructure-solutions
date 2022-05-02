# My version of the Dijkstra implementation

```java
import java.util.LinkedList;
import java.util.List;

public class MyDijkstra {
	public static class Vertex {
		String data;

		Vertex(String data) {
			this.data = data;
		}
	}

	public static class Edge {
		int index;
		int weight;

		Edge(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}

	public static class Graph {
		public int size;
		Vertex[] vertex;
		List<Edge>[] adjacency;

		Graph(int size) {
			this.size = size;
			this.vertex = new Vertex[size];
			this.adjacency = new LinkedList[size];
			for (int i = 0; i < size; i++) {
				this.vertex[i] = new Vertex("");
				this.adjacency[i] = new LinkedList();
			}
		}
	}

	public static int[] dijkstra(Graph graph, int start) {
		int size = graph.size;

		boolean[] visited = new boolean[size];

		int[] roads = new int[size];

		visited[0] = true;

		for (int i = 1; i < size; i++) {
			roads[i] = Integer.MAX_VALUE;
		}

		for (Edge edge : graph.adjacency[start]) {
			roads[edge.index] = edge.weight;
		}

		for (int i = 1; i < size; i++) {
			// (1). search the min Item, get it road, get it index
			int minRoad = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int j = 1; j < size; j++) {
				if (!visited[j] && roads[j] < minRoad) {
					minRoad = roads[j];
					minIndex = j;
				}
			}

			if (minIndex == -1) {
				break;
			}

			visited[minIndex] = true;
			//(2). update road shortest path 
			for (Edge edge : graph.adjacency[minIndex]) {
				if (!visited[edge.index] &&  (edge.weight + minRoad) < roads[edge.index]) {
					roads[edge.index] = edge.weight + minRoad;
				}
			}
		}
		return roads;

	}

	public static void main(String[] args) {
		Graph graph = new Graph(7);
		String[] vt = new String[]{"A", "B", "C", "D", "E", "F", "G"};
		for (int i = 0; i < vt.length; i++) {
			graph.vertex[i] = new Vertex(vt[i]);
		}

		graph.adjacency[0].add(new Edge(1, 5));
		graph.adjacency[0].add(new Edge(2, 2));

		graph.adjacency[1].add(new Edge(0, 5));
		graph.adjacency[1].add(new Edge(3, 1));
		graph.adjacency[1].add(new Edge(4, 6));

		graph.adjacency[2].add(new Edge(0, 2));
		graph.adjacency[2].add(new Edge(3, 6));
		graph.adjacency[2].add(new Edge(5, 8));

		graph.adjacency[3].add(new Edge(1, 1));
		graph.adjacency[3].add(new Edge(2, 6));
		graph.adjacency[3].add(new Edge(4, 1));
		graph.adjacency[3].add(new Edge(5, 2));

		graph.adjacency[4].add(new Edge(1, 6));
		graph.adjacency[4].add(new Edge(3, 1));
		graph.adjacency[4].add(new Edge(6, 7));

		graph.adjacency[5].add(new Edge(2, 8));
		graph.adjacency[5].add(new Edge(3, 2));
		graph.adjacency[5].add(new Edge(6, 3));

		graph.adjacency[6].add(new Edge(4, 7));
		graph.adjacency[6].add(new Edge(5, 3));

		int[] result = dijkstra(graph, 0);
		System.out.println(result[6]);

	}
}
```

## Dijkstra

```java
public static int[] dijkstraTheSameAgain(Graph graph, int start){
    int size = graph.size;
    boolean[] visited = new boolean[size];
    visited[0] = true;

    int[] roads = new int[size];
    for(int i = 1; i < size; i++){
        roads[i] = Integer.MAX_VALUE;
    }    
    for(Edge edge:graph.adjacency[start]){
        roads[edge.index] = edge.weight;
    }
    for(int i = 1; i < size; i++){
        //(1). get min item minIndex,and minRoad
        int minIndex = -1;
        int minRoad = Integer.MAX_VALUE;   
        for(int j = 1; j < size; j++){
            if(!visited[j] && roads[j] < minRoad){
                minIndex = j;
                minRoad = roads[j];
            }
        }
        if(minIndex == -1){
            break;
        }
        visited[minIndex] = true;

        //(2). update shortest roads
        for(Edge edge:graph.adjacency[minIndex]){
            if(!visited[edge.index] && minRoad + edge.weight < roads[edge.index]){
                roads[edge.index] = minRoad + edge.weight;
            }
        }
    }
    return roads;
           
}
```
