package model;


 /**
 * Contains information about a notification sent to accounting.
 * 
 * 
 */
public class NotifyAccountingDTO {

    private String notification;

     /**
     * Creates a new instance representing a notification.
     *
     * @param notification The notification for notyfing.
     */
    public NotifyAccountingDTO (String notification){
        this.notification = notification;
    }

    /**
     * Get the notification.
     * 
     * @return The notification.
     */
    public String getNotification () {
        return notification;
    }
}
