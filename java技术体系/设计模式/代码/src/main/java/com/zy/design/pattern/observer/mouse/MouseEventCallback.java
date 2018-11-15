package com.zy.design.pattern.observer.mouse;


import com.zy.design.pattern.observer.core.Event;

/**
 * 观察者（observer）
 * 回调响应的逻辑，由自己实现
 */
public class MouseEventCallback {
    public void onClick(Event e){
        System.out.println("====触发鼠标单击事件====\n"+e);
    }
    public void doDoubleClick(Event e){
        System.out.println("====触发鼠标双击事件====\n"+e);
    }
    public void doUp(Event e){
        System.out.println("====触发鼠标弹起事件====\n"+e);
    }
    public void doDown(Event e){
        System.out.println("====触发鼠标按下事件====\n"+e);
    }
    public void doWheel(Event e){
        System.out.println("====触发鼠标滚动事件====\n"+e);
    }
    public void doMove(Event e){
        System.out.println("====触发鼠标移动事件====\n"+e);
    }
    public void doOver(Event e){
        System.out.println("====触发鼠标悬停事件====\n"+e);
    }
}
