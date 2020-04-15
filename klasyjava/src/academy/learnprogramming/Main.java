package academy.learnprogramming;

// basic interface #1
interface humanThings {

    void speak();
    void walk();
    void eat();
    void sleep();
    ////////////
    void getAge();
    void getHeight();
    void getSalary();
    void getName();
    ////////////
    void setAge(int a);
    void setHeight(int h);
    void setSalary(int s);
    void setName(String n);
}

// advanced interface #2
interface advancedHuman {

    void work();
    void cry();
    void run();
}

// abstract class - one base class that all the others can derive from without multiplying the code
abstract class human implements humanThings {

    // encapsulation - only this class and the classes that derive from this class can get an access
    protected int age;
    protected int height;
    protected int salary;
    protected String name;

    // constructor
    public human ( String n , int a , int h , int s) {
        name = n;
        age = a;
        height = h;
        salary = s;
        System.out.println("human constructor called");
    }

    // setters
    @Override
    public void setAge(int a) {
        age = a;
        System.out.println("Age has been set succesfully and is now: " + age );
    }

    @Override
    public void setHeight(int h) {
        height = h;
        System.out.println("Height has been set succesfully and is now: " + height );
    }

    @Override
    public void setSalary(int s) {
        salary = s;
        System.out.println("Salary has been set succesfully and is now: " + salary );
    }

    // getters
    @Override
    public void setName(String n) {
        name = n;
        System.out.println("Name has been set succesfully and is now: " + name );
    }

    @Override
    public void getAge() {
        System.out.println("Age: " + age );
    }

    @Override
    public void getHeight() {
        System.out.println("Height: " + height );
    }

    @Override
    public void getSalary() {
        System.out.println("Salary: " + salary );
    }

    @Override
    public void getName() {
        System.out.println("Name: " + name );
    }
}

// inheritance- child class can perform methods/access ~protected~ variables of parent class
class teacher extends human {

    // constructor
    public teacher(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("teacher-human constructor called");
    }

    // implemented methods
    @Override
    public void speak() {
        System.out.println(name + " speaking to students");
    }

    @Override
    public void walk() {
        System.out.println(name + " walking around class");
    }

    @Override
    public void eat() {
        System.out.println(name + " eating");
    }

    @Override
    public void sleep() {
        System.out.println(name + " sleeping");
    }

    // class methods
    public void giveARaise (int x) {
        salary += x;
        System.out.println(name + "got a raise, salary now: " + salary );
    }

    public void makeATest () {
        System.out.println(name + " making a test");
    }

    public void gotFired () {
        System.out.println(name + " got fired");
    }

}

/// polymorphism coach/mathTeacher - two similar classes based on the same two classes
class coach extends teacher implements advancedHuman {  // inheritance

    // constructor
    public coach(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("coach-teacher-human constructor called");
    }

    // implemented methods
    @Override
    public void work() {
        System.out.println(name + "'s PE lesson");
    }

    @Override
    public void cry() {
        System.out.println(name + " crying");
    }

    @Override
    public void run() {
        System.out.println(name + " running very fast");
    }

    // class method
    public void relax () {
        System.out.println(name + " relaxing");
    }
}

class mathTeacher extends teacher implements advancedHuman {  // inheritance

    // constructor
    public mathTeacher(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("mathTeacher-teacher-human constructor called");
    }

    // interface-implemented methods
    @Override
    public void work() {
        System.out.println(name + " making students sad");
    }

    @Override
    public void cry() {
        System.out.println(name + " making students cry");
    }

    @Override
    public void run() {
        System.out.println(name + " trying to run");
    }

    // overridden parent class method
    @Override
    public void makeATest() {
        System.out.println(name + " making a test");
    }
}

class officeEmployee extends human {  // inheritance

    // constructor
    public officeEmployee(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("officeEmployee-human constructor called");
    }

    // implemented methods
    @Override
    public void speak() {
        System.out.println(name + " is speaking");
    }

    @Override
    public void walk() {
        System.out.println(name + " is walking");
    }

    @Override
    public void eat() {
        System.out.println(name + " is on his lunch break");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    // class method
    public void giveARaise (int x , officeEmployee y ) {
        y = this;
        salary += x;
        System.out.println(name + " got a raise, salary now: " + salary );
    }
}

/// polymorphism intern/regular/boss - three similar classes based on the same two classes
class intern extends officeEmployee implements advancedHuman {  // inheritance

    // constructor
    public intern(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("intern-officeEmployee-human constructor called");
    }

    // implemented methods
    @Override
    public void work() {
        System.out.println("Intern trying his best to work well");
    }

    @Override
    public void cry() {
        System.out.println("No one helped intern and he is crying now");
    }

    @Override
    public void run() {
        System.out.println("Intern running");
    }

    // class method
    public void askForHelp() {
        System.out.println("Intern asking for help");
    }
}

class regularWorker extends officeEmployee implements advancedHuman {  // inheritance

    // constructor
    public regularWorker(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("regularWorker-officeEmployee-human constructor called");
    }

    // implemented methods
    @Override
    public void work() {
        System.out.println("Office worker doing some work");
    }

    @Override
    public void cry() {
        System.out.println("Office worker crying");
    }

    @Override
    public void run() {
        System.out.println("Office worker running");
    }

    //class method
    public void askForARaise() {
        System.out.println("Office worker asking for more money");
    }
}

class boss extends officeEmployee implements advancedHuman {  // inheritance

    // contructor
    public boss(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("boss-officeEmployee-human constructor called");
    }

    // implemented methods
    @Override
    public void work() {
        System.out.println("Boss is insulting other employees");
    }

    @Override
    public void cry() {
        System.out.println("Boss is pretending to cry");
    }

    @Override
    public void run() {
        System.out.println("Boss is running out of the office");
    }

    //class method
    @Override
    public void giveARaise(int x , officeEmployee y ) {
        y.salary += x;
        System.out.println( y.name + " got a " + x + " raise");
    }
}

class artist extends human {  // inheritance

    // constructor
    public artist(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("artist-human constructor called");
    }

    // implemented methods
    @Override
    public void speak() {
        System.out.println(name + " the Artist speaking");
    }

    @Override
    public void walk() {
        System.out.println(name + " the Artist walking");
    }

    @Override
    public void eat() {
        System.out.println(name + " got to eat today!");
    }

    @Override
    public void sleep() {
        System.out.println(name + " the Artist sleeping");
    }

    // class method
    public void sketch() {
        System.out.println(name + " sketching");
    }
}

/// polymorphism painter/sculpturer - two similar classes based on the same two classes
class painter extends artist implements advancedHuman {  // inheritance

    // constructor
    public painter(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("painter-artist-human constructor called");
    }

    //class methods
    public void painting() {
        System.out.println("Painter made a beautiful painting");
    }

    public void inspire() {
        System.out.println("Painter inspires everybody around");
    }

    // implemented methods
    @Override
    public void work() {
        System.out.println("Painter working on a painting");
    }

    @Override
    public void cry() {
        System.out.println("Painter expressing emotions");
    }

    @Override
    public void run() {
        System.out.println("Painter expressing will to run");
    }
}

class sculpturer extends artist implements advancedHuman {  // inheritance

    // constructor
    public sculpturer(String n, int a, int h, int s) {
        super(n, a, h, s);
        System.out.println("Sculpturer-artist-human constructor called");
    }

    // class methods
    public void sculpt() {
        System.out.println("sculpt sculpt");
    }

    public void think() {
        System.out.println("Sculpturer thinks deeply");
    }

    // implemented methods
    @Override
    public void work() {
        System.out.println("Sculpturer doing some sculpting");
    }

    @Override
    public void cry() {
        System.out.println("Sculpturer expressing emotions");
    }

    @Override
    public void run() {
        System.out.println("Sculpturer expressing will to run");
    }
}

public class Main {

    public static void main(String[] args) {

        boss Steve = new boss ("Steve" , 37 , 175 , 12000 );
        Steve.getName();
        Steve.getAge();
        Steve.getSalary();
        Steve.getHeight();
        Steve.setAge(25);
        Steve.setHeight(190);
        Steve.setSalary(20000);
        Steve.setName("Steven");
        Steve.getName();
        Steve.getAge();
        Steve.getSalary();
        Steve.getHeight();
        Steve.eat();
        Steve.sleep();
        Steve.walk();
        Steve.cry();
        Steve.run();
        Steve.work();

        System.out.println("\n");

        regularWorker Pam = new regularWorker("Pam", 28 , 170 , 7000);
        Pam.getSalary();
        Steve.giveARaise(2000 , Pam);
        Pam.getSalary();

        System.out.println("\n");

        sculpturer Belmondo = new sculpturer ("Belmondo" , 59 , 184 , 2000);
        Belmondo.sculpt();
        Belmondo.think();
        Belmondo.cry();

        System.out.println("\n");

        coach Beast = new coach ("Beast", 41 , 195 , 4000);
        Beast.relax();
        Beast.run();
        Beast.eat();
        Beast.gotFired();

    }

}
