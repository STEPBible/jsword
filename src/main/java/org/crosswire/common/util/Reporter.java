package org.crosswire.common.util;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

import org.crosswire.jsword.JSMsg;
import org.slf4j.LoggerFactory;

/**
 * This package looks after Exceptions and messages as they happen. It would be
 * nice not to need this class - the principle being that any library that
 * encounters an error can throw an exception to indicate that there is a
 * problem. However this is not always the case. For example:
 * <ul>
 * <li>static class constructors should not throw, unless the class really is of
 * no use given the error, and yet we may want to tell the user that there was a
 * (non-critical) error.</li>
 * <li>Any library routine that works in a loop, applying some (potentially
 * failing) functionality, may want to continue the work without throwing in
 * response to a single error.</li>
 * <li>The class being implemented may implement an interface that disallows
 * nested exceptions and yet does not want to loose the root cause error
 * information. (This is the weakest of the above arguments, but probably still
 * valid.)</li> However in many of the times this class is used, this is the
 * reason:
 * <li>Within UI specific code - to throw up a dialog box (or whatever). Now
 * this use is currently tolerated, however it is probably a poor idea to use
 * GUI agnostic messaging in a GUI specific context. But I'm not bothered enough
 * to change it now. Specifically this use is deprecated because it makes the
 * app more susceptible to the configuration of the things that listen to
 * reports.</li>
 * </ul>
 */
public final class Reporter {
    /**
     * Enforce Singleton
     */
    private Reporter() {
    }

    /**
     * Something has gone wrong. We need to tell the user or someone, but we can
     * carry on. In general having caught an exception and passed it to
     * Reporter.informUser(), you should not throw another Exception. Called to
     * fire a commandEntered event to all the Listeners
     * 
     * @param source
     *            The cause of the problem, a Component if possible.
     * @param prob
     */
    public static void informUser(Object source, Throwable prob) {
        Class<?> cat = (source != null) ? source.getClass() : Reporter.class;
        org.slf4j.Logger templog = LoggerFactory.getLogger(cat);

        templog.warn(prob.getMessage(), prob);

        fireCapture(new ReporterEvent(source, prob));
    }

    /**
     * Something has gone wrong. We need to tell the user or someone, but we can
     * carry on. In general having caught an exception and passed it to
     * Reporter.informUser(), you should not throw another Exception. Called to
     * fire a commandEntered event to all the Listeners
     * 
     * @param source
     *            The cause of the problem, a Component if possible.
     * @param prob
     *            The Exception that was thrown
     */
    public static void informUser(Object source, LucidException prob) {
        Class<?> cat = (source != null) ? source.getClass() : Reporter.class;
        org.slf4j.Logger templog = LoggerFactory.getLogger(cat);

        templog.warn(prob.getMessage(), prob);

        fireCapture(new ReporterEvent(source, prob));
    }

    /**
     * Something has gone wrong. We need to tell the user or someone, but we can
     * carry on. In general having caught an exception and passed it to
     * Reporter.informUser(), you should not throw another Exception. Called to
     * fire a commandEntered event to all the Listeners
     * 
     * @param source
     *            The cause of the problem, a Component if possible.
     * @param prob
     *            The Exception that was thrown
     */
    public static void informUser(Object source, LucidRuntimeException prob) {
        Class<?> cat = (source != null) ? source.getClass() : Reporter.class;
        org.slf4j.Logger templog = LoggerFactory.getLogger(cat);

        templog.warn(prob.getMessage(), prob);

        fireCapture(new ReporterEvent(source, prob));
    }

    /**
     * Something has happened. We need to tell the user or someone.
     * 
     * @param source
     *            The cause of the message, a Component if possible.
     * @param message
     *            The message to pass to the user
     */
    public static void informUser(Object source, String message) {
        log.debug(message);

        fireCapture(new ReporterEvent(source, message));
    }

    /**
     * Add an Exception listener to the list of things wanting to know whenever
     * we capture an Exception
     */
    public static void addReporterListener(ReporterListener li) {
        LISTENERS.add(li);
    }

    /**
     * Remove an Exception listener from the list of things wanting to know
     * whenever we capture an Exception
     */
    public static void removeReporterListener(ReporterListener li) {
        LISTENERS.remove(li);
    }

    /**
     * Log a message.
     */
    protected static void fireCapture(ReporterEvent ev) {
        if (LISTENERS.size() == 0) {
            log.warn("Nothing to listen to report: message={}", ev.getMessage(), ev.getException());
        }

        for (ReporterListener listener : LISTENERS) {
            if (ev.getException() != null) {
                listener.reportException(ev);
            } else {
                listener.reportMessage(ev);
            }
        }
    }

    /**
     * Sets the parent of any exception windows.
     */
    public static void grabAWTExecptions(boolean grab) {
        if (grab) {
            // register ourselves
            System.setProperty(AWT_HANDLER_PROPERTY, OUR_NAME);
        } else {
            // unregister ourselves
            String current = System.getProperty(AWT_HANDLER_PROPERTY);
            if (current != null && current.equals(OUR_NAME)) {
                Properties prop = System.getProperties();
                prop.remove(AWT_HANDLER_PROPERTY);
            }
        }
    }

    /**
     * A class to handle AWT caught Exceptions
     */
    public static final class CustomAWTExceptionHandler {
        /**
         * Its important that we have a no-arg ctor to make this work. So if we
         * ever create an arged ctor then we need to add:
         * public CustomAWTExceptionHandler() { }
         */

        /**
         * Handle AWT exceptions
         */
        public void handle(Throwable ex) {
            // Only allow one to be reported every so often.
            // This interval control was needed because AWT exceptions
            // were causing recursive AWT exceptions
            // and way too many dialogs were being thrown up on the screen.
            if (gate.open()) {
                // TRANSLATOR: Very frequent error condition: The program has encountered a severe problem and it is likely that the program is unusable.
                Reporter.informUser(this, new LucidException(JSMsg.gettext("Unexpected internal problem. You may need to restart."), ex));
            }
        }

        private static TimeGate gate = new TimeGate(2000);
    }

    /**
     * The system property name for registering AWT exceptions
     */
    private static final String AWT_HANDLER_PROPERTY = "sun.awt.exception.handler";

    /**
     * The name of the class to register for AWT exceptions
     */
    private static final String OUR_NAME = CustomAWTExceptionHandler.class.getName();

    /**
     * The list of listeners
     */
    private static final List<ReporterListener> LISTENERS = new CopyOnWriteArrayList<ReporterListener>();

    /**
     * The log stream
     */
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Reporter.class);
}
