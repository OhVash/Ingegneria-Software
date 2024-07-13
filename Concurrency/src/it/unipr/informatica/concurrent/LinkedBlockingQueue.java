package it.unipr.informatica.concurrent;

public final class LinkedBlockingQueue <T> implements BlockingQueue<T>{
	
	private Node head;
	private Node tail;
	
	private Object mutex;

	public LinkedBlockingQueue(){
		this.head = null;
		this.tail = null;
		this.mutex = new Object();
	}
	

	@Override
	public T take() throws InterruptedException {
		synchronized (mutex) {
			while (head == null) 
				mutex.wait();
			
			@SuppressWarnings("unchecked")
			T result = (T)head.value;
			head = head.next;
			
			if (head == null)
				tail = null;
			else 
				mutex.notify();
			
			return result;
		}
	}

	@Override
	public void put(T object) {
		synchronized (mutex) {
			
			Node node = new Node();
			node.next = null;
			node.value = object;
		
			if (tail == null) 
				head = tail = node;
			else {
				tail.next = node;
				tail = node;
			}
			if (head.next == null);
				mutex.notify();
		}
	}
	
	@Override
	public boolean isEmpty() {
		synchronized (mutex) {
			return head == null;
		}
	}
	
	@Override
	public void clear() {
		synchronized (mutex) {
			head = tail = null;
		}
	}
	
	@Override
	public int remainingCapacity() {
		return Integer.MAX_VALUE;
	}
	@Override
	public void printQueue() {
		synchronized (mutex) {
			Node<T> tmp = new Node<>();
			tmp = head;
				
			System.out.print("[");
			while(tmp != null) {
				System.out.print(tmp.value);
					
				if(tmp.next != null)
					System.out.print(", ");
				
				tmp = tmp.next;
			}
			System.out.println("]");
		}
		
	}
	private static class Node<T> { 
		private T value;
		private Node<T> next;
	};
}
