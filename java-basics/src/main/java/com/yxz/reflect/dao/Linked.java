package com.yxz.reflect.dao;

public class Linked <T>{
	
	private class Node {
		private T t;
		private Node next;

		public Node(T t, Node next) {
			this.t = t;
			this.next = next;
		}

		public Node(T t) {
			this(t, null);
		}
	}
	//头结点
	private Node head;
	//链表元素个数
	private int size;
	//构造函数
	public Linked(){
		this.head = null;
		this.size = 0;
	}
}
