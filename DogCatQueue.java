package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ��������ô������Dog,Cat,���Ƕ��̳���Pet�ࡣ
 * �����ǣ����һ������ʹ����һ�¹��ܣ�
 * 	�û����Ե���add������cat�����dog���ʵ����������У�
	�û����Ե���pollAll�����������������е�ʵ�����ն��е��Ⱥ�˳�����ε�����
	�û����Ե���pollDog��������������dog���ʵ�����ն��е��Ⱥ�˳�����ε�����
	�û����Ե���pollCat��������������cat���ʵ�����ն��е��Ⱥ�˳�����ε�����
	�û����Ե���isEmpty���������������Ƿ���dog��cat��ʵ����
	�û����Ե���isDogEmpty���������������Ƿ���do��ʵ����
	�û����Ե���isCatEmpty���������������Ƿ���cat��ʵ��
 * Ϊ��������ϵĹ��ܣ�������Ҫ�Լ�����һ���ಢ������ʹ��һ��������¼�¸�ʵ���ǵڼ���������е�
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
 * ������ôһ��ͳһ��������ʾ������е�Ԫ�����ͣ���ʵ���Pet����count�����Ա�����Ļ�����ȫ����ʹ��Pet���档
 * @author Kevin
 *
 */
class PetEnterQueue{
	private Pet pet; // ������ʾ������е�pet
	private int count; // ������¼��ʵ���ǵڼ���������е�
	
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
	private Queue<PetEnterQueue> dogQueue; // ���ڴ��dog��ʵ���Ķ���
	private Queue<PetEnterQueue> catQueue; // ���ڴ��cat��ʵ���Ķ���
	int count = 0; // ������¼���ڽ�����е�Ԫ���ǵڼ���
	
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
