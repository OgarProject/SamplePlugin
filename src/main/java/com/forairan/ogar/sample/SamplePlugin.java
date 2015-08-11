package com.forairan.ogar.sample;

import com.ogarproject.ogar.api.plugin.Plugin;
import com.ogarproject.ogar.api.plugin.PluginInfo;

@PluginInfo(
        name = "Sample Plugin",
        version = "1.0",
        author = "Forairan",
        description = "A sample plugin for Ogar 2."
)
public class SamplePlugin extends Plugin {

    @Override
    public void onDisable() {
        getLogger().info("SamplePlugin#onDisable called!");
    }

    @Override
    public void onEnable() {
        getLogger().info("SamplePlugin#onEnable called!");
        getPluginManager().registerEvents(this, new SampleListener(this));
        getLogger().info("SamplePlugin: listener registered.");
    }
}
