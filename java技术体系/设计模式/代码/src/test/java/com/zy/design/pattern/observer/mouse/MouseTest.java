package com.zy.design.pattern.observer.mouse;

import com.zy.design.pattern.observer.core.Event;

import java.lang.reflect.Method;

public class MouseTest {
    public static void main(String[] args) {

        try {
            MouseEventCallback target = new MouseEventCallback();
            Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);

            Mouse mouse = new Mouse();
            mouse.addListenter(MouseEventType.ON_CLICK,target,onClick);

            mouse.click();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
