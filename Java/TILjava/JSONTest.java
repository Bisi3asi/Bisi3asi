package JavaPractice;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// JSON 데이터에 넣을 객체
class Player {
    int sales; // 연봉
    String name; // 이름
    String sport; // 종목

    // 생성자 선언
    Player(int sales, String name, String sport) {
        this.sales = sales;
        this.name = name;
        this.sport = sport;
    }
}

public class JSONTest {
    // list에 있는 Player 객체를 JSON 데이터로 저장해 PATH 경로의 파일로 Write 하는 메소드
    public void writeJSON(ArrayList<Player> list, String PATH) throws Exception {
        JSONArray jsonArray = new JSONArray();

        // 1. java 객체를 JSON 데이터로 가공
        try {
            for (Player player : list) {
                JSONObject jsonObject = new JSONObject();
                // 한 개의 객체 필드를 다 집어넣은 뒤 루프마다 초기화
                jsonObject.put("sales", String.valueOf(player.sales));
                jsonObject.put("name", player.name);
                jsonObject.put("sport", player.sport);
                // jsonobject를 통해 객체 단위로 jsonArray에 add
                jsonArray.add(jsonObject);
            }
            // 2. Filewriter를 통해 JSON 데이터를 JSONString으로 캐스팅 후 파일 저장
            FileWriter fw = new FileWriter(PATH);
            fw.write(jsonArray.toJSONString());
            fw.flush();
            // fw.close() : try catch로 close 생략(자동 닫힘)
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    // 경로에 있는 json 파일을 불러와서 파싱 후 java 객체 데이터로 저장하는 메소드
    public void readJson(ArrayList<Player> list, String PATH) throws Exception {
        // 1. JSON 데이터 불러오기 후 데이터 타입 변환
        // 파싱할 Parser 선언
        JSONParser jsonParser = new JSONParser();
        // FileReader(경로) → Parser 통해 파싱 → java Object 객체로 변환
        try {
            Object object = jsonParser.parse(new FileReader(PATH));
            // Object 객체를 JSONArray 객체(배열)로 형변환
            JSONArray jsonArray = (JSONArray) object;

            // JSONArray 배열 내부에서 필드값 가져오기
            if (!jsonArray.isEmpty()) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    // JSONArray 객체를 JSONObject로 형변환하며 배열에서ㅁ 각 객체를 가져옴
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    // JSONObject 객체에 있는 객체의 필드값을 매핑하여 가져옴
                    int sales = Integer.valueOf((String) jsonObject.get("sales"));
                    String name = (String) jsonObject.get("name");
                    String sport = (String) jsonObject.get("sport");
                    // 생성자를 통해 list로 add
                    list.add(new Player(sales, name, sport));
                }
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void main(String[] args) throws Exception {
        // 초기 값 세팅
        ArrayList<Player> list = new ArrayList<>();
        list.add(new Player(1000, "Faker", "Esports"));
        list.add(new Player(2000, "Messi", "Football"));
        list.add(new Player(3000, "Jordan", "Basketball"));
        String PATH = "data.json";

        JSONTest jsonTest = new JSONTest();
        jsonTest.writeJSON(list, PATH); // 파일 저장하기

        ArrayList<Player> list2 = new ArrayList<>();
        jsonTest.readJson(list2, PATH); // 파일 불러오기
        for (Player p : list2) {
            System.out.println("name: " + p.name + " sales: " + p.sales + " sport: " + p.sport);
        }
        /* out :
        name: Faker sales: 1000 sport: Esports
        name: Messi sales: 2000 sport: Football
        name: Jordan sales: 3000 sport: Basketball
        */
    }
}
