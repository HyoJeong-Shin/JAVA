package ch04.hw.tv;

import ch04.hw.framework.Product;

public class TV_HyoJeongShin extends Product {

    private String modelNo; //신효정: 속성
    
    TV_HyoJeongShin(String modelNo) { //신효정: 모델번호를 속성에 저장
        this.modelNo=modelNo;
    }
    public void use() { //신효정: "모델번호 xxx인 TV를 사용합니다."라는 메시지 출력
        System.out.println("모델번호 " + modelNo+"인 TV를 사용합니다.");
    }
    public String getmodelNo() { //신효정: 자신의 모델 번호 반환
        return modelNo;
    }
}
