package cn.miaomoe.whitelist;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import cn.miaomoe.whitelist.util.Metrics;
import lombok.Getter;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.slf4j.Logger;
import java.io.File;
import java.nio.file.Path;
import cn.miaomoe.whitelist.mysql.MySQLManager;

@Plugin(
        id = "whitelist",
        name = "whitelist",
        version = "1.0-SNAPSHOT",
        description = "Velocity 支持MySQL的白名单",
        url = "https://blog.miaomoe.cn",
        authors = {"MiaoNuo"}
)
public class Whitelist {
    @MonotonicNonNull
    private final ProxyServer server;
    private final File configFile;
    @Getter private final Logger logger;

    private final Metrics.Factory metricsFactory;


    @Inject
    public Whitelist(Logger logger, ProxyServer server, Metrics.Factory metricsFactory, @DataDirectory Path dataDirectory) {
        this.server = server;
        this.logger = logger;
        this.metricsFactory = metricsFactory;
        this.configFile = new File(dataDirectory.toFile(), "config.yml");
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) throws Exception {
        Metrics metrics = this.metricsFactory.make(this, 15792);
        this.reload();
        MySQLManager.get().enableMySQL();
    }
    @SuppressFBWarnings(value = "NP_NULL_ON_SOME_PATH", justification = "LEGACY_AMPERSAND can't be null in velocity.")
    public void reload() throws Exception {
        Settings.IMP.reload(this.configFile, Settings.IMP.PREFIX);


    }
}
