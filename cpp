#include <iostream>
using namespace std;

/// class human is an abstract class that every other class derives from
/// it has 2 virtual methods that even though are common for all classes
/// can be alternated a bit- abstract/base classes prevent from repeating code too much

class human {

    protected:
    /// encapsulation - protected - only this class and classes based on this have access
    int age = 0;
    int height = 0;
    int salary = 0;
    string name = "";


    public:

    human()  { cout << "human's constructor called" << endl; }

    void create ( string n, int a, int h, int s ) {
    name = n;
    age = a;
    height = h;
    salary = s;
    cout << n << " created successfully" << endl;
    }

    void speak () {
    cout << "hey I'm speaking" << endl;
    }

    virtual void walk () = 0;  /// interface

    virtual void eat () = 0;   /// interface


    /// setters
    void setAge ( int a ) {
    age = a;
    cout << "age has been set successfully" << endl;
    }

    void setHeight ( int h ) {
    height = h;
    cout << "height has been set successfully" << endl;
    }

    void setSalary ( int s ) {
    salary = s;
    cout << "salary has been set successfully" << endl;
    }
    /// ////////////////////////////////////////////


    /// getters
    void getAge () {
    cout << "age: " << age << endl;
    }

    void getHeight () {
    cout << "height: " << height << endl;
    }

    void getSalary () {
    cout << "salary: " << salary << endl;
    }
    /// ///////////////////////////////////////////////
};

class teacher: public human {  /// inherits human - gets all human methods without doubling the code

    protected:
    /// encapsulation - protected - only this class and classes based on this have access
    string field = "teacher";

    public:

    teacher()  { cout << "teacher's constructor called" << endl; }

    virtual void walk () {
    cout << "look at me I'm walking" << endl;
    }

    void eat () {
    cout << "yumm!" << endl;
    }

    virtual void makeTest () {
    cout << "ok class, we are about to take the test" << endl;
    }

    virtual void scream () {
    cout << "AAAAAA" << endl;
    }

    virtual void encourage () {
    cout << "you can do this" << endl;
    }

    virtual void getField () {
    cout << "field of expertise: " << field << endl;
    }

    void setField ( string f ) {
    field = f;
    cout << "field of expertise set successfully" << endl;
    }

};

/// polymorphism coach/mathTeacher - two similar classes based on the same two classes

class coach: public teacher {  /// inherits teacher

    public:

    coach()  {
         cout << "coach's constructor called" << endl;
         setField("coach");
     }

    void eat () {
    cout << "I love that high protein shake" << endl;
    }

    void walk () {
    cout << "I'm walking so fast" << endl;
    }

    void makeTest() {
    cout << "today I will be grading your running skills" << endl;
    }

};

class mathTeacher: public teacher {  /// inherits teacher

    public:

    mathTeacher()  {
        cout << "mathTeacher's constructor called" << endl;
        setField("math teacher");
    }

    void encourage () {
    cout << "you can't do this" << endl;
    }

};

class officeEmployee: public human {  /// inherits human - gets all human methods without doubling the code

    protected:
    /// encapsulation - protected - only this class and classes based on this have access
    int multisportCard = 0;

    public:

    officeEmployee()  { cout << "officeEmployee's constructor called" << endl; }

    void walk () {
    cout << "look at me I'm walking" << endl;
    }

    void eat () {
    cout << "I love my lunch!" << endl;
    }

    void cry () {
    cout << "sad noises" << endl;
    }

    virtual void work () {
    cout << "working" << endl;
    }

    void addCard () {
    multisportCard++;
    }

    void checkCard () {
        if ( multisportCard > 0 ) {

        } else {
        cout << name << "owns a card" << endl;
        }
    }

};

/// polymorphism intern/regular/boss - three similar classes based on the same two classes

class intern: public officeEmployee {  /// inherits officeEmployee

    public:

    intern()  { cout << "intern's constructor called" << endl; }

    void work() {
    cout << "trying to work" << endl;
    }

    void askForHelp () {
    cout << "intern asking for help" << endl;
    }

};

class regular: public officeEmployee {  /// inherits officeEmployee

    public:

    regular()  { cout << "ragular's constructor called" << endl; }

    addCard();

    void askForARaise () {
    cout << "give me more money" << endl;
    }

};

class boss: public officeEmployee {  /// inherits officeEmployee

    public:

    boss()  { cout << "boss's constructor called" << endl; }

    addCard();

    void work () {
    cout << "threatening other employees" << endl;
    }

};

class artist: public human {  /// inherits human - gets all human methods without doubling the code

    protected:
    /// encapsulation - protected - only this class and classes based on this have access
    int outstandingIdeas = 0;

    public:

    artist()  { cout << "artist's constructor called" << endl; }

    void walk () {
    cout << "look at me I'm walking" << endl;
    }

    void eat () {
    cout << "very yummy!" << endl;
    }

    void survive () {
    cout << "I found food~!" << endl;
    }

    void sketch () {
    cout << "making a sketch" << endl;
    }

    /// setter
    void think ( int x ) {
    outstandingIdeas += x;
    cout << "I have " << outstandingIdeas << " idea/s now" << endl;
    }

    /// getter
    void getIdeas () {
    cout << "I have " << outstandingIdeas << " idea/s" << endl;
    }

};

/// polymorphism painter/sculpturer - two similar classes based on the same two classes

class painter: public artist {  /// inherits artist
    public:

    painter()  { cout << "painter's constructor called" << endl; }

    void makeAPainting () {
    cout << "I am making such a beautiful painting" << endl;
    }

};



class sculpturer: public artist {  /// inherits artist

    public:

    sculpturer()  { cout << "sculpturer's constructor called" << endl; }

    void makeASculpture () {
    cout << "sculpt sculpt" << endl;
    }

};

int main () {


    painter John;
    John.setAge(29);
    John.setHeight(174);
    John.setSalary(4000);
    John.makeAPainting();
    John.think(1);

    cout <<  endl << "*************************************" << endl << endl;

    boss Abigail;
    officeEmployee &h = Abigail;
    cout << "using pointer from parent class to use non-virtual child method:" << endl;
    h.work();
    Abigail.create ( "Abigail" , 34 , 180 , 17000 );

    cout <<  endl << "*************************************" << endl << endl;

    intern Darren;
    Darren.create ( "Darren" , 28 , 175 , 40000 );
    human &p = Darren;
    Darren.eat();
    Darren.speak();
    p.walk();

    cout <<  endl << "*************************************" << endl << endl;

    coach Michael;
    Michael.create ( "Michael" , 23 , 190 , 3000 );
    Michael.walk();
    coach &c = Michael;
    c.makeTest();
    Michael.getField();

    cout <<  endl << "*************************************" << endl << endl;

    mathTeacher Karen;
    Karen.create ( "Karen" , 46 , 168 , 2500 );
    Karen.setSalary(2750);
    Karen.getAge();
    Karen.encourage();
    Karen.scream();
    Karen.getField();


return 0;
}
