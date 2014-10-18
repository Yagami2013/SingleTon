package com.ytt.datastructure;

public class Node<T> {
	public T data;//数�?�域
	public Node<T> next;//地�?�域，�?存�?�继节点
	public Node(){}
	public Node(T data,Node<T> next){
		this.data=data;
		this.next=next;
	}
}
