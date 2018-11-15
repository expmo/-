package com.zy.design.pattern.observer.mouse;

import com.zy.design.pattern.observer.core.EventListener;

/**
 * 被观察者
 */
public class Mouse extends EventListener {
    public void click(){
        System.out.println("鼠标单击了");
        this.trigger(MouseEventType.ON_CLICK);
    }
    public void doubleClick(){
        System.out.println("鼠标双击了");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }
    public void up(){
        System.out.println("鼠标弹起了");
        this.trigger(MouseEventType.ON_UP);
    }
    public void down(){
        System.out.println("鼠标按下了");
        this.trigger(MouseEventType.ON_DOWN);
    }
    public void wheel(){
        System.out.println("鼠标滚动了");
        this.trigger(MouseEventType.ON_WHEEL);
    }
    public void move(){
        System.out.println("鼠标移动了");
        this.trigger(MouseEventType.ON_MOVE);
    }
    public void over(){
        System.out.println("鼠标悬停了");
        this.trigger(MouseEventType.ON_OVER);
    }
}
