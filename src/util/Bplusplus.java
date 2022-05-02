package util;

import java.util.List;

public class Bplusplus {
	int val;
	List<Bplusplus> children;

	public Bplusplus(int val, List<Bplusplus> children) {
		this.val = val;
		this.children = children;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public List<Bplusplus> getChildren() {
		return children;
	}

	public void setChildren(List<Bplusplus> children) {
		this.children = children;
	}
}
