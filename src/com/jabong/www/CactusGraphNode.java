package com.jabong.www;

import java.util.ArrayList;
import java.util.List;

public class CactusGraphNode {

	private int id;
	private List<CactusGraphNode> neighbors;
	private boolean isVisitied;
	private boolean isCommonVertex;
	
	public CactusGraphNode(int id){
		this.id = id;
	}
	
	public CactusGraphNode(int id, CactusGraphNode neighbor){
		this.id = id;
		addNeighbor(neighbor);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<CactusGraphNode> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(List<CactusGraphNode> neighbors) {
		this.neighbors = neighbors;
	}
	public boolean isVisitied() {
		return isVisitied;
	}
	public void setVisitied(boolean isVisitied) {
		this.isVisitied = isVisitied;
	}
	
	public void addNeighbor(CactusGraphNode neighbor){
		if(this.neighbors == null){
			this.neighbors = new ArrayList<CactusGraphNode>();
		}
		this.neighbors.add(neighbor);
	}

	public boolean isCommonVertex() {
		return isCommonVertex;
	}

	public void setCommonVertex(boolean isCommonVertex) {
		this.isCommonVertex = isCommonVertex;
	}
	
	
	
}
