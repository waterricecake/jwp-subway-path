package subway;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import subway.domain.Line;

import java.util.*;


class SubwayApplicationTests {
	@Mock
	Line line;

	@Test
	void contextLoads() {
		String now = "b";
		Map<String, String> startEnd = new HashMap<>();
		startEnd.put("a","b");
		startEnd.put("c","d");
		startEnd.put("b","c");

		List<String> line = new ArrayList<>();
		List<String> newLine = new ArrayList<>();
		String pre;
		while(!startEnd.isEmpty()){
			newLine.add(now);
			if(startEnd.containsKey(now)){
				pre = now;
				now = startEnd.get(now);
				startEnd.remove(pre);
			}
			else{
				if(startEnd.isEmpty()){
					break;
				}
				now = (String) startEnd.keySet().toArray()[0];
				line = add(newLine,line);
				newLine = new ArrayList<>();
			}
		}
		line = add(newLine,line);
		System.out.println(line);
	}
	List<String> add(List<String> src, List<String> trg){
		if(trg == null){
			return src;
		}
		for(String s: trg){
			src.add(s);
		}
		return src;
	}
}
