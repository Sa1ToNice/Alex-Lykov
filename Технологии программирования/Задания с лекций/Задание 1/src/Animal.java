public class Animal {
    
    public String name;
    public int countOfLegs;
    public String voice;
    public void introduction(){
        System.out.println("Hello I'm " + name + " I have " + countOfLegs + " legs");
    }
   
    public void getVoice(){}
   
    public void someMethodFromParent(){
        System.out.println("I love people");
    }
 

}
