package subway;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import subway.application.LineService;
import subway.application.StationSorter;
import subway.dao.LineDao;
import subway.domain.Line;
import subway.domain.Section;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class test {
    @LocalServerPort
    int port;
    @MockBean
    private LineDao lineDao;

    @BeforeEach
    void setUp(){
        RestAssured.port = port;
        System.out.println("setUp");
        mockSetup();
    }
    @Test
    void test1(){
        RestAssured.given()
                .when().get("/lines/1")
                .then().log().all();
        lineDao.findById(1l);
        Mockito.verify(lineDao,Mockito.atLeast(1)).findById(1l);
    }

    void mockSetup(){
        Mockito.lenient().when(lineDao.findById(1l)).thenReturn(new Line(1l,"mock","mock"));
    }

    @Test
    void sortingTest(){
        Section section1 = new Section(1l,"a","b",1);
        Section section2 = new Section(1l,"b","c",1);
        Section section3 = new Section(1l,"c","d",1);
        Section section4 = new Section(1l,"d","e",1);
        Section section5 = new Section(1l,"e","f",1);
        Section section6 = new Section(1l,"f","g",1);
        Section section7 = new Section(1l,"g","h",1);
        Section section8 = new Section(1l,"h","i",1);
        Section section9 = new Section(1l,"i","j",1);
        Section section0 = new Section(1l,"j","k",1);
        List<Section> sections = new ArrayList<>();
        sections.add(section0);
        sections.add(section2);
        sections.add(section9);
        sections.add(section6);
        sections.add(section1);
        sections.add(section8);
        sections.add(section5);
        sections.add(section4);
        sections.add(section3);
        sections.add(section7);

        List<Section> sortedSections = StationSorter.sorting(sections);
        for(Section section: sortedSections){
            System.out.println(section.getDeparture()+"->"+section.getArrival());
        }
    }
}
