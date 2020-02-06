package step2;

public class OverMain {

    public static void main(String[] args) {
        First first = new First();
        Second second = new Second();
        first.someMethod();
        second.someMethod();

        //Override
        first.blabMethod();
        second.blabMethod();


        //OverLoading
        OverLoading overLoading = new OverLoading();
        overLoading.loading();
        overLoading.loading("a", "b");
        overLoading.loading("a", "b","c");
    }
}
