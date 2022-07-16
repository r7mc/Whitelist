package cn.miaomoe.whitelist;

import cn.miaomoe.whitelist.util.YamlConfig;

public class Settings extends YamlConfig {
    @Ignore
    public static final Settings IMP = new Settings();

    @Final
    @Comment("插件前缀")
    public String PREFIX = "Whitelist &6>>&f";
    @Comment("是否启用白名单")
    public boolean ENABLE = false;
    @Comment("未在白名单时踢出提示信息")
    public String MESSAGE = "&c您未在该服务器白名单内！";

    @Create
    public DATABASE DATABASE;
    @Comment("数据库设置")
    public static class DATABASE {
        @Comment("MySQL 地址")
        public String HOST = "127.0.0.1";
        @Comment("MySQL 端口")
        public int PORT = 3306;
        @Comment("MySQL 用户名")
        public String USERNAME = "root";
        @Comment("MySQL 密码")
        public String PASSWORD = "root";
        @Comment("MySQL 数据库名")
        public String DATABASE = "mc";
        @Comment("MySQL 附加参数")
        public String CONNECTION_PARAMETERS = "?useSSL=false";

    }

}
