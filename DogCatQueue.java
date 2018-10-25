package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 假设有这么两个类Dog,Cat,它们都继承了Pet类。
 * 功能是：完成一个队列使得有一下功能：
 * 	用户可以调用add方法将cat类或者dog类的实例放入队列中；
	用户可以调用pollAll方法，将队列中所有的实例按照队列的先后顺序依次弹出；
	用户可以调用pollDog方法，将队列中dog类的实例按照队列的先后顺序依次弹出；
	用户可以调用pollCat方法，将队列中cat类的实例按照队列的先后顺序依次弹出；
	用户可以调用isEmpty方法，检查队列中是否还有dog和cat的实例；
	用户可以调用isDogEmpty方法，检查队列中是否还有do的实例；
	用户可以调用isCatEmpty方法，检查队列中是否还有cat的实例
 * 为了完成以上的功能，我们需要自己创建一个类并在类中使用一个变量纪录下该实例是第几个进入队列的
 * @author Kevin
 *
 */

class Pet{
	private String type;
	
	public Pet(String type) {
		this.type = type;
	}
    public String getPetType(){
        return this.type;
    }
	
}

class Dog extends Pet{

	public Dog() {
		super("dog");
	}	
}

class Cat extends Pet{

	public Cat() {
		super("cat");
	}
	
}
/**
 * 创建这么一个统一的类来表示放入队列的元素类型，其实如果Pet类有count这个成员变量的话，完全可以使用Pet待替。
 * @author Kevin
 *
 */
class PetEnterQueue{
	private Pet pet; // 用来表示进入队列的pet
	private int count; // 用来纪录该实例是第几个进入队列的
	
	public PetEnterQueue(Pet p, int i) {
		this.pet = p;
		this.count = i;
	}
	
	public Pet getPet() {
		return this.pet;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public String getPetType() {
		return this.pet.getPetType();
	}
}

/**
 * 
 * @author Kevin
 *
 */
public class DogCatQueue {
	private Queue<PetEnterQueue> dogQueue; // 用于存放dog类实例的队列
	private Queue<PetEnterQueue> catQueue; // 用于存放cat类实例的队列
	int count = 0; // 用来纪录现在进入队列的元素是第几个
	
	public DogCatQueue() {
		this.dogQueue = new LinkedList<>(); 
		this.catQueue = new LinkedList<>(); 
		this.count = 0;
	}
	
	public void add(Pet p) throws Exception {
		
		if(p.getPetType().equals("cat")) {
			PetEnterQueue cat = new PetEnterQueue(p, this.count++);
			catQueue.add(cat);
		}
		else if(p.getPetType().equals("dog")) {
			PetEnterQueue dog = new PetEnterQueue(p, this.count++);
			dogQueue.add(dog);
		}
		else throw new Exception("not dog or cat");
	}
	
	public Pet pollAll() throws Exception{
		Pet result = null;
		if(!catQueue.isEmpty()&&!dogQueue.isEmpty()) {
			if(catQueue.peek().getCount()<dogQueue.peek().getCount())
				result = catQueue.poll().getPet();
			else
				result = dogQueue.poll().getPet();
		}else if(catQueue.isEmpty()&&!dogQueue.isEmpty()) {
			result = dogQueue.poll().getPet();
		}else if(!catQueue.isEmpty()&&dogQueue.isEmpty()) {
			result = catQueue.poll().getPet();
		}else {
			throw new Exception("queue is empty");
		}
		return result;
	}
	
	public Dog pollDog() throws Exception {
		if(!dogQueue.isEmpty()) 
			return (Dog)dogQueue.poll().getPet();
		else throw new Exception("dogqueue is empty");

	}
	
	public Cat pollCog() throws Exception {
		if(!dogQueue.isEmpty()) 
			return (Cat)catQueue.poll().getPet();
		else throw new Exception("catqueue is empty");

	}
	
	public boolean isEmpty() {
		return (catQueue.isEmpty()&&dogQueue.isEmpty());
	}
	public boolean isDogEmpty() {
		return dogQueue.isEmpty();
	}
	public boolean isCatEmpty() {
		return catQueue.isEmpty();
	}
	
	public static void main(String[] args) throws Exception {
		DogCatQueue test = new DogCatQueue();
		
        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    
	}

}
