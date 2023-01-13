package design.pattern.factoryMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class TestDataFactory <T> {

    public List<T> withAll() {
        List<T> datas = new ArrayList<>();
        datas.add(createData());
        datas.add(createData());
        datas.add(createData());
        return datas;
    }

	public T withOne() {
		return createData();
	}

    public abstract T createData();      
}
