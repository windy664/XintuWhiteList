package org.windy.xintuWhiteList.api;

import org.windy.xintuWhiteList.XintuWhiteList;

import java.util.Optional;

public class WhiteListAPI {

    /**
     * 根据玩家名获取QQ号
     */
    public static Optional<String> getQQByPlayer(String playerName) {
        return XintuWhiteList.getInstance().getWhiteListEntries().stream()
                .filter(entry -> entry.player.equalsIgnoreCase(playerName))
                .map(entry -> entry.qq)
                .findFirst();
    }

    /**
     * 根据QQ号获取玩家名
     */
    public static Optional<String> getPlayerByQQ(String qq) {
        return XintuWhiteList.getInstance().getWhiteListEntries().stream()
                .filter(entry -> entry.qq.equals(qq))
                .map(entry -> entry.player)
                .findFirst();
    }

    /**
     * 判断某个玩家是否在白名单中
     */
    public static boolean isWhitelisted(String playerName) {
        return getQQByPlayer(playerName).isPresent();
    }
}
