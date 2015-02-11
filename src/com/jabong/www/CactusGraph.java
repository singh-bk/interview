package com.jabong.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class CactusGraph {
 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer token = new StringTokenizer(str," ");
		int noOfNodes = Integer.parseInt(token.nextToken());
		int noOfEdges = Integer.parseInt(token.nextToken());
		List<CactusGraphNode> nodeList = new LinkedList<CactusGraphNode>();
		Map<Integer, CactusGraphNode> nodeMap = new HashMap<Integer, CactusGraphNode>();
		for(int i=1; i<=noOfNodes;i++){
			CactusGraphNode node = new CactusGraphNode(i);
			nodeList.add(node);
			nodeMap.put(i, node);
		}
		
		for(int i=1;i<=noOfEdges;i++){
			str = br.readLine();
			token = new StringTokenizer(str," ");
			int srcNodeIndex = Integer.parseInt(token.nextToken());
			int destNodeIndex = Integer.parseInt(token.nextToken());
			CactusGraphNode srcNode = nodeMap.get(srcNodeIndex);
			CactusGraphNode destNode = nodeMap.get(destNodeIndex);
			srcNode.addNeighbor(destNode);
			destNode.addNeighbor(srcNode); // Do not add the reverse.
		}
		
		Set<Integer> keySet = nodeMap.keySet();
		for(Integer key: keySet){
			CactusGraphNode node = nodeMap.get(key);
			if(node.getNeighbors() != null && node.getNeighbors().size() >=3){
				node.setCommonVertex(true);
			}
		}
		
		CactusGraphNode headNode = nodeMap.get(1);
		int count = 1;
		
		Queue<CactusGraphNode> queue = new LinkedList<CactusGraphNode>();
		Queue<CactusGraphNode> queue2 = new LinkedList<CactusGraphNode>();
		queue.add(headNode);
		headNode.setVisitied(true);
		while(queue != null && !queue.isEmpty()){
			CactusGraphNode node = queue.remove();
			queue2.add(node);
			List<CactusGraphNode> neighbors = node.getNeighbors();
			if(neighbors == null || neighbors.size() ==0){
				//Do nothing
			}
			else if(neighbors.size() == 1){
				CactusGraphNode  neighborNode = neighbors.get(0);
				if(!neighborNode.isVisitied()){
					neighborNode.setVisitied(true);
					queue.add(neighborNode);
				}
			}else{
				// Do a BFS as well as DFS from both left and right.
				for(CactusGraphNode neighborNode: neighbors){
					if(!neighborNode.isVisitied()){
						neighborNode.setVisitied(true);
						queue.add(neighborNode);
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
	
	
}
