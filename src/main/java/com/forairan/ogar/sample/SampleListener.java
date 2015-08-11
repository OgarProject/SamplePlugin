package com.forairan.ogar.sample;

import com.ogarproject.ogar.api.event.EventHandler;
import com.ogarproject.ogar.api.event.Listener;
import com.ogarproject.ogar.api.event.player.PlayerConnectedEvent;
import com.ogarproject.ogar.api.event.player.PlayerConnectingEvent;
import com.ogarproject.ogar.api.event.player.PlayerDisconnectEvent;
import com.ogarproject.ogar.api.event.player.PlayerNameChangeEvent;

public class SampleListener implements Listener {

    private final SamplePlugin plugin;

    public SampleListener(SamplePlugin plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerConnecting(PlayerConnectingEvent event) {
        plugin.getLogger().info("Player is connecting! Protocol version = " + event.getProtocolVersion());
    }
    
    @EventHandler
    public void onPlayerConnected(PlayerConnectedEvent event) {
        plugin.getLogger().info("Player has connected!");
    }
    
    @EventHandler
    public void onPlayerDisconnect(PlayerDisconnectEvent event) {
        plugin.getLogger().info("Player has disconnected!");
    }

    @EventHandler
    public void onPlayerNameChange(PlayerNameChangeEvent event) {
        plugin.getLogger().info("Player has changed name to " + event.getName() + "!");
    }
}
