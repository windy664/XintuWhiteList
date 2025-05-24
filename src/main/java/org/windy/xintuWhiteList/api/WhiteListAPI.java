package org.windy.xintuWhiteList.api;

import org.windy.xintuWhiteList.XintuWhiteList;
import org.windy.xintuWhiteList.XintuWhiteList.WhiteListEntry;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WhiteListAPI {

    /**
     * 获取所有白名单条目
     */
    public static List<WhiteListEntry> getAllEntries() {
        return XintuWhiteList.getInstance().getWhiteListEntries();
    }

    /**
     * 根据玩家名获取完整白名单条目
     */
    public static Optional<WhiteListEntry> getEntryByPlayer(String playerName) {
        return getAllEntries().stream()
                .filter(entry -> entry.player.equalsIgnoreCase(playerName))
                .findFirst();
    }

    /**
     * 根据QQ号获取完整白名单条目
     */
    public static Optional<WhiteListEntry> getEntryByQQ(String qq) {
        return getAllEntries().stream()
                .filter(entry -> entry.qq.equals(qq))
                .findFirst();
    }

    /**
     * 根据formId获取所有相关条目
     */
    public static List<WhiteListEntry> getEntriesByFormId(String formId) {
        return getAllEntries().stream()
                .filter(entry -> entry.formId.equals(formId))
                .collect(Collectors.toList());
    }

    /**
     * 判断某个玩家是否在白名单中
     */
    public static boolean isWhitelisted(String playerName) {
        return getEntryByPlayer(playerName).isPresent();
    }

    /**
     * 添加一条白名单记录
     */
    public static boolean addEntry(String formId, String player, String code, String qq) {
        if (isWhitelisted(player)) return false;

        List<WhiteListEntry> list = getAllEntries();
        int nextIndex = list.size() + 1;

        WhiteListEntry entry = new WhiteListEntry(nextIndex, formId, player, code, qq);
        list.add(entry);
        XintuWhiteList.getInstance().saveWhiteList();
        return true;
    }

    /**
     * 根据玩家名移除条目
     */
    public static boolean removeEntryByPlayer(String playerName) {
        Optional<WhiteListEntry> opt = getEntryByPlayer(playerName);
        if (opt.isPresent()) {
            getAllEntries().remove(opt.get());
            XintuWhiteList.getInstance().saveWhiteList();
            return true;
        }
        return false;
    }
}
