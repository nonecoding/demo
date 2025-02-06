package com.example.demo.express.region.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 该工具用于生成真实省市区数据的 SQL 脚本插入语句，
 * 数据结构基于 ExpressRegion 实体（level：1=省/直辖市，2=市，3=区）。
 * 
 * 生成的示例数据包括：
 * - 直辖市：北京市、上海市、天津市
 * - 省份：广东省、江苏省、浙江省
 *
 * 注意：各地市下的区级数据仅为示例，一定程度上简化实际行政区划。
 */
public class ExpressRegionRealDataGenerator {

    public static void main(String[] args) {
        String outputFile = "D:\\express_region_real_data.sql";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int id = 1;  // 模拟自增的主键

        // 使用 LinkedHashMap 保持插入顺序。
        // Map结构：省/直辖市名称 -> (城市名称 -> [区/县名称列表])
        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        // 直辖市：北京市
        data.put("北京市", new LinkedHashMap<>());
        data.get("北京市").put("北京市", Arrays.asList("东城区", "西城区", "朝阳区", "丰台区",
                "石景山区", "海淀区", "门头沟区", "房山区", "通州区", "顺义区", "昌平区", "大兴区",
                "怀柔区", "平谷区", "密云区", "延庆区"));

        // 直辖市：上海市
        data.put("上海市", new LinkedHashMap<>());
        data.get("上海市").put("上海市", Arrays.asList("黄浦区", "徐汇区", "长宁区", "静安区",
                "普陀区", "虹口区", "杨浦区", "闵行区", "宝山区", "嘉定区", "浦东新区", "金山区",
                "松江区", "青浦区", "奉贤区", "崇明区"));

        // 直辖市：天津市
        data.put("天津市", new LinkedHashMap<>());
        data.get("天津市").put("天津市", Arrays.asList("和平区", "河东区", "河西区", "南开区",
                "河北区", "红桥区", "塘沽区", "汉沽区", "大港区", "东丽区"));

        // 省份：广东省
        Map<String, List<String>> guangdongCities = new LinkedHashMap<>();
        guangdongCities.put("广州市", Arrays.asList("荔湾区", "越秀区", "海珠区", "天河区",
                "白云区", "黄埔区", "番禺区", "花都区", "南沙区", "萝岗区", "增城区"));
        guangdongCities.put("深圳市", Arrays.asList("罗湖区", "福田区", "南山区", "宝安区",
                "龙岗区", "盐田区", "光明新区", "坪山新区", "大鹏新区", "龙华新区"));
        data.put("广东省", guangdongCities);

        // 省份：江苏省
        Map<String, List<String>> jiangsuCities = new LinkedHashMap<>();
        jiangsuCities.put("南京市", Arrays.asList("玄武区", "秦淮区", "建邺区", "鼓楼区",
                "浦口区", "栖霞区", "雨花台区", "江宁区", "溧水区", "高淳区", "六合区"));
        jiangsuCities.put("苏州市", Arrays.asList("姑苏区", "相城区", "吴中区", "虎丘区",
                "吴江区", "常熟市", "张家港市"));
        data.put("江苏省", jiangsuCities);

        // 省份：浙江省
        Map<String, List<String>> zhejiangCities = new LinkedHashMap<>();
        zhejiangCities.put("杭州市", Arrays.asList("上城区", "下城区", "江干区", "拱墅区",
                "西湖区", "滨江区", "萧山区", "余杭区", "富阳区", "临安区"));
        zhejiangCities.put("宁波市", Arrays.asList("海曙区", "江东区", "江北区", "镇海区",
                "北仑区", "鄞州区"));
        data.put("浙江省", zhejiangCities);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            // 遍历map, 先生成省或直辖市 (level=1)，再生成城市 (level=2)，最后生成区域 (level=3)
            for (Map.Entry<String, Map<String, List<String>>> provinceEntry : data.entrySet()) {
                String provinceName = provinceEntry.getKey();
                LocalDateTime now = LocalDateTime.now();
                String timeStr = now.format(formatter);
                // 插入省/直辖市数据 (level = 1, parent_id = NULL)
                bw.write(String.format(
                        "INSERT INTO express_region (id, name, parent_id, level, create_time, update_time) VALUES (%d, '%s', NULL, 1, '%s', '%s');\n",
                        id, provinceName, timeStr, timeStr));
                int provinceId = id;
                id++;

                // 遍历城市数据
                Map<String, List<String>> cities = provinceEntry.getValue();
                for (Map.Entry<String, List<String>> cityEntry : cities.entrySet()) {
                    String cityName = cityEntry.getKey();
                    now = LocalDateTime.now();
                    timeStr = now.format(formatter);
                    // 插入市级数据 (level = 2, parent_id 指向 provinceId)
                    bw.write(String.format(
                            "INSERT INTO express_region (id, name, parent_id, level, create_time, update_time) VALUES (%d, '%s', %d, 2, '%s', '%s');\n",
                            id, cityName, provinceId, timeStr, timeStr));
                    int cityId = id;
                    id++;

                    // 遍历区/县数据
                    for (String districtName : cityEntry.getValue()) {
                        now = LocalDateTime.now();
                        timeStr = now.format(formatter);
                        // 插入区级数据 (level = 3, parent_id 指向 cityId)
                        bw.write(String.format(
                                "INSERT INTO express_region (id, name, parent_id, level, create_time, update_time) VALUES (%d, '%s', %d, 3, '%s', '%s');\n",
                                id, districtName, cityId, timeStr, timeStr));
                        id++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
