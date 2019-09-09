public class Cat extends Animal {//пример наследования - класс Cat наследник класса Animal
   
    @Override
   public void getVoice(){ //пример полиморфизма - использование объектов с одинаковым 
                           //интерфейсом без информации о конкретном типе этого объекта.
   System.out.println("Meaou");}
   
    private void catsOwnMethod(){ //пример инкапсуляции - сокрытие реализации
                            //и предоставление доступа к коду не напрямую, а через определенные методы.
        System.out.println("I'm catching mouse");
    }
   
    public static void main(String[] args){
        Cat cat = new Cat();
        cat.countOfLegs = 4;
        cat.name = "Cat";
        cat.introduction();
        cat.getVoice();
        cat.catsOwnMethod();
        cat.someMethodFromParent();
    }
}