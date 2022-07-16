package cn.miaomoe.whitelist.mysql;

import java.sql.*;

public class SQLCommand {

    public enum SQL_Command {
        CREATE_TABLE1(
                "CREATE TABLE IF NOT EXISTS `whitelist` (" +
                        "`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '玩家ID'," +
                        "`uuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '玩家UUID," +
                        "`qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '玩家QQ'," +
                        "PRIMARY KEY (`id`) USING BTREE" +
                        ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;"
        ),;

        private String command;

        SQL_Command(String command)
        {
            this.command = command;
        }
        public String commandToString()
        {
            return command;
        }
    }
}
