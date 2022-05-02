package codesignal.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnsafeBridges {
	int solution(int n, int[][] bridges, int[][] newBridges) {
		UnsafeBridgeSolver solver = new UnsafeBridgeSolver(n);
		long unsafe = 0, total = 0;
		for (int[] bridge : bridges) {
			unsafe += solver.addBridge(bridge[0], bridge[1]);
		}
		for (int[] bridge : newBridges) {
			unsafe += solver.addBridge(bridge[0], bridge[1]);
			total += unsafe;
		}
		return (int) (total % 1000000007);
	}

	class UnsafeBridgeSolver {
		class BridgeBlock {
			public List<Integer> nodes = new ArrayList<>();
			public int parentIndex = -1;
			public int name;

			public BridgeBlock(int node) {
				nodes.add(node);
				name = node;
			}

			public BridgeBlock getParent(BridgeBlock[] arr) {
				if (parentIndex == -1) return null;
				else return arr[parentIndex];
			}
		}

		private BridgeBlock[] bridgeBlocks;
		private int[] components;

		public UnsafeBridgeSolver(int nodes) {
			bridgeBlocks = new BridgeBlock[nodes];
			components = new int[nodes];
			for (int i = 0; i < nodes; i++) {
				bridgeBlocks[i] = new BridgeBlock(i);
				components[i] = i;
			}
		}

		public int addBridge(int nodeA, int nodeB) {
			if (bridgeBlocks[nodeA] == bridgeBlocks[nodeB])
				return 0; // if they are in the same component already, do nothing
			//use a normal union fond to figure out of it is a link or merge
			int parentA = findParent(nodeA, components);
			int parentB = findParent(nodeB, components);
			if (parentA == parentB)
				return merge(bridgeBlocks[nodeA], bridgeBlocks[nodeB]);
			components[parentA] = parentB;
			link(bridgeBlocks[nodeA], bridgeBlocks[nodeB]);
			return 1;
		}

		private int merge(BridgeBlock a, BridgeBlock b) {
			Set<BridgeBlock> nodesFound = new HashSet<>();
			BridgeBlock current = a;
			while (current != null) {
				nodesFound.add(current);
				current = current.getParent(bridgeBlocks);
			}
			BridgeBlock other = b;
			while (other != null) {
				if (nodesFound.contains(other)) {
					int result = mergeInto(a, other);
					return result + mergeInto(b, other);
				}
				other = other.getParent(bridgeBlocks);
			}
			return Integer.MIN_VALUE;
		}

		private int mergeInto(BridgeBlock node, BridgeBlock target) {
			int result = 0;
			while (node != target) {
				List<Integer> childNodes = node.nodes;
				node = node.getParent(bridgeBlocks);
				for (Integer childNode : childNodes) {
					bridgeBlocks[childNode] = target;
					target.nodes.add(childNode);
				}
				result--;
			}
			return result;
		}

		private void link(BridgeBlock a, BridgeBlock b) {
			BridgeBlock old = a;
			BridgeBlock current = a.getParent(bridgeBlocks);
			while (current != null) {
				BridgeBlock next = current.getParent(bridgeBlocks);
				current.parentIndex = old.name;
				old = current;
				current = next;
			}
			a.parentIndex = b.name;
		}
	}

	private int findParent(int node, int[] parent) {
		while (parent[node] != node) {
			parent[node] = parent[parent[node]];
			node = parent[node];
		}
		return node;
	}
}
