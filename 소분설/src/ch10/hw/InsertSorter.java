package ch10.hw;

public class InsertSorter implements Sorter {
	// 실제 정렬을 수행하는 메소드 
	public void sort(Comparable[] data) {
		for (int i = 0; i < data.length - 1; i++) { // i=0부터 시작
			for (int j = i + 1; j < data.length; j++) { // 항상 j=i+1부터 시작
				if (data[j].compareTo(data[i]) > 0) { // data[i] 가 data[j] 보다 크면
					// 서로 교환한다.
					Comparable passingplace = data[i];
					data[i] = data[j];
					data[j] = passingplace;
				}
			}
		}
	}
}
