package ch13.wildcard;

public class WildCardExample {

  public static void registerCourse(Course<?> course) {
  }

  public static void registerCourseStudent(Course<? extends Student> course) {
    //? extends Students
    // Students를 확장하는 클래스만 올 수 있음.
    // 즉 Students 자체와, 이를 상속받은 HighStudents만
  }

  public static void registerCourseWorker(Course<? super Student> course) {
    //? super Worker
    // Student 가 제일 하위 클래스
    // 즉 Student를 상속받았거나(High student) 전혀 상관없는 Worker 객체는 받을 수 없음.
  }


  public static void main(String[] args) {
    registerCourse(new Course<Person>("일반인 과정", 5));
    registerCourse(new Course<Worker>("근로자 과정", 5));
    registerCourse(new Course<Student>("학생 과정", 5));
    registerCourse(new Course<HighStudent>("고등학생 과정", 5));

//    registerCourseStudent(new Course<Person>("일반인 과정",5)); 오류
//    registerCourseStudent(new Course<Worker>("근로자 과정",5)); 오류
    registerCourseStudent(new Course<Student>("학생 과정", 5));
    registerCourseStudent(new Course<HighStudent>("고등학생 과정", 5));

    registerCourseWorker(new Course<Person>("일반인 과정", 5));
    //registerCourseWorker(new Course<Worker>("근로자 과정",5)); 오류
    registerCourseWorker(new Course<Student>("학생 과정", 5));
    //registerCourseWorker(new Course<HighStudent>("고등학생 과정",5)); 오류

  }

}
