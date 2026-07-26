public class InheritanceExample {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal();
        Dog dog = new Dog();
        genericAnimal.makeSound();
        dog.makeSound();
    }
}

class Animal {
    void makeSound() {
        System.out.println("Generic animal sound.");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}