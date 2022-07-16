package cn.miaomoe.whitelist.mysql;

import cn.miaomoe.whitelist.Settings;
import cn.miaomoe.whitelist.mysql.SQLCommand;
import cn.miaomoe.whitelist.Whitelist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;

public class MySQLManager {
    Settings.DATABASE dbConfig = Settings.IMP.DATABASE;
    Logger logger;
    private Connection conn;
    public static MySQLManager instance = null;

    public static MySQLManager get() {
        return instance == null ? instance = new MySQLManager() : instance;
    }

    public void enableMySQL()
    {
        connectMySQL();
        String cmd = SQLCommand.SQL_Command.CREATE_TABLE1.commandToString();
        try {
            PreparedStatement ps = conn.prepareStatement(cmd);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connectMySQL()
    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + dbConfig.HOST + ":" + dbConfig.PORT + "/" + dbConfig.DATABASE + dbConfig.CONNECTION_PARAMETERS, dbConfig.USERNAME, dbConfig.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doCommand(PreparedStatement ps)
    {
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("执行指令失败，以下为错误提示");
            e.printStackTrace();
        }
    }

    public void shutdown() {
        try {
            conn.close();
        } catch (SQLException e) {
            //断开连接失败
            e.printStackTrace();
        }
    }

}
