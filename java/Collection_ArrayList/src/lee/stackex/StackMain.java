package lee.stackex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class StackMain {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		stack.push("최범준");
		stack.push("정준호");
		stack.push("곽다훈");
		stack.push("윤희성");
		
		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println(stack.pop());//마지막에 넣은 사람부터 나옴
		System.out.println(stack.pop());
		System.out.println(stack.peek());//누가 나올 차례인지 보기만 하고 꺼내지 않음
		System.out.println(stack);
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer("1김민성");
		queue.offer("2김준범");
		queue.offer("3송인서");
		queue.offer("4신용호");
		
		System.out.println(queue);
		System.out.println(queue.poll());//꺼내기
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);//[]
	}

}
