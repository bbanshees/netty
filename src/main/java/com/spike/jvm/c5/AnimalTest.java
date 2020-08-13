package com.spike.jvm.c5;

/**
 * @description:
 * @author: Spike
 * @date: 2020-07-10 17:15
 **/

public class AnimalTest {

    public void showAnimal(Animal animal){
        animal.eat(); // 表现为晚期绑定
    }
    public void showHunt(Hunt hunt){
        hunt.hunt(); // 表现为晚期绑定
    }
}

class Animal{
    public void eat(){
        System.out.println("eat");
    }

}
class Cat extends Animal implements Hunt{

    public Cat(){
        super(); //早期绑定
    }
    public Cat(String name){
        this(); // 早期绑定
    }


    @Override
    public void hunt() {
        super.eat();
        System.out.println("yes");
    }

    @Override
    public void eat() {
        System.out.println("eat fish");
    }
}
class Dog extends Animal implements Hunt{

    @Override
    public void hunt() {
        System.out.println("no");
    }

    @Override
    public void eat() {
        System.out.println("eat meat");
    }
}
interface Hunt{

    void hunt();

}
