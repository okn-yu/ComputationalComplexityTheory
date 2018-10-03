package com.company.component;

import lombok.Getter;
import lombok.Setter;

/*
状態qは以下の場合がある:
 整数:1, 2, 3...
 文字:"a", "b", "c"...
 文字列:"abc", "de", "fghi"...
 集合:{a}, {}, {a, b}

 いやオートマトンを考えた場合は状態はお互いに識別できればよいので、特に指定はないのか！
 */


public class State<T> {

    @Getter
    private T value;

    public void setValue(T val){
        value =  val;
    }

//
//    public T getQ(){
//        return value;
//    }

    public State(){

    }
}
