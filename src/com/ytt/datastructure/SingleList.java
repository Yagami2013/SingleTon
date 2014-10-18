package com.ytt.datastructure;

import android.util.Log;

public class SingleList<T> implements LinkList<T> {
	protected Node<T> head;
	private String tag="SingleList";
	public SingleList() {
		head=new Node<T>();
	}
	public SingleList(T[] element) {
		this();
		Node<T> rear=this.head;
		for (int i = 0; i < element.length; i++) {
			rear.next=new Node<T>(element[i],null);
			rear=rear.next;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.head.next==null;
	}

	@Override
	public int length() {
		int count=0;
		Node<T> p=this.head.next;
		while (p!=null) {
			count++;
			p=p.next;			
		}
		return count;
	}

	@Override
	public T get(int i) {
		if (i<0||i>this.length()) {
			return null;
		}else {
			Node<T> pNode=this.head;
			for (int j = 0; j <= i; j++) {
				pNode=pNode.next;
			}
			return pNode.data;
		}
		
	}

	@Override
	public void set(int i, T data) {
		if (i<0||i>=this.length()){
			throw new IndexOutOfBoundsException("指定i="+i+"越界");
		}else {
			Node<T> p=this.head;
			for (int j = 0; j <=i; j++) {
				p=p.next;
			}
			p.data=data;
		}
		
	}

	@Override
	//index range from 0 to list.length()
	public void insert(int i, T data) {
		if (data==null) {
			return;
		}
		if (i<0||i>this.length()) {
			throw new IndexOutOfBoundsException("指定i="+i+"越界");
		}
		if (i==0) {
			this.head.next=new Node<T>(data,this.head.next);
		}else {
			Node<T> p=this.head;			
				for (int j = 0; j <i; j++) {
					p=p.next;
				}
				p.next=new Node<T>(data, p.next);
			}
			
		}
	//to be tested

	@Override
	public void append(T data) {
		insert(this.length(), data);
	}

	@Override
	public T remove(int i) {
		if (i<=0||i>this.length()) {
			return null;
		}else {
			Node<T> p=this.head;
			for (int j = 0; j < i-1; j++) {
				p=p.next;
			}
			T data=p.next.data;
			p.next=p.next.next;
			return data;
		}
	}

	@Override
	public void removeAll() {
		this.head=null;		
	}

	@Override
	public int search(T key) {
		if (key==null||this.length()==0) {
			return -1;
		}else {
			int i=0;
			boolean searchFlag=false;
			Node<T> p=this.head;
			while(i<this.length()){
				i++;
				p = p.next;
				if(p.data.equals(key)){
					searchFlag=true;
					break;
				}					
			}
			if (searchFlag) {
				return i;
			}else {
				return -1;
			}			
		}
	}
	public SingleList<T> reverse() {
			Node<T> tmp = new Node<T>();	
			for (int i = 0; i < this.length()/2; i++) {
					tmp.data=this.get(i);
					int index=this.length()-1-i;
					this.set(i, this.get(index));
					this.set(index, tmp.data);
				}			
			return this;
		}
	
	//error
	public void reverse2() {
		if (this.head==null||this.head.next==null) {
			Log.d(tag, "list is empty");
		}else {
			Node<T> front=this.head.next;
			Node<T> back=this.head.next;
			Node<T> p=this.head.next;
			front.next=null;
			int i=0;
			while (p.next!=null) {
				front=back;
				back=p.next;
				p=p.next;
				back.next=front;
				i++;
				Log.d(tag, ""+i);
			}
			this.head.next=back;
			Log.d(tag, "#");
		}
		
	}
	
	//from frankerlihui
	public void reverse3() {
		Node<T> temp = this.head.next;
        Node<T> header = this.head.next;
        Node<T> tail = this.head.next;
        if (this.head == null || this.head.next == null)
        {
            return;
        }
        header = null;
        while (tail != null)
        {
            temp = tail.next;
            tail.next = header;
            header = tail;
            tail = temp;
        }
        this.head.next = header;
	}
	
}