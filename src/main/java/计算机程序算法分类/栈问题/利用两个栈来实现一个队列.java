package 计算机程序算法分类.栈问题;

import java.util.Stack;

/**
 * @Classname 利用两个栈来实现一个队列
 * @Description TODO
 * @Date 2021/5/19 14:42
 * @Created by xjl
 */
public class 利用两个栈来实现一个队列 {

    /**
     * @description TODO 利用的是的来哥哥栈来实现一个队列  主要是的栈是先进后出 而不同的是队列是的先进先出的一种操作的方式
     * @param: null
     * @date: 2021/5/19 14:44
     * @return:
     * @author: xjl
    */
    class Stack_to_queue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;
        public Stack_to_queue(){
            stackPop=new Stack<>();
            stackPush=new Stack<>();
        }

        public void append(int value){
            stackPush.add(value);
        }

        public int Pop(){
            //保证弹出的为空
            if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.add(stackPush.pop());
                }
            }
            return stackPop.isEmpty()?-1:stackPop.pop();
        }
    }
}
