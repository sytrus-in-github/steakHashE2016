package firstRound;

import java.util.Comparator;

public class Test implements Comparator<Order>{
	
	Warehouse mother;
	
	Test(Warehouse mother){
		this.mother = mother;
	}
	
	@Override
	public int compare(Order o1, Order o2) {
		int w1 = 0;
		for(int type : o1.items.keySet())
			w1+=Q.products[type]*o1.items.get(type);
		int w2 = 0;
		for(int type : o2.items.keySet())
			w2+=Q.products[type]*o2.items.get(type);
		double d1 = Chiaman.dist(o1.x, o1.y, mother.x, mother.y);
		double d2 = Chiaman.dist(o2.x, o2.y, mother.x, mother.y);
		if(w1<w2)
			return -1;
		if(w1>w2)
			return 1;
		return 0;
	}

}
