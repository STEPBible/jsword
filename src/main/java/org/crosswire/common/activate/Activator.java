package org.crosswire.common.activate;

import java.util.HashSet;
import java.util.Set;

/**
 * Manager for instances of Activatable.
 * 
 * Activator should be used to manage all activate()ions and deactivate()ions so
 * that it can keep a track of exactly what is active and what can be
 * deactivate()d is save memory.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public final class Activator {
    /**
     * Prevent instantiation
     */
    private Activator() {
        // singleton - no set-up needed
    }

    /**
     * Check that a subject is activated and call activate() if not.
     * 
     * @param subject
     *            The thing to activate
     */
    public static void activate(Activatable subject) {
        if (!activated.contains(subject) && subject != null) {
            subject.activate(lock);
            activated.add(subject);
        }
    }

    /**
     * If we need to tighten things up a bit we can save memory with this
     */
    public static void reduceMemoryUsage(Kill amount) {
        amount.reduceMemoryUsage();
    }

    /**
     * Deactivate an Activatable object. It is safe to activate() something and
     * then forget to deactivate() it since we keep a track of activated objects
     * and will automatically deactivate() when needed, so this method should
     * only be used when we are sure that something will not be needed again.
     * 
     * @param subject
     *            The thing to deactivate
     */
    public static void deactivate(Activatable subject) {
        if (activated.contains(subject) && subject != null) {
            subject.deactivate(lock);
            activated.remove(subject);
        }
    }

    public static void deactivateAll() {
        for (Activatable item : activated) {
            deactivate(item);
        }
    }

    /**
     * The list of things that we have activated
     */
    private static Set<Activatable> activated = new HashSet<Activatable>();

    /**
     * The object we use to prevent others from
     */
    private static Lock lock = new Lock();
}
