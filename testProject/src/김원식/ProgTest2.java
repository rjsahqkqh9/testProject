package ±è¿ø½Ä;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProgTest2 {
	
	Map<String, MemberData> mapList = new Hashtable<>();
	
	void mapListAdd(String memberID, String name, String tel, String gender){
		mapList.put(memberID, new MemberData(memberID, name, tel, gender));
	}
	
	void mapListRemove(String memberID){
		mapList.remove(memberID);
	}
	
	ArrayList<MemberData> getMapList(){
		ArrayList<MemberData> list = new ArrayList<>();
		
		Set<String> keyset = mapList.keySet();
		Iterator<String> e = keyset.iterator();
		while(e.hasNext()) {
			String key = e.next();
			MemberData value = mapList.get(key);
			list.add(value);
		}
		return list;
	}
	
}
