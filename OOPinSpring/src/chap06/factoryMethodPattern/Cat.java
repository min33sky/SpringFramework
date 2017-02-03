package chap06.factoryMethodPattern;

public class Cat extends Animal{
	@Override
	AnimalToy getToy() {
		return new CatToy();
	}
}
