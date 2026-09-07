package de.ayont.lpc.api;

import org.bukkit.entity.Player;

/**
 * Public integration API exposed by LPC.
 *
 * <p>Obtain it from the enabled LPC plugin through {@code LPC#getLpcApi()}. Methods that access a
 * player must be called on that player's owning server thread, as with other Bukkit player APIs.
 */
public interface LpcApi {

    /** Returns whether sound and action-bar notifications are enabled for the player. */
    boolean areMentionNotificationsEnabled(Player player);

    /**
     * Persistently enables or disables sound and action-bar notifications for the player.
     * Mention highlighting in chat is unaffected.
     */
    void setMentionNotificationsEnabled(Player player, boolean enabled);

    /**
     * Persistently toggles sound and action-bar notifications for the player.
     *
     * @return the new enabled state
     */
    default boolean toggleMentionNotifications(Player player) {
        boolean enabled = !areMentionNotificationsEnabled(player);
        setMentionNotificationsEnabled(player, enabled);
        return enabled;
    }
}
