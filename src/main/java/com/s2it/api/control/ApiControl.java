package com.s2it.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.s2it.api.response.Response;
import com.s2it.api.service.ApiService;
import com.s2it.api.util.BinaryTree;
import com.s2it.api.util.Node;

@RestController
@RequestMapping("/api")
public class ApiControl {

	@Autowired
	private ApiService service;

	@GetMapping()
	public ResponseEntity<Response<Integer>> get(@RequestParam(value = "numberA", required = true) int numberA,
			@RequestParam(value = "numberB", required = true) int numberB) {

		Response<Integer> response = new Response<Integer>();

		Integer newNumber = service.getNewNumber(numberA, numberB);
		response.setData(newNumber);

		return ResponseEntity.ok(response);
	}

	/**
	 * This method receive a node from a binary tree and returns the sum of
	 * subsequence nodes The binary tree is static, see below. 
	 *                6 
	 *           4         8 
	 *         3   5     7   9
	 * 
	 * @param node
	 * @return
	 */
	@GetMapping(path = "binary-tree")
	public ResponseEntity<Response<Integer>> getBinaryTreeNodeSum(
			@RequestParam(value = "node", required = true) int node) {

		Response<Integer> response = new Response<Integer>();

		BinaryTree tree = new BinaryTree();
		tree.addNode(6);
		tree.addNode(4);
		tree.addNode(8);
		tree.addNode(3);
		tree.addNode(5);
		tree.addNode(7);
		tree.addNode(9);

		Node n = tree.findNode(node);

		response.setData(tree.sumBYNode(n) - node);
		return ResponseEntity.ok(response);
	}
}
