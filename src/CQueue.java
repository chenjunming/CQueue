package interview_07;
/**
 * 
 * @ClassName: CQueue 
 * @Description: 
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函
 * 数appendTail 和deleteHead,分别完成在队列尾部插入结点和在队列头部删
 * 除结点的功能。
 * @author cjm
 * @date 2017年11月23日 下午4:04:32 
 *
 */

import java.util.Stack;

public class CQueue<T> {
	private Stack<T> stack1 = new Stack();
	private Stack<T> stack2 = new Stack();
	
	public Stack<T> getStack1() {
		return stack1;
	}

	public void setStack1(Stack<T> stack1) {
		this.stack1 = stack1;
	}

	public Stack<T> getStack2() {
		return stack2;
	}

	public void setStack2(Stack<T> stack2) {
		this.stack2 = stack2;
	}
	
	/**
	 * 
	 * @Title: appendTail 
	 * @Description:从队列的尾部插入数据 
	 * @param data   
	 * @return void     
	 * @throws
	 */
	public void appendTail(T data) {
		stack1.add(data);
	}
	
	public T deleteHead() {
		if(!stack2.isEmpty()) {//如果stack2不为空
			return stack2.pop();
		}else if(!stack1.isEmpty()){// 否则将stack1中的数据pop到stack2中
			while(!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
			return deleteHead();
		}else {// 没数据，抛异常
			throw new RuntimeException("该队列中无数据");
		}
	}
	public static void main(String[] args) {
		CQueue<Character> cQueue = new CQueue<>();
		cQueue.appendTail('a');
		cQueue.appendTail('b');
		cQueue.appendTail('c');
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail('d');
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
	}
}
