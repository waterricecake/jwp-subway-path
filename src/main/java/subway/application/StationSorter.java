package subway.application;

import subway.domain.Section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StationSorter {
    private static List<Section> line;
    private static List<Section> newLine;
    private static Map<String, Section> sectionsMap;
    public static List<Section> sorting(List<Section> sections) {
        sectionsMap = makeHashWith(sections);
        String now = getFirstKey(sectionsMap);
        line = new ArrayList<>();
        newLine = new ArrayList<>();
        while(!sectionsMap.isEmpty()){
            newLine.add(sectionsMap.get(now));
            now = setNow(now);
        }
        line = merge(newLine,line);
        return line;
    }

    private static String setNow(String now) {
        String pre;
        if(sectionsMap.containsKey(now)){
            pre = now;
            now = sectionsMap.get(now).getArrival();
            sectionsMap.remove(pre);
            return now;
        }
        now = getFirstKey(sectionsMap);
        line = merge(newLine,line);
        newLine = new ArrayList<>();
        return now;
    }

    private static String getFirstKey(Map<String, Section> sectionsMap) {
        return (String) sectionsMap.keySet().toArray()[0];
    }

    private static Map<String,Section> makeHashWith(List<Section> sections){
        Map<String,Section> sectionMap = new HashMap<>();
        for(Section section: sections){
            sectionMap.put(section.getDeparture(),section);
        }
        return sectionMap;
    }
    private static List<Section> merge(List<Section> src, List<Section> trg){
        if(trg == null){
            return src;
        }
        for(Section section: trg){
            src.add(section);
        }
        return src;
    }
}
