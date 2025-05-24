package org.windy.xintuWhiteList;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.windy.xingtuAPI.GuildMessageEvent;
public class example extends JavaPlugin implements Listener {
    @EventHandler
    public void onGuildMessage(GuildMessageEvent event) {
        String message = event.getMessage();  //当前监听内容
        String formId = event.getFormId(); //用户id
        String name = event.getGuildId(); //群ID


        event.reply("回复内容"); //对这个事件的回复内容
    }


}
