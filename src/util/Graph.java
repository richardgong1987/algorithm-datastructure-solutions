package util;

import java.util.LinkedList;

//图（邻接表形式）
public class Graph {
	public int size;
	public Vertex[] vertexes;
	public LinkedList<Integer>[] adj;

	public Graph(int size) {
		this.size = size;
		//初始化顶点和邻接矩阵
		vertexes = new Vertex[size];
		adj = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			vertexes[i] = new Vertex(i);
			adj[i] = new LinkedList();
		}
	}
}
