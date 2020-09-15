package com.example.mybestpractice.impl;

/**
 * @author :   yuxibing
 * @date :   2020-09-10
 * Describe : 定义一个接口IState，然后让抽象类AbstractState实现该接口，并且实现其中的一个方法a()，这样State类
 * 必须实现b()方法，可以选择性是否实现a()。
 */
public interface IState {
    void a();

    void b();
}
