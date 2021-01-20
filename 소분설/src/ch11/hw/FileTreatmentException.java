package ch11.hw;

///public class FileTreatmentException extends Exception{ ///예외클래스 나타낼 때는 Exception을 상속받는 방법과 RuntimeException을 상속 받는 두 가지 방법이 있음
public class FileTreatmentException extends RuntimeException {  ///예외를 나타내는 클래스로 RuntimeException을 상속받음
    public FileTreatmentException() {
    }
    public FileTreatmentException(String msg) {
        super(msg);
    }
}
