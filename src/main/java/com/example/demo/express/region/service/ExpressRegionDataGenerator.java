package com.example.demo.express.region.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 该工具用于生成 1000 条 ExpressRegion 数据的 SQL 插入语句。
 *
 * 方案说明：
 * - 10 个省（level=1，parentId 为 NULL）
 * - 每个省 9 个市（level=2，parentId 指向省）
 * - 每个市 10 个区（level=3，parentId 指向市）
 *
 * 生成后产生的 SQL 脚本（express_region_inserts.sql）可直接用于写入数据库表。
 */
public class ExpressRegionDataGenerator {

    public static void main(String[] args) {
        // 输出 SQL 脚本文件路径，可根据需要调整路径
        String outputFile = "express_region_inserts.sql";
        // 时间格式化，用于生成 create_time 和 update_time 字段的值
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 用于模拟自增主键的初始值
        int id = 1;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            // 生成 10 个省
            for (int i = 1; i <= 10; i++) {
                LocalDateTime now = LocalDateTime.now();
                String timeStr = now.format(formatter);
                String provinceName = "Province_" + i;
                // 省的 parentId 为 NULL，level 为 1
                bw.write(String.format("INSERT INTO express_region (id, name, parent_id, level, create_time, update_time) VALUES (%d, '%s', NULL, %d, '%s', '%s');\n", 
                        id, provinceName, 1, timeStr, timeStr));
                int provinceId = id;
                id++;  // 自增
                // 每个省生成 9 个市
                for (int j = 1; j <= 9; j++) {
                    now = LocalDateTime.now();
                    timeStr = now.format(formatter);
                    String cityName = "City_" + i + "_" + j;
                    // 市的 parentId 指向所属省，level 为 2
                    bw.write(String.format("INSERT INTO express_region (id, name, parent_id, level, create_time, update_time) VALUES (%d, '%s', %d, %d, '%s', '%s');\n", 
                            id, cityName, provinceId, 2, timeStr, timeStr));
                    int cityId = id;
                    id++;
                    // 每个市生成 10 个区
                    for (int k = 1; k <= 10; k++) {
                        now = LocalDateTime.now();
                        timeStr = now.format(formatter);
                        String districtName = "District_" + i + "_" + j + "_" + k;
                        // 区的 parentId 指向所属市，level 为 3
                        bw.write(String.format("INSERT INTO express_region (id, name, parent_id, level, create_time, update_time) VALUES (%d, '%s', %d, %d, '%s', '%s');\n", 
                                id, districtName, cityId, 3, timeStr, timeStr));
                        id++;
                    }
                }
            }
            System.out.println("SQL 脚本生成成功，共插入 " + (id - 1) + " 条记录，文件路径：" + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
