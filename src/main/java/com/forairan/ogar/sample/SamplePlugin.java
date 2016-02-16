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

        // Register a test listener
        getPluginManager().registerEvents(this, new SampleListener(this));

        // Run some scheduler tests
        testScheduler();

        getLogger().info("SamplePlugin: listener registered.");
    }
    
    private void testScheduler() {
        // Register a few test tasks
        getServer().getScheduler().runTaskLater(this, () -> System.out.println("runTaskLater - 20 tick delay, sync"), 20L);
        getServer().getScheduler().runAsyncTaskLater(this, () -> System.out.println("runAsyncTaskLater - 40 tick delay, async"), 40L);
        getServer().getScheduler().runTaskTimer(this, () -> System.out.println("runTaskTimer - 100 tick delay, 10 tick interval, sync"), 100L, 10L);
        getServer().getScheduler().runAsyncTaskTimer(this, () -> System.out.println("runAsyncTaskTimer - 100 tick delay, 10 tick interval, async"), 100L, 10L);
        
        // How about a misbehaving task?
        getServer().getScheduler().runTaskLater(this, () -> {
            // ;)
            System.out.println("Misbehaving task test - throwing NPE now!");
            throw new NullPointerException();
        }, 1L);
        
        // Or cancelling a task?
        int id = getServer().getScheduler().runTaskLater(this, () -> System.out.println("You should never see this message"), 20L);
        // ...using another task?
        getServer().getScheduler().runTaskLater(this, () -> getServer().getScheduler().cancelTask(id), 10L);
    }
}
