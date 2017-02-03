package com.android.ddmlib;

import java.net.InetSocketAddress;

public class CalabashAdbHelper {
    public static final int ADB_PORT;
    public static final String ADB_SERVER;

    private static final int DEFAULT_ADB_PORT = 5037;
    private static final String ENV_VAR_ADB_PORT = "ANDROID_ADB_SERVER_PORT";

    private static final String DEFAULT_ADB_SERVER = "127.0.0.1";
    private static final String ENV_VAR_ADB_REMOTE_SERVER = "ANDROID_ADB_REMOTE_SERVER";


    static {
        int port = DEFAULT_ADB_PORT;
        String envPort = System.getenv(ENV_VAR_ADB_PORT);

        if (envPort != null && !"".equals(envPort)) {
            port = Integer.parseInt(envPort);
        }

        String server = DEFAULT_ADB_SERVER;
        String envServer = System.getenv(ENV_VAR_ADB_REMOTE_SERVER);
        if (envServer != null && !"".equals(envServer)) {
            server = envServer;
        }

        ADB_PORT = port;
        ADB_SERVER = server;
    }

    public static RawImage getFrameBuffer(Device device) throws Exception {
        return AdbHelper.getFrameBuffer(new InetSocketAddress(ADB_SERVER, ADB_PORT), device);
    }
}
